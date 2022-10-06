package WebPages;

import ElementPaths.LoginPagePaths;
import Helpers.Helper;
import Helpers.RandomData;
import Helpers.Waits;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import static Helpers.Helper.driver;

public class SocialLoginElements {
    // Object for Faker
    Faker faker = new Faker();
    //Constructor
    public SocialLoginElements(WebDriver driver) {
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

    // Gmail Page Xpath's
    @FindBy(css = LoginPagePaths.gEmail)
    WebElement gEmail;
    @FindBy(css = LoginPagePaths.gNextEmail)
    WebElement gNextEmail;
    @FindBy(css = LoginPagePaths.gPassword)
    WebElement gPassword;
    @FindBy(css = LoginPagePaths.gNextPass)
    WebElement gNextPass;

    // OTP Login
    @FindBy(css = LoginPagePaths.otpEmailOrPhoneNumber)
    WebElement otpEmailOrPhoneNumber;
    @FindBy(css = LoginPagePaths.continueButton)
    WebElement continueButton;


    // Facebook Login function
    public void facebookLoginVerify() {
        homeSignInButton.click();
        Waits.clickButton(driver, fbLoginButton, 30);
        Waits.sendKeys(driver, fbEmail, "gahin45469@aregods.com", 30);
        Waits.sendKeys(driver, fbPassword, "cartlow1122T", 30);
        Waits.clickButton(driver, fbButton, 30);
        Waits.clickButton(driver, accountButton, 30);
        Waits.clickButton(driver, logoutButton, 30);
    }

    // Gmail Login function
    public void gmailLoginVerify(){
        homeSignInButton.click();
        Waits.clickButton(driver, gmailLoginButton, 30);
        Waits.sendKeys(driver, gEmail, "talha.sajjad@cartlow.com", 30);
        Waits.clickButton(driver, gNextEmail, 30);
        Waits.sendKeys(driver, gPassword, "cartlow1122T", 30);
        Waits.clickButton(driver, gNextPass, 30);
        Waits.clickButton(driver, accountButton, 30);
        Waits.clickButton(driver, logoutButton, 30);
    }

    // Login with Email OTP
    public void otpWithEmailVerify(){
        homeSignInButton.click();
        Waits.clickButton(driver, otpLoginButton, 30);
        String fakeEmail = faker.internet().safeEmailAddress();
        Waits.sendKeys(driver, otpEmailOrPhoneNumber, fakeEmail,30);
    }
}
