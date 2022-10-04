package webTestCase;

import Helpers.Utility;
import WebPages.*;
import base_test.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static Helpers.Helper.driver;

public class VerifyProductOrderWithCard extends BaseTest {
    LandingPageElements landingPageElements;
    ProductDetailPageElements productDetailPageElements;
    CartPageElements cartPageElements;
    LoginElements loginElements;
    CheckoutPageElements checkoutPageElements;
    ThankYouPageElements thankYouPageElements;
    SandboxPathElements sandboxPathElements;

    @Test(priority = 1)
    void openProductByLink() throws IOException {
        driver.get(Utility.getValue("launch", "ProductUrl"));

    }

    @Test(priority = 2)
    void productAddToCart() {
        productDetailPageElements = new ProductDetailPageElements(driver);
        productDetailPageElements.clickOnAddToCartButton();
    }

    @Test(priority = 3)
    void goToViewCartItems() {
        productDetailPageElements = new ProductDetailPageElements(driver);
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
    void fillCardDetails() throws IOException {
        checkoutPageElements = new CheckoutPageElements(driver);
        checkoutPageElements.payWithCard();
        checkoutPageElements.clickToPayWithCard();
    }
    @Test(priority = 7)
    void sandboxVerification() throws IOException, InterruptedException {
        sandboxPathElements = new SandboxPathElements(driver);
        sandboxPathElements.verifyPaymentProcessBySandbox();
    }

    @Test(priority =8)
    void verifyOrderPlacedOrNot() throws InterruptedException {
        Thread.sleep(8000);
        System.out.println("thankyou url"+ driver.getCurrentUrl());
        thankYouPageElements.verifyOrderPlacedOrNot();
    }

}
