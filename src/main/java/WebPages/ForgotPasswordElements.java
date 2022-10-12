package WebPages;

import ElementPaths.ForgotPasswordPaths;
import ElementPaths.LoginPagePaths;
import Helpers.Helper;
import Helpers.Waits;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class ForgotPasswordElements extends Helper {
    // Constructor
    public ForgotPasswordElements(WebDriver driver) {
        Helper.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Initializing Xpath's
    @FindBy(css = LoginPagePaths.homeSignInButton)
    WebElement homeSignInButton;
    @FindBy(css = ForgotPasswordPaths.forgotPasswordButton)
    WebElement forgotPasswordButton;
    @FindBy(css = ForgotPasswordPaths.forgotEmail)
    WebElement forgotEmail;
    @FindBy(css = ForgotPasswordPaths.getNewPasswordButton)
    WebElement getNewPasswordButton;

    // Invalid Email
    public void invalidEmailScenario(){
        Waits.clickButton(driver, homeSignInButton, 30);
        Waits.clickButton(driver, forgotPasswordButton, 30);
        Waits.sendKeys(driver, forgotEmail, "123", 30);
        Waits.clickButton(driver, getNewPasswordButton, 30);

    }
    // Empty Email
    public void emptyEmailScenario(){
        forgotEmail.clear();
        Waits.sendKeys(driver, forgotEmail, "", 30);
        Waits.clickButton(driver, getNewPasswordButton, 30);
    }
    // Valid Email
    /*public void validEmailScenario(){

    }*/
}
