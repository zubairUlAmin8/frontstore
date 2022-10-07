package webTestCase;

import WebPages.SocialLoginElements;
import base_test.BaseTest;
import org.testng.annotations.Test;

import static Helpers.Helper.driver;

public class VerifySocialLogin extends BaseTest {
    SocialLoginElements socialLoginElements;

    @Test(priority = 1)
    void fbLoginVerify() {
        socialLoginElements = new SocialLoginElements(driver);
        socialLoginElements.facebookLoginVerify();
    }

    @Test(priority = 2)
    void gmailLoginVerify() {
        socialLoginElements = new SocialLoginElements(driver);
        socialLoginElements.gmailLoginVerify();
    }

    @Test(priority = 3)
    void otpWithEmail() throws InterruptedException {
        socialLoginElements = new SocialLoginElements(driver);
        socialLoginElements.otpWithEmailVerify();
    }

    @Test(priority = 4)
    void otpWithPhone() {
        socialLoginElements = new SocialLoginElements(driver);
        socialLoginElements.otpWithPhoneVerify();
    }
}
