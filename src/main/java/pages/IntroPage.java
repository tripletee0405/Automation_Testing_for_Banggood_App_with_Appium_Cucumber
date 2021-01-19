package pages;

import core.AppiumBase;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IntroPage extends AppiumBase {
    public IntroPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/iv_close']")
    private AndroidElement btnClosePopUp;

    public void closePopUp() {
        getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.banggood.client:id/iv_close']")));
        tapByElement(btnClosePopUp);
    }
}
