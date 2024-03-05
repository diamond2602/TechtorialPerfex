package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //    @FindBy()
//    WebElement ;
//
//    @FindBy()
//    WebElement ;
//
//    @FindBy()
//    WebElement ;
//
//    @FindBy()
//    WebElement ;
//
//    @FindBy()
//    WebElement ;
//
    @FindBy(xpath = "//li[@class='menu-item-sales']")
    WebElement saleBtn;

    @FindBy(xpath = "//li[@class='sub-menu-item-proposals']")
    WebElement proposalsBtn;

//    @FindBy(xpath = "//*[@id=\"wrapper\"]/div/div/div/div[2]/div[1]/div[1]/a[1]/i]")
//    WebElement newProposalBTN;


    public void saleBtn() {
        saleBtn.click();
    }

    public void proposalBtn() {
        proposalsBtn.click();

    }
//
//    public boolean proposalBtnIsDisplayed(){
//        return newProposalBTN.isDisplayed();
//    }
//
//    public void colorValidation(String expectedColor){
//
//        Assert.assertEquals(expectedColor,newProposalBTN.getCssValue("color"));
//    }

}
