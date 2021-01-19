package pages;

import core.AppiumBase;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends AppiumBase {
    public SignInPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/til_email']")
    private AndroidElement email;
    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/et_password']")
    private AndroidElement password;
    @AndroidFindBy(xpath = "//*[@resource-id='com.banggood.client:id/btn_sign']")
    private AndroidElement signinBtn;

    public void verifySignInPage() {
        getWait();
        softAssertDisplayed(email);
        softAssertDisplayed(password);
        softAssertDisplayed(signinBtn);
    }
}