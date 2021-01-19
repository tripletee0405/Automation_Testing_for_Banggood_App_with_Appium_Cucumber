package pages;

import core.AppiumBase;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeAndGardenPage extends AppiumBase {
    public HomeAndGardenPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@text='Home Decor']")
    private AndroidElement homeDecor;

    public void clickToHomeDecor() {
        getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Home Decor']")));
        tapByElement(homeDecor);
    }
}