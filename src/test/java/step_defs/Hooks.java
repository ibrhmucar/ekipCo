package step_defs;


import groovy.util.logging.Log;
import utils.Log4j;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Driver;

import java.util.concurrent.TimeUnit;


public class Hooks {


    @Before
    public void setUp(Scenario scenario) {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();
        Log4j.startLog("Test is Starting");
        Log4j.info(scenario.getName());

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) Driver.get();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
         }else {
            TakesScreenshot ts = (TakesScreenshot) Driver.get();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Log4j.endLog("Test is Ending");
        Log4j.info(scenario.getStatus().toString());


        Driver.closeDriver();
    }

}