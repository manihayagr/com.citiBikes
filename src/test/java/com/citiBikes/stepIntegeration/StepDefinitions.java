package com.citiBikes.stepIntegeration;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.CoreMatchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class StepDefinitions {
    private String baseUri;
    private String absUrl;;
    RestAssured restAssured;
    Response response;
    RequestSpecification request;
    int responseCode;
    ResponseBody<?> respBody;


    @Given("I want to get the citiBikes location")
    public void iWantToGetTheCitiBikesLocation() {
        baseUri="http://api.citybik.es/v2";
        request = RestAssured.given().log().all().config(RestAssuredConfig.config().encoderConfig(
                RestAssured.config().getEncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)));
    }

    @When("I send request with {string}")
    public void iSendRequestWith(String absUrl) {
        response = request.baseUri(baseUri).when().request(Method.GET,absUrl).then().log().all().extract().response();
        respBody = response.getBody();
    }


    @Then("I get the successful response {int}")
    public void iGetTheSuccessfulResponse(int respCode) {
        responseCode = response.getStatusCode();
        assertThat(responseCode, CoreMatchers.is(respCode));
    }

    @Then("I am looking for the {string}")
    public void iAmLookingForThe(String cityName) {


    }

    @And("I got the details for it")
    public void iGotTheDetailsForIt() {
    }


    @When("I send request with {string} with QueryParm {string}")
    public void iSendRequestWithWithQueryParm(String arg0, String arg1) {
    }
}
