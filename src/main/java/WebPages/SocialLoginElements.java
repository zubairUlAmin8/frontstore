package WebPages;

import ElementPaths.LoginPagePaths;
import Helpers.Helper;
import Helpers.Waits;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.Set;

import static Helpers.Helper.*;

public class SocialLoginElements {
    // Object for Faker
    Faker faker = new Faker();

    // Constructor
    public SocialLoginElements(WebDriver driver) {
        Helper.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Initializing Xpath's
    @FindBy(css = LoginPagePaths.homeSignInButton)
    @CacheLookup
    WebElement homeSignInButton;
    @FindBy(css = LoginPagePaths.fbLoginButton)
    @CacheLookup
    WebElement fbLoginButton;
    @FindBy(css = LoginPagePaths.gmailLoginButton)
    @CacheLookup
    WebElement gmailLoginButton;
    @FindBy(css = LoginPagePaths.otpLoginButton)
    @CacheLookup
    WebElement otpLoginButton;
    @FindBy(css = LoginPagePaths.accountButton)
    @CacheLookup
    WebElement accountButton;
    @FindBy(css = LoginPagePaths.logoutButton)
    @CacheLookup
    WebElement logoutButton;

    // Facebook Page Xpath's
    @FindBy(css = LoginPagePaths.fbEmail)
    @CacheLookup
    WebElement fbEmail;
    @FindBy(css = LoginPagePaths.fbPassword)
    @CacheLookup
    WebElement fbPassword;
    @FindBy(css = LoginPagePaths.fbButton)
    @CacheLookup
    WebElement fbButton;

    // Gmail Page Xpath's
    @FindBy(css = LoginPagePaths.gEmail)
    @CacheLookup
    WebElement gEmail;
    @FindBy(css = LoginPagePaths.gNextEmail)
    @CacheLookup
    WebElement gNextEmail;
    @FindBy(css = LoginPagePaths.gPassword)
    @CacheLookup
    WebElement gPassword;
    @FindBy(css = LoginPagePaths.gNextPass)
    WebElement gNextPass;

    // OTP Login
    @FindBy(css = LoginPagePaths.otpEmailOrPhoneNumber)
    @CacheLookup
    WebElement otpEmailOrPhoneNumber;
    @FindBy(css = LoginPagePaths.continueButton)
    @CacheLookup
    WebElement continueButton;
    @FindBy(css = LoginPagePaths.otpVerificationText)
    @CacheLookup
    WebElement otpVerificationText;
    @FindBy(xpath = LoginPagePaths.otpCode)
    @CacheLookup
    WebElement otpCode;
    @FindBy(css = LoginPagePaths.confirmOTP)
    @CacheLookup
    WebElement confirmOTP;

    // Admin OTP
    @FindBy(xpath = LoginPagePaths.userPhoneOTP)
    WebElement userPhoneOTP;


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
    public void gmailLoginVerify() {
        homeSignInButton.click();
        Waits.clickButton(driver, gmailLoginButton, 30);
        Waits.sendKeys(driver, gEmail, "andrewmilne181@gmail.com", 30);
        Waits.clickButton(driver, gNextEmail, 30);
        Waits.sendKeys(driver, gPassword, "cartlow1122A", 30);
        Waits.clickButton(driver, gNextPass, 30);
        Waits.clickButton(driver, accountButton, 30);
        Waits.clickButton(driver, logoutButton, 30);
    }

    // Login with Email OTP
    public void otpWithEmailVerify() {
        homeSignInButton.click();
        Waits.clickButton(driver, otpLoginButton, 30);
        String fakeEmail = faker.internet().safeEmailAddress();
        Waits.sendKeys(driver, otpEmailOrPhoneNumber, fakeEmail, 30);
        Waits.clickButton(driver, continueButton, 30);
        Waits.waitForTextToBePresentInElement(driver, otpVerificationText, "OTP Verification", 30);
        Waits.sendKeys(driver, otpCode, "1111", 30);
        Waits.clickButton(driver, confirmOTP, 30);
        Waits.clickButton(driver, accountButton, 30);
        Waits.clickButton(driver, logoutButton, 30);
    }

    // Login with Phone OTP
    public void otpWithPhoneVerify() throws InterruptedException {
        homeSignInButton.click();
        Waits.clickButton(driver, otpLoginButton, 30);
        String fakePhone = faker.number().digits(7);
        Waits.sendKeys(driver, otpEmailOrPhoneNumber, "+97150" + fakePhone, 30);
        Waits.clickButton(driver, continueButton, 30);
        Waits.waitForTextToBePresentInElement(driver, otpVerificationText, "OTP Verification", 30);
        // Function calling for Tab switching
        switchWindow();
        driver.switchTo().window(childWindowId);
        // Function calling for Admin Side
        AdminOTPVerificationElements.adminOTPVerify();
        String save = userPhoneOTP.getText();
        driver.switchTo().window(parentWindowId);
        Waits.sendKeys(driver, otpCode, save, 30);
        Waits.clickButton(driver, confirmOTP, 30);
        Waits.clickButton(driver, accountButton, 30);
        Waits.clickButton(driver, logoutButton, 30);
    }
}
