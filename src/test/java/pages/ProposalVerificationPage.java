package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class ProposalVerificationPage {

    private WebDriver driver;

    public ProposalVerificationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Techtorial CRM')]")
    WebElement pageTitle;

    @FindBy(xpath = "//li[@class='customers-nav-item-proposals']")
    WebElement proposalBtn;

    @FindBy(css = ".td-proposal-url-subject")
    List<WebElement> proposalList;

    //a[@class='td-proposal-url-subject' and contains(text(), 'Test')]/parent::td/following-sibling::td[@data-order='300.30']"
    @FindBy(xpath = "//td[@data-order='300.30']")
    List<WebElement> priceList;

    @FindBy(css = ".td-proposal-url")
    List<WebElement> listOfProposalIds;

    @FindBy(xpath = "//tr")
    List<WebElement> rows;

    @FindBy(xpath = "//h4[contains(text(),'PRO')]")
    WebElement h4;

    @FindBy(css = "td.description")
    List<WebElement> laptopInfo;

    @FindBy(id = "accept_action")
    WebElement acceptBtn;

    @FindBy(xpath = "//button[@class='btn btn-success']")
    WebElement signBtn;

    @FindBy(xpath = "//p[contains(text(), 'Please sign the document.')]")
    WebElement redAlert;

    @FindBy(className = "signature-pad--body")
    WebElement signatureField;

    @FindBy(xpath = "//span[@class='label label-success tw-ml-4']")
    WebElement acceptLabel;

    public String proposalId;



    public void verifyPageTitle(String expectedTitle){


        String actualtitle = driver.getTitle();
        Assert.assertEquals("Page title doesn't match the expected title", actualtitle, expectedTitle);
    }

    public void clickOnProposal() {
        proposalBtn.click();

    }

    public void verifyNeededProposal(String proposalTitle){
        for(WebElement neededProposal: proposalList){
            if(neededProposal.getText().contains(proposalTitle)){
                Assert.assertEquals(BrowserUtils.getText(neededProposal), proposalTitle);
            }
        }
    }
    public void verifyProposalPrice(String price){
        for(WebElement neededPrice: priceList) {
            if (neededPrice.getText().contains(price)) {
                Assert.assertEquals(BrowserUtils.getText(neededPrice), price);
            }
        }
    }

    public void saveAndClickProposalId(String proposalId) {

//        for (int i =1;i<= rows.size();i++) {
//            WebElement subjectElement = rows.get(i).findElement(By.cssSelector(".td-proposal-url-subject"));
//            if (subjectElement.getText().equals(proposalId)) {
//                WebElement proposalNumberElement = rows.get(i).findElement(By.cssSelector(".td-proposal-url"));
//                proposalId = proposalNumberElement.getText();
//                System.out.println("Proposal number found: " + proposalId);
//                break;
//            }
//        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(proposalList));
        WebElement targetProposal = null;

        for(WebElement eachId: proposalList){
            if(eachId.getText().contains(proposalId)){
                targetProposal = eachId;
                break;
            }
        }
        if (targetProposal != null) {
            targetProposal.click();
        } else {
            System.out.println("Matching proposal not found.");
        }
    }

    public void verifyFourHElement() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(h4.isDisplayed());
    }

    public void verifyFirstItem(String firstItem) {
        for(WebElement firstProductInfo: laptopInfo){
            if(firstProductInfo.equals(firstItem)){
                firstProductInfo.isDisplayed();
            }
        }
    }

    public void verifySecondItem(String secondItem){
        for(WebElement firstProductInfo: laptopInfo){
            if(firstProductInfo.equals(secondItem)){
                firstProductInfo.isDisplayed();
            }
        }
    }
    public  void verifyAcceptButton() {
        acceptBtn.isDisplayed();
    }

    public void clickOnAccept() {
        acceptBtn.click();
    }

    public void clickOnSign() throws InterruptedException {
        Thread.sleep(500);
        signBtn.click();
    }

    public void redMessageAlert(String alertMessage) {
        redAlert.isDisplayed();
        Assert.assertEquals("Alert mismatch", redAlert.getText(), alertMessage);
    }

    public void signingTheCanvas() {
        Actions actions = new Actions(driver);
        actions.moveToElement(signatureField)
                .moveByOffset(50, 50)
                .clickAndHold()
                .moveByOffset(70, 0) // Move horizontally by the offset
                .moveByOffset(0, 70) // Move vertically by the offset
                .release()
                .perform();

    }

    public void validateAcceptLabel() {
        acceptLabel.isDisplayed();
    }

}





