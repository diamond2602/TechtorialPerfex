package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewProposalPage {

    public NewProposalPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[@class='btn btn-primary pull-left display-block new-proposal-btn']")
    WebElement NewProposalButton ;



        public boolean btnIsVisible(){

            return NewProposalButton.isDisplayed();
        }



        public void colorValidation(String expectedColor){

            Assert.assertEquals(expectedColor,NewProposalButton.getCssValue("background-color"));
        }


    }

