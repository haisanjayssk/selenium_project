package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiTestSteps {

    private Response response;

    @Given("I send a GET request to {string}")
    public void sendGetRequest(String endpoint) {
        response = RestAssured
            .given()
            .baseUri("https://jsonplaceholder.typicode.com")
            .when()
            .get(endpoint)
            .then()
            .extract()
            .response();
            System.out.println("Response: " + response.asString());
    }

    @Then("the response status code should be {int}")
    public void verifyResponseStatusCode(int statusCode) {
        assertEquals(statusCode, response.getStatusCode(), "Response status code mismatch.");
    }

    @Then("the response should contain {string}")
    public void verifyResponseContains(String key) {
        assertTrue(response.getBody().asString().contains(key), "Response does not contain key: " + key);
    }
}
