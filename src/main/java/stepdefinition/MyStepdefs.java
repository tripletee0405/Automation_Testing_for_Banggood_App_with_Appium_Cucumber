package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;

public class MyStepdefs {
    IntroPage introPage = new IntroPage();
    HomePage homePage = new HomePage();
    CategoriesPage categoriesPage = new CategoriesPage();
    HomeAndGardenPage homeAndGardenPage = new HomeAndGardenPage();
    HomeDecorPage homeDecorPage = new HomeDecorPage();
    FirstProductPage firstProductPage = new FirstProductPage();
    CartPage cartPage = new CartPage();
    AccountPage accountPage = new AccountPage();
    SignInPage signInPage = new SignInPage();

    @Given("I open Banggood Easy Online Shopping App")
    public void iOpenBanggoodEasyOnlineShoppingApp() {

    }

    @When("I click to close popup button")
    public void iClickToClosePopupButton() {
        introPage.closePopUp();
    }

    @And("I Click to the Category on footer menu")
    public void iClickToTheCategoryOnFooterMenu() {
        homePage.tapCategories();
    }

    @And("I Scroll and click to Home and Garden in Left menu")
    public void iScrollAndClickToHomeAndGardenInLeftMenu() {
        categoriesPage.scrollToHomeAndGarden();
        categoriesPage.clickToHomeAndGarden();
    }

    @And("I click to the Home Decor")
    public void iClickToTheHomeDecor() {
        homeAndGardenPage.clickToHomeDecor();
    }

    @And("I click to the Filter and input price from 20 to 30")
    public void iClickToTheFilterAndInputPriceFromTo() {
        homeDecorPage.filterPrice();
    }

    @And("I click Done")
    public void iClickDone() {
        homeDecorPage.clickDone();
    }

    @And("I click first product")
    public void iClickFirstProduct() {
        homeDecorPage.clickFirstProduct();
    }

    @Then("Display product name and product price in range 20 to 30")
    public void displayProductNameAndProductPriceInRangeTo() {
        homeDecorPage.verifyFirstProduct();
    }

    @And("I Scroll to Hot Category")
    public void iScrollToHotCategory() {
        homePage.scrollToHotCategories();
    }

    @And("I click to the first category")
    public void iClickToTheFirstCategory() {
        homePage.clickToFirstCategory();
    }

    @And("I click to the first product")
    public void iClickToTheFirstProduct() {
        homePage.clickToFirstProduct();
    }

    @And("I click Add to Carttttt")
    public void iClickAddToCarttttt() {
        firstProductPage.addToCart();
    }

    @And("I click Add to Cart button")
    public void iClickAddToCartButton() {

    }

    @And("I click to Cart icon on footer")
    public void iClickToCartIconOnFooter() {
        firstProductPage.clickCartIcon();
    }

    @Then("Display product name, product size, product price and quantity")
    public void displayProductNameProductSizeProductPriceAndQuantity() {
        cartPage.verifyFirstProduct();
    }

    @And("I click Account on footer menu")
    public void iClickAccountOnFooterMenu() {
        homePage.tapAccount();
    }

    @And("I click View All Order")
    public void iClickViewAllOrder() {
        accountPage.viewAll();
    }

    @Then("Display login screen displayed with : Email, password, Sign In button")
    public void displayLoginScreenDisplayedWithEmailPasswordSignInButton() {
        signInPage.verifySignInPage();
    }
}
