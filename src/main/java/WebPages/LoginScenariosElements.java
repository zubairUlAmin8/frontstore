package WebPages;

import ElementPaths.LoginPagePaths;
import Helpers.Helper;
import Helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginScenariosElements extends Helper {
    //Constructor
    public LoginScenariosElements(WebDriver driver) {
        Helper.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Initializing Xpath's
    @FindBy(css = LoginPagePaths.homeSignInButton)
    @CacheLookup
    WebElement homeSignInButton;
    @FindBy(css = LoginPagePaths.emailOrNumberInputField)
    @CacheLookup
    WebElement emailOrNumberInputField;
    @FindBy(css = LoginPagePaths.passwordInputField)
    @CacheLookup
    WebElement passwordInputField;
    @FindBy(css = LoginPagePaths.eyeIcon)
    @CacheLookup
    WebElement eyeIcon;
    @FindBy(css = LoginPagePaths.signInButton)
    @CacheLookup
    WebElement signInButton;
    @FindBy(css = LoginPagePaths.accountButton)
    @CacheLookup
    WebElement accountButton;
    @FindBy(css = LoginPagePaths.logoutButton)
    @CacheLookup
    WebElement logoutButton;
    @FindBy(css = LoginPagePaths.modalCloseButton)
    @CacheLookup
    WebElement modalCloseButton;

    //Login Function
    public void validCredentials() throws InterruptedException {
        homeSignInButton.click();
        Waits.sendKeys(driver, emailOrNumberInputField, "talha.user@cartlow.com", 30);
        Waits.sendKeys(driver, passwordInputField, "123123123", 30);
        pause(1);
        Waits.clickButton(driver, eyeIcon, 30);
        pause(1);
        signInButton.click();
        Waits.clickButton(driver, accountButton, 30);
        Waits.clickButton(driver, logoutButton, 30);
    }

    public void invalidCredentials() throws InterruptedException {
        homeSignInButton.click();
        Waits.sendKeys(driver, emailOrNumberInputField, "talha.user@cartlow.com", 30);
        Waits.sendKeys(driver, passwordInputField, "12312312", 30);
        pause(1);
        Waits.clickButton(driver, eyeIcon, 30);
        signInButton.click();
    }

    public void emptyFields() throws InterruptedException {
        pause(1);
        emailOrNumberInputField.clear();
        pause(1);
        passwordInputField.clear();
        pause(1);
        signInButton.click();
        pause(1);
        modalCloseButton.click();
    }
}
