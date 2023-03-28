package step_defs;


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

        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();
        Log4j.startLog("Test is Starting");
        System.out.println(scenario.getName());


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
            Log4j.info(scenario.getName());
        }

        Log4j.endLog("Test is Ending");
        System.out.println(scenario.getName());
        System.out.println(scenario.getStatus());

        Driver.closeDriver();
    }

}