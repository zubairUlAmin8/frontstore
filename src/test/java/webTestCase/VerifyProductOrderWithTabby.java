package webTestCase;

import Helpers.Utility;
import WebPages.*;
import base_test.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static Helpers.Helper.driver;

public class VerifyProductOrderWithTabby extends BaseTest {
    LandingPageElements landingPageElements;
    ProductDetailPageElements productDetailPageElements;
    CartPageElements cartPageElements;
    LoginElements loginElements;
    CheckoutPageElements checkoutPageElements;
    ThankYouPageElements thankYouPageElements;
    PayFortPageElements payFortPageElements;


    @Test(priority = 1)
    void openProductByLink() throws IOException {
        driver.get(Utility.getValue("launch", "ProductUrlForTabby"));

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
    void placedWithInstallment()  {
        checkoutPageElements = new CheckoutPageElements(driver);
        checkoutPageElements.selectInstallmentWithTabby();
    }
}
