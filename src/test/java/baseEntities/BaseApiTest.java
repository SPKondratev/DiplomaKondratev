package baseEntities;

import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import services.ProjectService;
import services.UserService;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected ProjectService projectService;
    protected UserService userService;


    @BeforeTest
    public void setupApiClient() {

        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());

        projectService = new ProjectService();
        userService = new UserService();
    }
}
