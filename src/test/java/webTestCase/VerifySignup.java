package webTestCase;

import WebPages.SignupPageElements;
import base_test.BaseTest;
import org.testng.annotations.Test;

import static Helpers.Helper.driver;

public class VerifySignup extends BaseTest {
    SignupPageElements signupPageElements;

    @Test(priority = 1)
    void verifySignupEmail (){
        signupPageElements = new SignupPageElements(driver);
        signupPageElements.signupEmailVerify();
    }

    @Test(priority = 2)
    void verifySignupPhone() {
        signupPageElements = new SignupPageElements(driver);
        signupPageElements.signupPhoneVerify();
    }
}
