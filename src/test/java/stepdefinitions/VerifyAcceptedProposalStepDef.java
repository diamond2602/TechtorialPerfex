package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ProposalPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class VerifyAcceptedProposalStepDef {

    WebDriver driver = DriverHelper.getDriver();
    ProposalPage proposalPage = new ProposalPage(driver);

    @Given("User navigates to employeeURL")
    public void user_navigates_to_employee_url() {
        driver.get(ConfigReader.readProperty("employeeURL"));
    }
    @When("User Set Table length to {string} from drop down menu that is next to Export button on top of table")
    public void user_set_table_length_to_from_drop_down_menu_that_is_next_to_export_button_on_top_of_table(String tableLength) {
        proposalPage.setTableLengthList(tableLength);

    }
    @Then("User verify that status is {string} for approved proposals")
    public void user_verify_that_status_is_for_approved_proposals(String statusAccepted) {
        proposalPage.verifiedAcceptedStatus(statusAccepted);

    }


}
