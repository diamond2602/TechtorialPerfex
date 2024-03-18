package stepdefinitions.apisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.ConfigReader;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class GetCustomerSteps {

    Response response;

    @Given("user have baseuri and endpoint {string}")
    public void userHaveBaseuriAndEndpoint(String endpoint) {
        RestAssured.baseURI = ConfigReader.readProperty("baseuri_api");
        RestAssured.basePath = endpoint;
    }

    @When("the user sends the {string} request")
    public void theUserSendsTheRequest(String requestType) {
        switch (requestType){
            case "GET":
                response=given()
                        .header("authtoken", ConfigReader.readProperty("token"))
                        .when().get();
                break;
        }
    }

    @Then("user verifies status code is {int}")
    public void user_verifies_status_code_is(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("verifies number of values is {int}")
    public void verifies_number_of_values_is(Integer numsOfValues) {
        response.then().body("size()", is(numsOfValues));
    }

    @Then("verifies that the response contains the following user IDs: [{int}, {int}, {int}, {int}, {int}]")
    public void verifies_that_the_response_contains_the_following_user_i_ds(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5) {
        List<String> userIds = response.jsonPath().getList("userid");
        List<Integer> ids = Arrays.asList(int1, int2, int3, int4, int5);
        for (Integer id : ids) {
            System.out.println(id);
            Assert.assertTrue(userIds.contains(String.valueOf(id)));
        }
    }

    @Then("verifies that response is alphabetically ordered by company name")
    public void verifies_that_response_is_alphabetically_ordered_by_company_name() {
    List<String> companyNames = response.jsonPath().getList("company");
        boolean isOrdered = true;
        for (int i = 0; i < companyNames.size() - 1; i++) {
            if (companyNames.get(i).compareToIgnoreCase(companyNames.get(i + 1)) > 0) {
                isOrdered = false;
                break;
            }
        }
        if (isOrdered) {
            System.out.println("Companies are alphabetically sorted");
        } else {
            System.out.println("Companies are not alphabetically sorted");
        }
    }

}
