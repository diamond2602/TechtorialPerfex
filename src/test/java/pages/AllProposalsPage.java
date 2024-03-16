package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class AllProposalsPage {

    public AllProposalsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //--------------------Elements copied from Proposal Page, as I realize that it is 2 different pages--------------------
    @FindBy(xpath = "//select[@class='form-control input-sm']")
    WebElement tableLengthList;

    @FindBy(xpath = "//th[contains(text(), 'Status')]//..//..//..//..//tbody//tr//td[10]//span")
    List<WebElement> allStatusesList;

    @FindBy(xpath= "//th[contains(text(), 'Subject')]//..//..//..//..//tbody//tr//td[2]//a")
    List<WebElement> subjectProposalsName;

    @FindBy(xpath = "//div[@class = 'col-md-3']//span")
    WebElement statusWhenClickedOnProposal;

    //--------------------Elements copied from Proposal Page, as I realize that it is 2 different pages--------------------

    @FindBy(xpath = "//input[@id = 'search_input']")
    WebElement searchBar;

    @FindBy(xpath = "//ul[@id = 'top_search_dropdown']//li//a")
    List<WebElement> searchBarList;

    @FindBy(xpath = "//h5//a")
    WebElement nameOfProposal;

    @FindBy(xpath = "//h4[contains (text(), 'This proposal is related to project: ')]//a")
    WebElement nameOfProject;

    @FindBy(xpath = "//span[@id = 'proposal-number']")
    WebElement proposalNumberWhenClickedOnProposal;

    @FindBy(xpath = "//a[contains (text(), 'PRO')]")
    List<WebElement> proposalNumbersList;

    @FindBy(xpath = "//a[contains (text(),'Comments')]")
    WebElement commentsTab;

    @FindBy(xpath = "//textarea[@id = 'comment']")
    WebElement commentTextArea;

    @FindBy(xpath = "//button[contains (text(), 'Add Comment')]")
    WebElement addCommentButton;

    @FindBy(xpath = "//div[@class='tw-mt-3']")
    WebElement addedCommentMessage;

    @FindBy(xpath = "//span[@class= 'badge total_comments']")
    WebElement numberOfComments;

    @FindBy(xpath = "//button[contains (text(), 'Convert')]")
    WebElement convertButton;

    @FindBy(xpath = "//a[contains (text(), 'Invoice')]")
    WebElement invoiceButton;

    //--------------------Methods copied from Proposal Page, as I realize that it is 2 different pages--------------------

    public void setTableLengthList (String allOption){
        BrowserUtils.selectBy(tableLengthList, allOption, "text" );
    }

    public void locateAndVerifyStatus(String nameOfPromotion, String acceptedStatus1) throws InterruptedException {
        boolean proposalExist = false;
        for(WebElement name: subjectProposalsName){
            Thread.sleep(2000);
            if (BrowserUtils.getText(name).equals(nameOfPromotion)){
                for(WebElement status: allStatusesList){
                    Assert.assertEquals(acceptedStatus1, BrowserUtils.getText(status));
                    break;
                }
                name.click();
                Thread.sleep(3000);
                Assert.assertEquals(acceptedStatus1, BrowserUtils.getText(statusWhenClickedOnProposal));
                proposalExist= true;
                break;
            }else {
                Assert.assertTrue("Proposal not found: " + nameOfPromotion, proposalExist);
            }
        }
    }

    //--------------------Methods copied from Proposal Page, as I realize that it is 2 different pages--------------------

    public void searchForProposal(String nameOfProposal) throws InterruptedException {
        searchBar.sendKeys(nameOfProposal);
        Thread.sleep(3000);
        for (WebElement name: searchBarList){
            if (BrowserUtils.getText(name).contains(nameOfProposal)) {
                name.click();
            }
        }
    }

    public void verifySubjectNameAndStatus (String subject, String projectName, String status){
        Assert.assertEquals(subject, BrowserUtils.getText(nameOfProposal));
        Assert.assertEquals(projectName, BrowserUtils.getText(nameOfProject));
        Assert.assertEquals(status,BrowserUtils.getText(statusWhenClickedOnProposal));
    }

    public void clickOnProposalIdFromProposalNumber() throws InterruptedException {
        //boolean proposalExist = false;
        for (WebElement eachProposalNumber:proposalNumbersList) {
            if (BrowserUtils.getText(eachProposalNumber).equals(BrowserUtils.getText(proposalNumberWhenClickedOnProposal))){
                //    proposalExist = true;
                //Thread.sleep(3000);
                eachProposalNumber.click();
            }
            break;
            // else {
//               Assert.assertTrue("Proposal # is not found: " + BrowserUtils.getText(eachProposalNumber), proposalExist);
//            }
        }
    }

    public void clickOnCommentsTabAndAddComment(String commentMessage) throws InterruptedException {
        commentsTab.click();
        commentTextArea.sendKeys(commentMessage);
        addCommentButton.click();
        Thread.sleep(5000);
    }
    public void verifyCommentWasAdded (String expectedCommentMessage, String numberOfCommentsAdded) throws InterruptedException {
        commentsTab.click();
        Assert.assertTrue(addedCommentMessage.isDisplayed());
        Assert.assertEquals(expectedCommentMessage, BrowserUtils.getText(addedCommentMessage));
        Assert.assertEquals(numberOfCommentsAdded, BrowserUtils.getText(numberOfComments));
    }

    public void clickConvertAndInvoiceButtons(){
        convertButton.click();
        invoiceButton.click();
    }

}
