package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class MainPage {
    public MainPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@class='menu-text']")
    List<WebElement> allModules;

    @FindBy(xpath = "//li[@class='menu-item-sales active']//span[@class='sub-menu-text']")
   List<WebElement> AllSalesOptions;
    @FindBy(xpath = "//a[@class='btn btn-primary pull-left display-block new-proposal-btn']")
    WebElement NewProposalButton ;

public void SelectModule(String moduleName){
    for (int i=0; i< allModules.size(); i++){
        if(allModules.get(i).getText().trim().equals(moduleName)){
            allModules.get(i).click();
            break;
        }
    }
}
public void SelectSalesOptions(String salesOption){
    for (WebElement option: AllSalesOptions){
        if( option.getText().trim().equals(salesOption)){
            option.click();
            break;
        }
    }
}
public void addNewProposal() throws InterruptedException {
    Thread.sleep(500);
    NewProposalButton.click();
}


}
