package utils;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

public class BrowserUtils {
    public static void selectBy(WebElement location, String value, String methodName) {

        Select select = new Select(location);
        switch (methodName) {
            case "text" -> select.selectByVisibleText(value);
            case "value" -> select.selectByValue(value);
            case "index" -> select.selectByIndex(Integer.parseInt(value));
            default -> System.out.println("Method name is not available, use text,value or index");
        }

    }

    public static String getText(WebElement element) {
        return element.getText().trim();


    }

    public static String getTitleWithJS(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString().trim();

    }

    public static void clickWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);

    }

    public static void scrollWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);


    }

    public static void switchById(WebDriver driver) {
        String mainPageId = driver.getWindowHandle();
        Set<String> allPagesId = driver.getWindowHandles();
        for (String id : allPagesId) {
            if (!id.equals(mainPageId)) {
                driver.switchTo().window(id);
            }
        }
    }

    public static void switchByTitle(WebDriver driver, String title) {
        Set<String> allPagesId = driver.getWindowHandles();
        for (String id : allPagesId) {
            driver.switchTo().window(id);
            if (driver.getTitle().contains(title)) {
                break;
            }
        }
    }
    public static void getScreenShotWithCucumber(WebDriver driver, Scenario scenario){
        Date date=new Date();//java.util
        String screenShotFileName=date.toString().replace(" ","-")
                .replace(":","-");
        if(scenario.isFailed()){
            File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShotFile,new File("src/test/java/screenshot/"+screenShotFileName+".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}