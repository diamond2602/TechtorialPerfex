package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginSteps {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("User login to to page with valid credentials")
    public void user_login_to_to_page_with_valid_credentials() {
        loginPage.login(ConfigReader.readProperty("email_address"), ConfigReader.readProperty("password"));
        Assert.assertTrue(driver.getTitle().equals("Dashboard"));
    }
}
