package webTestCase;

import WebPages.LoginScenariosElements;
import base_test.BaseTest;
import org.testng.annotations.Test;

import static Helpers.Helper.driver;

public class LoginScenarios extends BaseTest {
    LoginScenariosElements loginScenarioElements;
    @Test(priority = 1)
    void validCredentials() throws InterruptedException {
        loginScenarioElements = new LoginScenariosElements(driver);
        loginScenarioElements.validCredentials();
    }
    @Test(priority = 2)
    void wrongCredentials() throws InterruptedException {
        loginScenarioElements = new LoginScenariosElements(driver);
        loginScenarioElements.invalidCredentials();
    }
    @Test(priority = 3)
    void emptyFields() throws InterruptedException {
        loginScenarioElements = new LoginScenariosElements(driver);
        loginScenarioElements.emptyFields();
    }
}
