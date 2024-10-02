package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.AuthService;
import configuration.ReadProperties;

public class PositiveGetAuthTest extends BaseApiTest {

    @Test
    public void testGetProjects() {
        AuthService authService = new AuthService();

        // Pass username and API key for authentication
        String username = ReadProperties.username();
        String apiKey = ReadProperties.password(); // Assuming you stored the API key in the password field

        // Attempt to get projects
        Response response = authService.getProjects(username, apiKey);

        // Validate the response status code
        Assert.assertEquals(response.statusCode(), 200, "Expected status code 200");
        // Validate the response body (you can add more assertions based on your needs)
        Assert.assertTrue(response.getBody().asString().contains("id"), "Response does not contain project ID");
    }
}
