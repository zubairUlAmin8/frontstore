package webTestCase;

import WebPages.LoginScenariosElements;
import base_test.BaseTest;
import org.testng.annotations.Test;

import static Helpers.Helper.driver;

public class LoginScenarios extends BaseTest {
    LoginScenariosElements loginScenarioElements;
    @Test(priority = 1)
    void validCredentials() {
        loginScenarioElements = new LoginScenariosElements(driver);
        loginScenarioElements.validCredentials();
    }
    @Test(priority = 1)
    void wrongCredentials() {
        loginScenarioElements = new LoginScenariosElements(driver);
        loginScenarioElements.invalidCredentials();
    }
}
