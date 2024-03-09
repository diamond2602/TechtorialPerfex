package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.ConfigReader;

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

    public void login(String userInfo){
        switch (userInfo){
            case "employee":
                email.sendKeys(ConfigReader.readProperty("employee_username"));
                password.sendKeys(ConfigReader.readProperty("employee_password"));
                break;
            case "customer":
                email.sendKeys(ConfigReader.readProperty("customer_username"));
                password.sendKeys(ConfigReader.readProperty("customer_password"));
                break;

        }loginButton.click();
    }
//    public void selectUrl(String URL){
//        switch (URL){
//            case "employee_url":
//                driver.navigate().to(ConfigReader.readProperty("employee_techtorial_CRM_URL"));
//                break;
//            case  "customer_url":
//                driver.navigate().to(ConfigReader.readProperty("customer_techtorial_url"));
//                break;
//        }
//    }

}

