package webTestCase;

import Helpers.Helper;
import WebPages.LandingPageElements;
import base_test.BaseTest;
import org.testng.annotations.Test;

import static Helpers.Helper.driver;


public class VerifyProductOrderWithCod extends BaseTest {
    LandingPageElements landingPageElements;

    @Test
    void searchProduct() {
        landingPageElements = new LandingPageElements(driver);

        System.out.println(driver.getCurrentUrl());
        landingPageElements.searchProduct();
    }
}
