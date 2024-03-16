package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class ConvertToInvoicePage {
    public ConvertToInvoicePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text(),'Apple LLC')]")
    WebElement customerValue;
    //"//label[text() = 'Customer']//..//div[@class = 'filter-option-inner-inner']"
    @FindBy(xpath = "//button[@class = 'btn btn-primary invoice-form-submit transaction-submit']")
    WebElement saveButton;

    public void verifyCustomer(String appleLLCCustomer){
        Assert.assertEquals(appleLLCCustomer, BrowserUtils.getText(customerValue));
    }
    public void scrollDownAndClickSave(WebDriver driver){
        BrowserUtils.scrollWithJS(driver, saveButton);
        saveButton.click();
    }

}
