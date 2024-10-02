package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveProjectTest extends BaseApiTest {

    private static final int VALID_PROJECT_ID = 1; // Replace with a valid project ID in your TestRail

    @Test
    public void testGetValidProject() {
        // Positive GET test: Fetch a valid project
        Response response = projectService.getGeneralProject(VALID_PROJECT_ID);

        // Validate the response status code and ensure the body contains expected data
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK, "Expected status code 200");
        Assert.assertTrue(response.getBody().asString().contains("id"), "Response does not contain project id");
    }
}
