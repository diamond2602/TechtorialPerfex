package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.SubmodulesPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class VerifySubmodulesSteps {

    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    SubmodulesPage submodulesPage;


    @When("employee enters correct login and password")
    public void employee_enters_correct_login_and_password() {
        loginPage.login(ConfigReader.readProperty("email_address"), ConfigReader.readProperty("password"));

    }
    @When("the employee clicks on Sales button in navigation menu from lest side")
    public void the_employee_clicks_on_sales_button_in_navigation_menu_from_lest_side() {
        submodulesPage = new SubmodulesPage(driver);
        submodulesPage.clickOnSalesButton();

    }
    @When("Employee can see all submodules and check their quantity")
    public void employee_can_see_all_submodules_and_check_their_quantity() {
        submodulesPage.getListOfSubmodules();

    }
    @Then("Employee can verify the right order of given submodules")
    public void employee_can_verify_the_right_order_of_given_submodules() {
        submodulesPage.validateTheRightOrder();

    }
}
