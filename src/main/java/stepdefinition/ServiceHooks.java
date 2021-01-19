package stepdefinition;

import core.AppiumBase;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.net.MalformedURLException;

public class ServiceHooks {
    AppiumBase appiumBase = new AppiumBase();

    @Before
    public void initializeTest() throws MalformedURLException, InterruptedException {
        appiumBase.createDriver();
    }

    @After
    public void afterHookFunction(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot) AppiumBase.driver)
                    .getScreenshotAs(OutputType.BYTES), "image/png");
        }
        appiumBase.tearDown();
    }
}
