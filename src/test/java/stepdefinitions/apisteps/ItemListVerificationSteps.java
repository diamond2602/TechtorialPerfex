package stepdefinitions.apisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ConfigReader;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class ItemListVerificationSteps {

    Response response;

    @Given("user have base uri and endpoint {string}")
    public void userHaveBaseUriAndEndpoint(String endpoint) {
        RestAssured.baseURI = ConfigReader.readProperty("baseuri_api");
        RestAssured.basePath = endpoint;

    }

    @And("user set the header {string} and send {string} request")
    public void userSetTheHeaderAndSendRequest(String token, String requestType) {
        switch (requestType) {
            case "GET":
                response = given()
                        .header("authtoken", ConfigReader.readProperty("token"))
                        .when().get();
                break;
        }
    }

    @When("verify that the response status code is {int}")
    public void verify_that_the_response_status_code_is(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @When("verify that the response contains {int} items")
    public void verify_that_the_response_contains_items(Integer itemsSize) {
        response.then().body("size()", is(itemsSize));
    }

    @When("verify the item with ID {int} have the name {string}")
    public void verify_the_item_with_id_have_the_name(int itemID, String itemName) {
        List<String> ids = response.jsonPath().getList("id");
        for (String id : ids) {
            if (Integer.parseInt(id) == itemID) {
                String name = response.jsonPath().getString("name");
                if (name != null && name.contains(itemName)) {
                    System.out.println("Validation passed: Name contains '(10.00) Ethernet Cable'");
                } else {
                    System.out.println("Validation failed: Name does not contain '(10.00) Ethernet Cable'");
                }
                break;
            }
        }
    }
}