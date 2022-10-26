package webTestCase;

import WebPages.ForgotPasswordElements;
import base_test.BaseTest;
import org.testng.annotations.Test;

import static Helpers.Helper.driver;

public class VerifyForgotPassword extends BaseTest {
    ForgotPasswordElements forgotPasswordElements;
    @Test(priority = 1)
    void invalidEmail(){
        forgotPasswordElements = new ForgotPasswordElements(driver);
        forgotPasswordElements.invalidEmailScenario();
    }

    @Test(priority = 2)
    void emptyEmail() {
        forgotPasswordElements = new ForgotPasswordElements(driver);
        forgotPasswordElements.emptyEmailScenario();
    }

    /*@Test(priority = 3)
    void validEmail() {
        forgotPasswordElements = new ForgotPasswordElements(driver);
        forgotPasswordElements.validEmailScenario();
    }*/
}