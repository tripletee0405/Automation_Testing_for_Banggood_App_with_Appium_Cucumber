package pages;

import core.AppiumBase;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FirstProductPage extends AppiumBase {
    public FirstProductPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/cv_slide_cart']")
    private AndroidElement cartIcon;
    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/tv_product_name']")
    private AndroidElement productName;
    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/tv_product_price']")
    private AndroidElement productPrice;
    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/btn_slide_buy']")
    private AndroidElement buyNowBTN;
    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/btn_slide_cart']")
    private AndroidElement addToCart1;
    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/btn_cart']")
    private AndroidElement addToCart2;

    public void addToCart() {
        getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.banggood.client:id/btn_slide_cart']")));
        tapByElement(addToCart1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.banggood.client:id/btn_cart']")));
        tapByElement(addToCart2);
    }

    public void clickCartIcon() {
        getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.banggood.client:id/cv_slide_cart']")));
        tapByElement(cartIcon);
    }
}