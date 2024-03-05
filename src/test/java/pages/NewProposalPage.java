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



        @FindBy(xpath = "//div[@class='_buttons'] ")
        WebElement newProposalBTN;



        public boolean btnIsVisible(){

            return newProposalBTN.isDisplayed();
        }



        public void colorValidation(String expectedColor){

            Assert.assertEquals(expectedColor,newProposalBTN.getCssValue("background-color"));
        }


    }

