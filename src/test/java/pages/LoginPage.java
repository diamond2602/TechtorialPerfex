package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//div[@class='text-center alert alert-danger']")
    WebElement errorMessage;

    public void login(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public boolean isLoginVisible() {
        return loginButton.isDisplayed();
    }

    public void errorMessageAndColor(String expectedMessage, String expectedColor) {
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(errorMessage));
        Assert.assertEquals(expectedColor, errorMessage.getCssValue("color"));

    }
}

