package webTestCase;


import WebPages.LandingPageElements;
import base_test.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static Helpers.Helper.driver;

public class VerifyBrokenLinksOnLandingPage extends BaseTest {
    LandingPageElements landingPageElements;
    @Test
    void verifyBrokenLinksOnLandingPage() throws IOException {

        driver.get("https://cartlow.com/saudi/en");
        landingPageElements=new LandingPageElements(driver);
        landingPageElements.verifyBrokenLinks(driver, "verifyBrokenLinksOnLandingPage");
    }
    @Test
    void verifyBrokenImagesOnLandingPage() throws IOException {
        driver.get("https://cartlow.com/");
        landingPageElements=new LandingPageElements(driver);
        landingPageElements.verifyBrokenImages(driver, "verifyBrokenImagesOnLandingPage");
    }


}
