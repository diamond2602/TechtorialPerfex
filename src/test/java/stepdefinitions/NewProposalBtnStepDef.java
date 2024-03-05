package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.NewProposalPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class NewProposalBtnStepDef {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);

    NewProposalPage proposalPage = new NewProposalPage(driver);
    @Given("User provides username and password to the loginPage")
    public void user_provides_username_and_password_to_the_login_page() {
        loginPage.login(ConfigReader.readProperty("email_address"), ConfigReader.readProperty("password"));

    }

    @When("User clicks Sales Module Button and user clicks Proposals Module Button")
    public void user_clicks_sales_module_button_and_user_clicks_proposals_module_button() {

        mainPage.saleBtn();
        mainPage.proposalBtn();

    }

    @Then("User validates that there a button New Proposal and background-color is {string}")
    public void user_validates_that_there_a_button_new_proposal_and_background_color_is(String expectedColor) {

       Assert.assertTrue(proposalPage.btnIsVisible());
       proposalPage.colorValidation(expectedColor);



    }


}
