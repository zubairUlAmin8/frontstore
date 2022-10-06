package webTestCase;

import WebPages.SocialLoginElements;
import base_test.BaseTest;
import org.testng.annotations.Test;

import static Helpers.Helper.driver;

public class SocialLogin extends BaseTest {
    SocialLoginElements socialLoginElements;
    @Test(priority = 1)
    void fbLoginVerify(){
        socialLoginElements = new SocialLoginElements(driver);
        socialLoginElements.facebookLoginVerify();
    }
}
