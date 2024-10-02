package services;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class AuthService {

    public Response getProjects(String username, String apiKey) {
        Response response = given()
                .auth().preemptive().basic(username, apiKey) // Basic Auth with API key
                .when()
                .get(Endpoints.GET_PROJECTS) // This should be the correct endpoint for getting projects
                .then()
                .extract().response();

        System.out.println("Response Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        return response;
    }
}