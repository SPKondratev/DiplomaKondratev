package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeProjectsTest extends BaseApiTest {

    @Test
    public void testGetAllProjectsNegative() {
        String invalidEndpoint = "/index.php?/api/v2/get_projects_invalid"; // Invalid endpoint

        // Attempt to fetch all projects using the invalid endpoint
        Response response = projectService.getAllProjects(invalidEndpoint); // Assuming a method is defined in ProjectService

        // Validate the response status code
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_NOT_FOUND, "Expected status code 404 for invalid endpoint");
    }
}