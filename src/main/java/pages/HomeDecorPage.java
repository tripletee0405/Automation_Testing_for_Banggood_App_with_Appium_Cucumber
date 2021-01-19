package pages;

import core.AppiumBase;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeDecorPage extends AppiumBase {
    public HomeDecorPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/slide_filter_entry']")
    private AndroidElement filter;
    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/edit_price_min']")
    private AndroidElement minPriceInput;
    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/edit_price_max']")
    private AndroidElement maxPriceInput;
    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/btn_done']")
    private AndroidElement doneBtn;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.banggood.client:id/iv_product'])[1]")
    private AndroidElement firstProduct;

    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/tv_product_name']")
    private AndroidElement productName;
    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/tv_product_price']")
    private AndroidElement productPrice;

    public void filterPrice() {
        getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.banggood.client:id/slide_filter_entry']")));
        tapByElement(filter);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.banggood.client:id/edit_price_min']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.banggood.client:id/edit_price_max']")));
        minPriceInput.sendKeys("20");
        maxPriceInput.sendKeys("30");
    }

    public void clickDone() {
        getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.banggood.client:id/btn_done']")));
        tapByElement(doneBtn);
    }

    public void clickFirstProduct() {
        getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@resource-id='com.banggood.client:id/iv_product'])[1]")));
        tapByElement(firstProduct);
    }

    public void verifyFirstProduct() {
        getWait();
        softAssertDisplayed(productName);
        String price = productPrice.getText().replace("US$","");
        Double dPrice = Double.parseDouble(price);
        if (20<=dPrice && dPrice<=30){
            System.out.println("Price is right");
        }
    }
}