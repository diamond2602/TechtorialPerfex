package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class ProposalPage {
    public ProposalPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "subject")
    WebElement subject;

    @FindBy(id = "rel_type")
    WebElement related;

    @FindBy(xpath = "//div[contains(text(),'Select and begin typing')]")
    WebElement customer;

    @FindBy(xpath = "//input[@placeholder='Type to search...']")
    WebElement typeToSearch;

    @FindBy(xpath = "//a[@id='bs-select-13-0']")
    WebElement CustomerName;


    public void addSubject(String subjectMessage) {
        subject.sendKeys(subjectMessage);

    }

    public void selectRelated(String relatedChoise) {
        BrowserUtils.selectBy(related, relatedChoise, "text");
    }

    public void selectCustomer(String customerSearchName, String customerName) {
        customer.click();
        typeToSearch.sendKeys(customerSearchName);
        CustomerName.sendKeys(customerName);

    }
}
