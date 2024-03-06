package pages;

import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;

public class ProposalPage {
    public ProposalPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "subject")
    WebElement subject;

    @FindBy(id = "rel_type")
    WebElement related;

    @FindBy(xpath = "//a[@role='option']")
    WebElement AllRelatedChoices;

    @FindBy(xpath = "//div[contains(text(),'Select and begin typing')]")
    WebElement customerSearch;

    @FindBy(xpath = "//input[@placeholder='Type to search...']")
    WebElement typeToSearch;

    @FindBy(xpath = "//a[@id='bs-select-13-0']")
    WebElement CustomerName;

    @FindBy(xpath = "//div[@id='bs-select-13']//span[@class='text']")
    //@FindBy(xpath = "//select[@id=\"rel_id\"]")
    List<WebElement> allCustomerNamesAfterSearch;


    @FindBy(xpath = "//button[@data-id=\"project_id\"]")
    WebElement projectSearch;

    //@FindBy(xpath = "//div[@id=\"bs-select-26\"]/preceding-sibling::div[@class=\"bs-searchbox\"]")
    @FindBy(xpath = "//*[@id=\"project_ajax_search_wrapper\"]/div/div/div[1]/input")
    WebElement projectTypeToSearch;

    @FindBy(xpath = "//div[@id='bs-select-16']//span[@class='text']")
    List<WebElement> allProjectNamesAfterSearch;

    @FindBy(xpath = "//div[contains(text(),'Add Item')]")
    WebElement addItemButton;

    @FindBy(xpath = "//li[@class=\"optgroup-1\"]//span[@class=\"text\"]")
    List<WebElement> allItems;

    @FindBy(xpath = "//i[@class=\"fa fa-check\"]")
    WebElement blueButton;


    @FindBy(xpath = "//input[@name=\"quantity\"]")
    WebElement quantity;

    @FindBy(xpath = "//td[@class=\"total\"]")
    WebElement total;

    @FindBy(xpath = "//button[contains(text(),'Save & Send')]")
    WebElement saveAndSendButton;

    @FindBy(xpath = "//a[@class='btn btn-primary pull-left display-block new-proposal-btn']")
    WebElement NewProposalButton ;

    public void addSubject(String subjectMessage) {
        subject.sendKeys(subjectMessage);

    }

    @FindBy(xpath = "//td")
    List<WebElement> allCreatedProposalsDetails;

    public void selectRelated(String relatedChoise) {
        BrowserUtils.selectBy(related, relatedChoise, "text");
    }

    public void selectCustomer(String customerSearchName, String customerName) throws InterruptedException {
        customerSearch.click();
        typeToSearch.sendKeys(customerSearchName);
        Thread.sleep(1000);
        //  CustomerName.sendKeys(customerName);
        for (WebElement customer : allCustomerNamesAfterSearch) {
            if (BrowserUtils.getText(customer).equals(customerName)) {
                customer.click();
                // BrowserUtils.selectBy(customer,customerName, "text");
                break;
            }
        }

    }

    public void selectProject(String projectSearchName, String projectName) throws InterruptedException {
        projectSearch.click();
        Thread.sleep(500);
        projectTypeToSearch.sendKeys(projectSearchName);
        Thread.sleep(1000);
        for (WebElement project : allProjectNamesAfterSearch) {
            if (BrowserUtils.getText(project).equals(projectName)) {
                project.click();
                // BrowserUtils.selectBy(customer,customerName, "text");
                break;
            }
        }
    }

    public void clickAddItem() {
        addItemButton.click();
    }

    public void selectItem(String itemName) throws InterruptedException {
        Thread.sleep(500);
        clickAddItem();
        Thread.sleep(1000);
        for (WebElement item : allItems) {
            if (BrowserUtils.getText(item).contains(itemName)) {
                item.click();
                System.out.println(item.getText());
                break;
            }
        }
    }

    public void clickBlueButton(WebDriver driver) {
        BrowserUtils.scrollWithJS(driver, blueButton);
        blueButton.click();

    }

    public void changeQuantity(String quantity) throws InterruptedException {
        Thread.sleep(500);
        this.quantity.clear();
        Thread.sleep(500);
        this.quantity.sendKeys(quantity);
        Thread.sleep(500);
        subject.click();//clicking this place just to update quantity,
        // this needs better implementation

    }

    public String getTotal() throws InterruptedException {
        Thread.sleep(500);
        return this.total.getText();

    }

    public void clickSaveAndSend() {
        saveAndSendButton.click();
    }

    public boolean btnIsVisible(){

        return NewProposalButton.isDisplayed();
    }

    public void colorValidation(String expectedColor){
        Assert.assertEquals(expectedColor,NewProposalButton.getCssValue("background-color"));
    }

    public void validateAddedProposal(String status) {
        List<String> allDetails = new ArrayList<>();
        for (int i = 0; i < allCreatedProposalsDetails.size(); i++) {
            allDetails.add(allCreatedProposalsDetails.get(i).getText());
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> currentGroup = new ArrayList<>();

        for (String detail : allDetails) {
            currentGroup.add(detail); // Add the sentence to the current group

            if (currentGroup.size() == 5) { // If the current group contains 5 sentences
                result.add(currentGroup); // Add it to the result
                currentGroup = new ArrayList<>(); // Create a new group
            }
        }

        Assert.assertEquals(status, result.get(0).get(4));

    }
}
