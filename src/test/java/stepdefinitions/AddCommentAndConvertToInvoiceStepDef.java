package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AllProposalsPage;
import pages.ConvertToInvoicePage;
import pages.InvoicePage;
import pages.ProposalPage;
import utils.DriverHelper;

public class AddCommentAndConvertToInvoiceStepDef {

    WebDriver driver = DriverHelper.getDriver();
    ProposalPage proposalPage = new ProposalPage(driver);
    AllProposalsPage allProposalsPage = new AllProposalsPage(driver);
    ConvertToInvoicePage convertToInvoicePage = new ConvertToInvoicePage(driver);
    InvoicePage invoicePage = new InvoicePage(driver);


    @When("User searches for proposal {string} from search input box")
    public void user_searches_for_proposal_from_search_input_box(String nameOfProposal) throws InterruptedException {
        allProposalsPage.searchForProposal(nameOfProposal);
        Thread.sleep(3000);
    }
    @When("User Verify that listed Proposal Subject is {string}, Project name is {string} and Status is {string}")
    public void user_verify_that_listed_proposal_subject_is_project_name_is_and_status_is(String subject, String projectName, String status) {
        allProposalsPage.verifySubjectNameAndStatus(subject,projectName, status);
    }

    @When("User clicks on the associated proposal id from Proposal # column")
    public void user_clicks_on_the_associated_proposal_id_from_proposal_column() throws InterruptedException {
        allProposalsPage.clickOnProposalIdFromProposalNumber();
    }
    @When("User clicks Comments tab and Add comment as {string}")
    public void user_clicks_comments_tab_and_add_comment_as(String commentMessage) throws InterruptedException {
        allProposalsPage.clickOnCommentsTabAndAddComment(commentMessage);
    }
    @When("User Verify that proposal comment {string} was added and that next to Comments tab there is {string} badge for total comment")
    public void user_verify_that_proposal_comment_was_added_and_that_next_to_comments_tab_there_is_badge_for_total_comment(String commentMessage, String numberOfCommentsAdded) throws InterruptedException {
        allProposalsPage.verifyCommentWasAdded(commentMessage,numberOfCommentsAdded);
    }
    @When("User Click Convert button and Select Invoice from drop down menu")
    public void user_click_convert_button_and_select_invoice_from_drop_down_menu() {
        allProposalsPage.clickConvertAndInvoiceButtons();
    }
    @Then("User Verify that Customer is {string} as default")
    public void user_verify_that_customer_is_as_default(String appleLLCCustomer) throws InterruptedException {
        Thread.sleep(3000);
        convertToInvoicePage.verifyCustomer(appleLLCCustomer);
    }
    @Then("Scroll down page and click Save button.")
    public void scroll_down_page_and_click_save_button() {
        convertToInvoicePage.scrollDownAndClickSave(driver);
    }
    @Then("User Verify that there is red {string} label next to record header")
    public void user_verify_that_there_is_red_label_next_to_record_header(String unpaidStatus) {
        invoicePage.verifyUnpaidStatus(unpaidStatus);
    }
    @Then("User Verify that record header that starts with {string} same number with Invoice Number section in the form")
    public void user_verify_that_record_header_that_starts_with_same_number_with_invoice_number_section_in_the_form(String recordNameBegins) {
        invoicePage.verifyRecordHeaderStartsWithINVAndMatchesInvoiceNumber(recordNameBegins);
    }



}
