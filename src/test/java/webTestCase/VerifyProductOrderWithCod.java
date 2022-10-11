package webTestCase;

import Helpers.Utility;
import WebPages.*;
import base_test.BaseTest;
import com.github.javafaker.Bool;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.IOException;

import static Helpers.Helper.driver;


public class VerifyProductOrderWithCod extends BaseTest {
    LandingPageElements landingPageElements;
    ProductDetailPageElements productDetailPageElements;
    CartPageElements cartPageElements;
    LoginElements loginElements;
    CheckoutPageElements checkoutPageElements;
    ThankYouPageElements thankYouPageElements;

    //    @Test(priority = 0)
    void searchProduct() throws InterruptedException {
        landingPageElements = new LandingPageElements(driver);
        landingPageElements.searchProduct();
        landingPageElements.selectProductFromSearchBar();
    }
    @Parameters("countryName")
    @Test(priority = 1)
    void openProductByLink(String countryName) throws IOException {
        landingPageElements = new LandingPageElements(driver);
        if (countryName.equals("UAE")) {
            driver.get(Utility.getValue("launch", "ProductUrl"));

        } else if (countryName.equals("KSA")) {
            driver.get(Utility.getValue("launch", "ProductUrl"));

        } else {
            driver.get(Utility.getValue("launch", "ProductUrl"));

        }
        landingPageElements.selectCountry(countryName);

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

    @Test(priority = 7)
    void orderVerified() {
        thankYouPageElements = new ThankYouPageElements(driver);
        Boolean check = thankYouPageElements.verifyOrderPlacedOrNot();
        Assert.assertTrue(check);
    }


}
