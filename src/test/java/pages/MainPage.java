package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class='menu-item-sales']")
    WebElement saleBtn;

    @FindBy(xpath = "//li[@class='sub-menu-item-proposals']")
    WebElement proposalsBtn;

    public void salesBtn() {

        saleBtn.click();
    }

    public void proposalBtn() {
        proposalsBtn.click();

    }

}
