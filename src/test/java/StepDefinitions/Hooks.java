package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import Utilities.basePage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks{


    @Before
    public void setUp() throws Exception {
    	basePage.initializeDriver();

    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if(scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) basePage.getdriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "image");
                System.out.println("Screenshot Completed");
            }}catch (Exception e) {
            System.out.println(e);
        }
		basePage.quitDriver();
//		softAssertH.assertAll();
    }
}
