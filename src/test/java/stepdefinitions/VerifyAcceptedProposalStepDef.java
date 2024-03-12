package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.DeleteProposal;
import pages.ProposalPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class VerifyAcceptedProposalStepDef {

    WebDriver driver = DriverHelper.getDriver();
    ProposalPage proposalPage = new ProposalPage(driver);

    DeleteProposal deleteProposal = new DeleteProposal(driver);

    @When("User Set Table length to {string} from drop down menu that is next to Export button on top of table")
    public void user_set_table_length_to_from_drop_down_menu_that_is_next_to_export_button_on_top_of_table(String tableLength) {
        proposalPage.setTableLengthList(tableLength);

    }
    @Then("User verify that status for proposal {string} is {string}")
    public void user_verify_that_status_for_proposal_is(String nameOfProposal, String acceptedStatus) throws InterruptedException {
        proposalPage.locateAndVerifyStatus(nameOfProposal, acceptedStatus);
    }
    @Then("User clicks on More button, then Delete and press click Ok on the alert")
    public void user_clicks_on_more_button_then_delete_and_press_click_ok_on_the_alert() throws InterruptedException {
      deleteProposal.deleteParticularPromotion(driver);
    }



}
