package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.DeleteProposal;
import pages.LoginPage;
import pages.ProposalVerificationPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class ProposalVerificationSteps {

    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    ProposalVerificationPage proposalVerificationPage = new ProposalVerificationPage(driver);
    DeleteProposal deleteProposal = new DeleteProposal(driver);

    @Given("the user navigates to the customer URL")
    public void theUserNavigatesToTheCustomerURL() {
        String url = ConfigReader.readProperty("customer_techtorial_url");
        driver.get(url);
    }

    @Given("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() {
        loginPage.login(ConfigReader.readProperty("customer_username"), ConfigReader.readProperty("customer_password"));

    }

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {
        proposalVerificationPage.verifyPageTitle(expectedTitle);

    }

    @When("the user clicks on the {string} menu in the top navigation")
    public void the_user_clicks_on_the_menu_in_the_top_navigation(String expectedBtn) {
        proposalVerificationPage.clickOnProposal();
    }

    @When("the proposal with title {string} is in the list")
    public void the_proposal_with_title_is_in_the_list(String proposalTitle) {
        proposalVerificationPage.verifyNeededProposal(proposalTitle);

    }

    @When("the total for the proposal is {string}")
    public void the_total_for_the_proposal_is(String price) {

        proposalVerificationPage.verifyProposalPrice(price);
    }

    @And("the user saves the proposal ID as {string} and clicks on the proposal with Proposal # equal to saved proposal id")
    public void theUserSavesTheProposalIDAsAndClicksOnTheProposalWithProposalEqualToSavedProposalId(String proposalId) {
        proposalVerificationPage.saveAndClickProposalId(proposalId);

    }

    @Then("the proposal should match the value in the new page h4 element")
    public void theProposalShouldMatchTheValueInTheNewPageSHElement() throws InterruptedException {
        proposalVerificationPage.verifyFourHElement();
    }

    @Then("the first item in the table should be {string}")
    public void the_first_item_in_the_table_should_be(String firstItem) {
        proposalVerificationPage.verifyFirstItem(firstItem);
    }

    @Then("the second item in the table should be {string}")
    public void the_second_item_in_the_table_should_be(String secondItem) {
        proposalVerificationPage.verifySecondItem(secondItem);
    }

    @Then("the page should have an {string} button")
    public void the_page_should_have_an_button(String acceptBtn) {

        proposalVerificationPage.verifyAcceptButton();
    }

    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String string) {

        proposalVerificationPage.clickOnAccept();
    }

    @When("clicks the {string} button on the pop-up screen")
    public void clicks_the_button_on_the_pop_up_screen(String signBtn) throws InterruptedException {
        proposalVerificationPage.clickOnSign();
    }

    @Then("a red signature error message should be displayed stating {string} under the signature box")
    public void a_red_signature_error_message_should_be_displayed_stating_under_the_signature_box(String alertMessage) {
        proposalVerificationPage.redMessageAlert(alertMessage);
    }

    @And("the user draws a signature in the canvas and clicks the {string} button again")
    public void theUserDrawsASignatureInTheCanvasAndClicksTheButtonAgain(String arg0) throws InterruptedException {
        proposalVerificationPage.signingTheCanvas();
        proposalVerificationPage.clickOnSign();
    }

    @Then("a {string} status label with a green background should appear next to the proposal ID")
    public void a_status_label_with_a_green_background_should_appear_next_to_the_proposal_id(String acceptedlabel) {
        proposalVerificationPage.validateAcceptLabel();

    }

    @When("Click first Proposal number, More button, Delete and press OK in the confirmation pop up")
    public void click_first_proposal_number_more_button_and_delete() throws InterruptedException {
        deleteProposal.deleteProposal(driver);

    }

}