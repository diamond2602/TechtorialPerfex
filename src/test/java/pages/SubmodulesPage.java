package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class SubmodulesPage {

    private WebDriver driver;

    public SubmodulesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Sales')]")   //ul[contains(@class,'nav nav-second-level collapse in')]
    private WebElement salesDropDown;

    @FindBy(xpath = "//ul[contains(@class,'nav nav-second-level collapse in')]//li[contains(@class,'sub-menu-item')]")
    private List<WebElement> listOfSubmodules;

    public void clickOnSalesButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(salesDropDown)).click();


    }
    public void getListOfSubmodules() {
        int expectedNumberOfSubmodules = 6;
        Assert.assertEquals("Quantity is not matching", expectedNumberOfSubmodules, listOfSubmodules.size());
    }

    public void validateTheRightOrder(){
        String[] expectedSubmodulesOrder = {"Proposals", "Estimates", "Invoices", "Payments", "Credit Notes", "Items"};

        for (int i = 0; i < expectedSubmodulesOrder.length; i++) {
            String actualSubmoduleName = listOfSubmodules.get(i).getText();
            Assert.assertEquals("Submodule order is incorrect", expectedSubmodulesOrder[i], actualSubmoduleName);
        }
    }
}
