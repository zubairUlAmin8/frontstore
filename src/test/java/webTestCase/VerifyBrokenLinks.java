package webTestCase;

import WebPages.LandingPageElements;
import base_test.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static Helpers.Helper.driver;

public class VerifyBrokenLinks extends BaseTest {
    LandingPageElements landingPageElements;
    @Test
    void verifyBrokenLinksOnLandingPage() {

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("return window.stop");
        driver.get("https://cartlow.com/");
        landingPageElements=new LandingPageElements(driver);
        landingPageElements.verifyBrokenLinks(driver);

    }

    @Test
    void verifyBrokenImagesOnLandingPage() {
        driver.get("https://cartlow.com/");
        landingPageElements=new LandingPageElements(driver);
        landingPageElements.verifyBrokenImages(driver);
    }

}
