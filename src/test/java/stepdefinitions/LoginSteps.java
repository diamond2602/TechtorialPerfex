package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginSteps {
      WebDriver driver = DriverHelper.getDriver();
      LoginPage loginPage = new LoginPage(driver);

//    @Given("User login to to page with valid credentials") **ALMAZ
//    public void user_login_to_to_page_with_valid_credentials() {
//    loginPage.login(ConfigReader.readProperty("email_address"), ConfigReader.readProperty("password"));
//    Assert.assertTrue(driver.getTitle().equals("Dashboard"));
//    }
    @Given("User validates the title is {string} from LoginPage")
    public void user_validates_the_title_is_from_login_page(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle().trim() );
}
    @Given("User validates the Log In is visible on the page")
    public void user_validates_the_log_in_is_visible_on_the_page() {
        Assert.assertTrue(loginPage.isLoginVisible());
    }
    @When("User provides email_address and password to the loginPage")
    public void user_provides_email_address_and_password_to_the_login_page() {
        loginPage.login(ConfigReader.readProperty("email_address"),
                ConfigReader.readProperty("password"));
    }
    @Then("User validates the title {string} from MainPage")
    public void user_validates_the_title_from_main_page(String expectedTitle) {
        Assert.assertTrue(driver.getTitle().trim().contains(expectedTitle));
    }
    @When("User provides {string} and {string} to the loginPage")
    public void user_provides_and_to_the_login_page(String email, String password) {
        loginPage.login(email, password);
    }
    @Then("User validates the title {string} and {string} from loginPage")
    public void user_validates_the_title_and_from_login_page(String errorMessage, String expectedColor) {
        loginPage.errorMessageAndColor(errorMessage,expectedColor);
    }


}
