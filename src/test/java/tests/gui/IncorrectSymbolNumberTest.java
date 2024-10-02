package tests.gui;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IncorrectSymbolNumberTest extends BaseTest {

    @Test
    public void IncorrectSymbolNumber() {
        StringBuilder login = new StringBuilder();
        for(int i =0; i<255;i++)
        {
            login.append('1');
        }
        System.out.println(login.length());

        Assert.assertEquals(userStep.incorrectOnlyLogin(login.toString())
                .getErrorTextElement().getText(), "Field Email/User is too long (250 characters at most).");
    }
}