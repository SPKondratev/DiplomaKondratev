package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositivePostTest extends BaseApiTest {

    @Test
    public void testCreateTestRun() {
        int projectId = 1;
        String testRunName = "API Test Run";

        Response response = projectService.createTestRun(projectId, testRunName);

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK, "Status code is not 200");
        Assert.assertTrue(response.getBody().asString().contains("id"), "Response does not contain test run id");

        int testRunId = response.jsonPath().getInt("id");

        String testRunLink = String.format("https://dziatkokondratev.testrail.io/index.php?/runs/view/%d", testRunId);

        System.out.println("Test Run Link: " + testRunLink);

        Assert.assertTrue(testRunLink.contains("/runs/view/"), "Test run link is not formed correctly");
    }
}