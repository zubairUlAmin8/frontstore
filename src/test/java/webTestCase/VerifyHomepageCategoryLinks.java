package webTestCase;


import WebPages.HomePageCategoryLinkElements;
import base_test.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static Helpers.Helper.driver;

public class VerifyHomepageCategoryLinks extends BaseTest {
    HomePageCategoryLinkElements homePageCategoryLinkElements;

    @Test(priority = 1)
    public void verifyLinks() throws IOException {
        homePageCategoryLinkElements = new HomePageCategoryLinkElements(driver);
        homePageCategoryLinkElements.verifyHomePageCategoryLinks();
    }
}
