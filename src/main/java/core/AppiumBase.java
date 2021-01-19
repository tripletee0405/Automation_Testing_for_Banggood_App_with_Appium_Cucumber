package core;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumBase {
    public static AndroidDriver driver;
    public static WebDriverWait wait;
    SoftAssert softAssert = new SoftAssert();

    public void createDriver() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("udid", "b9b0c0a8");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.banggood.client");
        capabilities.setCapability("appActivity", "com.banggood.client.module.startup.SplashActivity");
        capabilities.setCapability("newCommandTimeout", 0);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, 20);
    }

    public void waitForPageToLoad(By by, int secondsToWait) {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(by)
        );
    }

    public void tearDown() {
        driver.closeApp();
    }

    public void getWait() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void softAssertDisplayed(AndroidElement androidElement) {
        softAssert.assertTrue(androidElement.isDisplayed());
    }

    public void softAssertTrue(boolean booleann) {
        softAssert.assertTrue(booleann);
    }

    public void tapByElement(AndroidElement androidElement) {
        TouchAction action = new TouchAction(driver);
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(androidElement))).perform();
    }

    public void swipeUpInContainer(By locator, AndroidElement androidElementContainer, int count) {
        boolean isVisible = checkElementDisplayed(locator);
        if (isVisible) {
            return;
        }
        int startx = 0;
        int starty = 0;
        int endx = 0;
        int endy = 0;

        startx = endx = androidElementContainer.getLocation().getX() + Math.round(androidElementContainer.getSize().getWidth() / 2);
        starty = (int) (androidElementContainer.getLocation().getY() + Math.round(0.8 * androidElementContainer.getSize().getHeight()));
        endy = (int) (androidElementContainer.getLocation().getY() + Math.round(0.2 * androidElementContainer.getSize().getHeight()));
        System.out.println(startx + "_" + starty + "_" + endx + "_" + endy);
        for (int i = 0; i < count; ++i) {
            swipe(startx, starty, endx, endy);
            isVisible = checkElementDisplayed(locator);
            if (isVisible) {
                break;
            }
        }
    }

    public boolean checkElementDisplayed(By locator) {
        boolean isDisplay = false;
        AndroidElement androidElement = null;
        try {
            androidElement = (AndroidElement) driver.findElement(locator);
        } catch (Exception e) {
        }
        if (null != androidElement) {
            try {
                if (null != androidElement.getLocation()) {
                    int x = androidElement.getLocation().getX();
                    int y = androidElement.getLocation().getY();
                    Dimension windowSize = driver.manage().window().getSize();
                    String deviceScreenSize = "";

                    int yMaxScreen = (int) Math.round(windowSize.getHeight());
                    int xMaxScreen = (int) Math.round(windowSize.getWidth());
                    if (driver instanceof AndroidDriver) {
                        deviceScreenSize = StringUtils.substringBetween(driver.toString(), "deviceScreenSize=", ",");
                    }
                    if (null != deviceScreenSize && !deviceScreenSize.equals("")) {
                        yMaxScreen = Integer.parseInt(deviceScreenSize.split("x")[1]);
                        xMaxScreen = Integer.parseInt(deviceScreenSize.split("x")[0]);
                    }
                    if (x >= 0 && x < xMaxScreen && y >= 0 && y < yMaxScreen) {
                        isDisplay = true;
                    }
                }
            } catch (Exception e) {
            }
        }
        return isDisplay;
    }

    public void swipe(int startx, int starty, int endx, int endy) {
        new TouchAction(driver).longPress(PointOption.point(startx, starty))
                .moveTo(PointOption.point(endx, endy))
                .release().perform();

    }
}
