package pages;

import core.AppiumBase;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AppiumBase {
    public CartPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/tv_product_name']")
    private AndroidElement productName;
    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/tv_product_options']")
    private AndroidElement productSize;
    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/tv_product_price']")
    private AndroidElement productPrice;
    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/edit_qty']")
    private AndroidElement quantity;


    public void verifyFirstProduct() {
        getWait();
        softAssertDisplayed(productName);
        softAssertDisplayed(productSize);
        softAssertDisplayed(productPrice);
        softAssertDisplayed(quantity);
    }
}