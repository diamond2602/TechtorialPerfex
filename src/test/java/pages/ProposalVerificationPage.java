package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(xpath = "//a[@class='td-proposal-url-subject' and contains(text(), 'Test')]")
    List<WebElement> proposalList;

    @FindBy(xpath = "//a[@class='td-proposal-url-subject' and contains(text(), 'Test')]/parent::td/following-sibling::td[@data-order='300.30']")
    List<WebElement> priceList;

    @FindBy(xpath = "//a[@class='td-proposal-url']")
    List<WebElement> listOfProposalIds;

    @FindBy(className = "proposal-html-number")
    WebElement h4Element;

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


    public void verifyPageTitle(String expectedTitle){

        String actualtitle = driver.getTitle();
        Assert.assertEquals("Page title doesn't match the expected title", actualtitle, expectedTitle);
    }

    public void clickOnProposal() {
        proposalBtn.click();
//        for (WebElement element : headerList) {
//            String actualButtonText = BrowserUtils.getText(element);
//            if (actualButtonText.equals(expectedHeaderBtn)) {
//                element.click();
//            break;
//        }
    }

    public void verifyNeededProposal(){

        for(WebElement neededProposal: proposalList){
            if(neededProposal.getText().contains("almaz")){
                neededProposal.isDisplayed();
            }
        }
    }
    public void verifyProposalPrice(){

        for(WebElement neededPrice: priceList) {
            if (neededPrice.getText().contains("$300.30")) {
                neededPrice.isDisplayed();
            }
        }
    }

    public void saveAndClickProposalId(String proposalId) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfProposalIds));

        WebElement targetProposal = null;

        for(WebElement eachId: listOfProposalIds){

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

    public void verifyFourHElement(String proposalId) {

        String hFourElement = h4Element.getText();
        String extractedValue = hFourElement.split("\\s+")[1];

        if(extractedValue.equals(proposalId)){
            System.out.println("Success. Element is within h4");
        }
        else{
            System.out.println("Element was not found");
        }
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





