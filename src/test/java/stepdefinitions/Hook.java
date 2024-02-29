package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class Hook {
    public WebDriver driver;

    @Before// it must be imported from io.cucumber NOT from JUNIT ****
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("techtorial_CRM_URL"));
        //driver.get(ConfigReader.readProperty("smart_bear_url"));
    }

//    @After
//    public void tearDown(Scenario scenario){
//        //BrowserUtils.getScreenShotWithCucumber(driver, scenario);
//        driver.quit();
//    }
}
