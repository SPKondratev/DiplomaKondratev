package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class BoundaryValueTest extends BaseTest {

    @Test
    public void BoundaryValue249() {
        {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setEmailValue("111111111122222222223333333333444444444455555555556666666666777777777788888888889999999999000000000011111111112222222222333333333344444444445555555555666666666677777777778888888888999999999900000000001111111111222222222233333333334444444444555555249");
            loginPage.clickLogin();
            Assert.assertTrue(driver.findElement(By.xpath("//loginpage-message-image loginpage-message ")).isDisplayed());
        }
    }
    @Test
    public void BoundaryValue250() {
        {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setEmailValue("1111111111222222222233333333334444444444555555555566666666667777777777888888888899999999990000000000111111111122222222223333333333444444444455555555556666666666777777777788888888889999999999000000000011111111112222222222333333333344444444445555555250");
            loginPage.clickLogin();

            loginPage.setEmailValue("1111111111222222222233333333334444444444555555555566666666667777777777888888888899999999990000000000111111111122222222223333333333444444444455555555556666666666777777777788888888889999999999000000000011111111112222222222333333333344444444445555555250");
            loginPage.clickLogin();
            Assert.assertTrue(driver.findElement(By.xpath("//loginpage-message-image loginpage-message ")).isDisplayed());
        }

    }
    @Test
    public void BoundaryValue251() {
        StringBuilder login = new StringBuilder();
        for(int i =0; i<252;i++)
            login.append('1');
        System.out.println(login.length());
        {

            LoginPage loginPage = new LoginPage(driver);
            loginPage.setEmailValue(String.valueOf(login.length()));
            loginPage.clickLogin();
            Assert.assertEquals(userStep.incorrectOnlyLogin(login.toString())
                    .getErrorTextElement().getText(), "Field Email/User is too long (250 characters at most).");
        }
    }}