package WebPages;

import ElementPaths.LoginPagePaths;
import Helpers.Helper;
import Helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import static Helpers.Helper.driver;

public class SocialLoginElements {
    //Constructor
    public SocialLoginElements(WebDriver driver){
        Helper.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Initializing Xpath's
    @FindBy(css = LoginPagePaths.homeSignInButton)
    WebElement homeSignInButton;
    @FindBy(css = LoginPagePaths.fbLoginButton)
    WebElement fbLoginButton;
    @FindBy(css = LoginPagePaths.gmailLoginButton)
    WebElement gmailLoginButton;
    @FindBy(css = LoginPagePaths.otpLoginButton)
    WebElement otpLoginButton;
    @FindBy(css = LoginPagePaths.accountButton)
    WebElement accountButton;
    @FindBy(css = LoginPagePaths.logoutButton)
    WebElement logoutButton;

    // Facebook Page Xpath's
    @FindBy(css = LoginPagePaths.fbEmail)
    WebElement fbEmail;
    @FindBy(css = LoginPagePaths.fbPassword)
    WebElement fbPassword;
    @FindBy(css = LoginPagePaths.fbButton)
    WebElement fbButton;

    // Facebook Login function
    public void facebookLoginVerify(){
        homeSignInButton.click();
        Waits.clickButton(driver, fbLoginButton, 30);
        Waits.sendKeys(driver, fbEmail, "gahin45469@aregods.com", 30);
        Waits.sendKeys(driver, fbPassword, "cartlow1122T", 30);
        Waits.clickButton(driver, fbButton, 30);
        Waits.clickButton(driver,accountButton, 30);
        Waits.clickButton(driver, logoutButton, 30);
    }
}
