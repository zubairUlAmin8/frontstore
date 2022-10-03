package webTestCase;

import WebPages.*;
import base_test.BaseTest;
import org.testng.annotations.Test;

import static Helpers.Helper.driver;


public class VerifyProductOrderWithCod extends BaseTest {
    LandingPageElements landingPageElements;
    ProductDetailPageElements productDetailPageElements;
    CartPageElements cartPageElements;
    LoginElements loginElements;
    CheckoutPageElements checkoutPageElements;
    @Test(priority = 1)
    void searchProduct() throws InterruptedException {
        landingPageElements =new LandingPageElements(driver);

        System.out.println(driver.getCurrentUrl());
        landingPageElements.searchProduct();
        System.out.println("zubair");
        System.out.println("this is goint to stash3");
        landingPageElements.selectProductFromSearchBar();
    }

    @Test(priority = 2)
    void productAddToCart() {
        productDetailPageElements = new ProductDetailPageElements(driver);
        productDetailPageElements.clickOnAddToCartButton();
    }
    @Test(priority = 3)
    void goToViewCartItems() {
        productDetailPageElements.goToViewCartItems();
    }
    @Test(priority = 4)
    void goToCheckoutPage() {
        cartPageElements = new CartPageElements(driver);
        cartPageElements.clickOnCheckoutButton();

    }
    @Test(priority = 5)
    void loginIntoUserAccount() {
        loginElements = new LoginElements(driver);
        loginElements.login();

    }
    @Test(priority = 6)
    void PlaceOrderWithCodAfterCheckout() throws InterruptedException {
        checkoutPageElements = new CheckoutPageElements(driver);
        checkoutPageElements.placeOrderWithCOD();

    }


}
