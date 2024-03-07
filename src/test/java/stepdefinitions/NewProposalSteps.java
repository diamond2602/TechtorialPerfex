package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.ProposalPage;
import utils.DriverHelper;

public class NewProposalSteps {
    WebDriver driver = DriverHelper.getDriver();
    MainPage mainPage = new MainPage(driver);
    ProposalPage proposalPage = new ProposalPage(driver);

    @When("User Clicks {string} Module from left side navigation menu and {string} module")
    public void user_clicks_module_from_left_side_navigation_menu_and_module(String moduleName, String salesOption) throws InterruptedException {
        mainPage.SelectModule(moduleName);
        Thread.sleep(500);
        mainPage.SelectSalesOptions(salesOption);
    }

    @When("user clicks New Proposal button from the top")
    public void user_clicks_button_from_the_top() throws InterruptedException {
        mainPage.addNewProposal();
    }

    @When("user fills the Subject line with {string}")
    public void user_fills_the_subject_line_with(String subjectMessage) {
        proposalPage.addSubject(subjectMessage);

    }

    @When("user selects {string} from the Related dropdown")
    public void user_selects_from_the_dropdown(String relatedChoise) {
        proposalPage.selectRelated(relatedChoise);
    }

    @When("user types {string} into the Customer filter and selects {string} from the results")
    public void user_types_into_the_filter_and_selects_from_the_results(String customerSearchName, String customerName) throws InterruptedException {
        proposalPage.selectCustomer(customerSearchName, customerName);
    }

    @When("user types {string} into the Project filter and selects {string}")
    public void user_types_into_the_filter_and_selects(String projectSearchName, String projectName) throws InterruptedException {
        proposalPage.selectProject(projectSearchName, projectName);
    }

    @When("user clicks Add Item button and selects {string} from the dropdown list")
    public void user_clicks_button_and_selects_from_the_dropdown_list(String itemName) throws InterruptedException {
        proposalPage.selectItem(itemName);
    }

    @When("user clicks the blue check button to add the item")
    public void user_clicks_the_blue_check_button_to_add_the_item() {
        proposalPage.clickBlueButton(driver);
    }


    @When("user changes the quantity of Ethernet Cable to {string}")
    public void user_changes_the_quantity_of_ethernet_cable_to(String string) {

    }

    @Then("user verifies that the Total is {string}")
    public void user_verifies_that_the_total_is(String string) {

    }

    @Then("user clicks {string} button")
    public void user_clicks_button(String string) {

    }
}
