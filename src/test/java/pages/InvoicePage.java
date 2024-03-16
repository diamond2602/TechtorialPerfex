package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class InvoicePage {

    public InvoicePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[@class='label label-danger  s-status invoice-status-1']")
    WebElement redUnpaidLabel;
    @FindBy(xpath = "//h4//span[contains (text(), 'INV-')]")
    WebElement recordHeader;
    @FindBy(xpath = "//label[contains(.,'Invoice Number')]//..//input")
    WebElement invoiceNumberInInvoiceSection;

    public void verifyUnpaidStatus(String unpaidStatus){
        Assert.assertEquals(unpaidStatus, BrowserUtils.getText(redUnpaidLabel));
    }

    public void verifyRecordHeaderStartsWithINVAndMatchesInvoiceNumber(String recordNameBegins){
        Assert.assertTrue(BrowserUtils.getText(recordHeader).contains(recordNameBegins));
        Assert.assertTrue(BrowserUtils.getText(recordHeader).contains(BrowserUtils.getText(invoiceNumberInInvoiceSection)));

    }



}
