package pages;

import core.AppiumBase;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CategoriesPage extends AppiumBase {
    public CategoriesPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@text='Home and Garden']")
    private AndroidElement homeAndGarden;

    public void scrollToHomeAndGarden() {
        getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Electronics']")));
        AndroidElement menuLeft = (AndroidElement) driver.findElementByXPath("//*[@resource-id='com.banggood.client:id/primary_cate_list']");
        By locator = By.xpath("//*[@text='Home and Garden']");
        swipeUpInContainer(locator, menuLeft, 10);
    }

    public void clickToHomeAndGarden() {
        getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Home and Garden']")));
        tapByElement(homeAndGarden);
    }
}