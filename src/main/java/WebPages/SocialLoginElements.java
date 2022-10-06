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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Helpers.Helper.driver;
import static Helpers.Helper.pause;

public class SocialLoginElements {
    // Object for Faker
    Faker faker = new Faker();
    //Waiting for element
    public WebDriverWait wait;

    //Constructor
    public SocialLoginElements(WebDriver driver) {
        Helper.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
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
    @FindBy(css = LoginPagePaths.otpVerificationText)
    WebElement otpVerificationText;
    @FindBy(xpath = LoginPagePaths.otpCode)
    WebElement otpCode;
    @FindBy(css = LoginPagePaths.confirmOTP)
    WebElement confirmOTP;


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
        Waits.sendKeys(driver, gEmail, "talha.sajjad@cartlow.com", 30);
        Waits.clickButton(driver, gNextEmail, 30);
        Waits.sendKeys(driver, gPassword, "cartlow1122T", 30);
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
        wait.until(ExpectedConditions.textToBePresentInElement(otpVerificationText, "OTP Verification"));
        Waits.sendKeys(driver, otpCode, "1111", 30);
        Waits.clickButton(driver, confirmOTP, 30);
        Waits.clickButton(driver, accountButton, 30);
        Waits.clickButton(driver, logoutButton, 30);
    }

    // Login with Phone OTP
    public void otpWithPhoneVerify() {
        homeSignInButton.click();
        Waits.clickButton(driver, otpLoginButton, 30);
        String fakePhone = faker.number().digits(7);
        Waits.sendKeys(driver, otpEmailOrPhoneNumber, "+97150" + fakePhone, 30);
        Waits.clickButton(driver, continueButton, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(otpVerificationText, "OTP Verification"));
        Waits.sendKeys(driver, otpCode, "1111", 30);
        Waits.clickButton(driver, confirmOTP, 30);
        Waits.clickButton(driver, accountButton, 30);
        Waits.clickButton(driver, logoutButton, 30);
    }
}
