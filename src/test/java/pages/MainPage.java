package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Sales')]")
    WebElement SalesButton;

    @FindBy(xpath = "//span[contains(text(),'Proposals')]")
    WebElement ProposalsButton;

    @FindBy(xpath = "//a[@class='btn btn-primary pull-left display-block new-proposal-btn']")
    WebElement NewProposalButton ;

public void ClickProposals(){
    SalesButton.click();
    ProposalsButton.click();
}
public void addNewProposal() {
    NewProposalButton.click();
}


}
