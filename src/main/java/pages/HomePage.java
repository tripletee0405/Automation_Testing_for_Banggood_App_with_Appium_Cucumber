package pages;

import core.AppiumBase;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AppiumBase {
    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/main_tab_category']")
    private AndroidElement categories;
    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/rv_hot_categories']/android.widget.FrameLayout[1]")
    private AndroidElement firstCategory;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.banggood.client:id/iv_product'])[1]")
    private AndroidElement firstProduct;
    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/main_tab_account']")
    private AndroidElement account;

    public void tapCategories() {
        getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.banggood.client:id/main_tab_category']")));
        tapByElement(categories);
    }

    public void scrollToHotCategories() {
        getWait();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Ưu đãi Flash']")));
        AndroidElement hotCategories = (AndroidElement) driver.findElementByXPath("//*[@resource-id='com.banggood.client:id/swipe_refresh_view']");
        By locator = By.xpath("//*[@text='Thể loại hot']");
        swipeUpInContainer(locator, hotCategories, 10);
    }

    public void clickToFirstCategory() {
        getWait();
        tapByElement(firstCategory);
    }

    public void clickToFirstProduct() {
        getWait();
        tapByElement(firstProduct);
    }

    public void tapAccount() {
        getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.banggood.client:id/main_tab_account']")));
        tapByElement(account);
    }
}