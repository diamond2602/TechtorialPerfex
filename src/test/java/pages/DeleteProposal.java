package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DeleteProposal {

    public DeleteProposal(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'PRO')]")
    List<WebElement> proposalNumbers;
    @FindBy(xpath = "//button[contains(text(),'More')]")
    WebElement moreDropdown;
    @FindBy(xpath = "//a[contains(text(),'Delete')]")
    WebElement delete;

    public void deleteProposal(WebDriver driver) {
        proposalNumbers.get(0).click();
        moreDropdown.click();
        delete.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();


    }

    public void deleteParticularPromotion(WebDriver driver) throws InterruptedException {
        moreDropdown.click();
        delete.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
    }

}
