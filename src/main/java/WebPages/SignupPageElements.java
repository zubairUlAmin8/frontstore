package WebPages;

import ElementPaths.LoginPagePaths;
import ElementPaths.SignupPaths;
import Helpers.Helper;
import Helpers.Waits;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPageElements extends Helper {
    // Object for Faker
    Faker faker = new Faker();

    // Constructor
    public SignupPageElements(WebDriver driver) {
        Helper.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Initializing Xpath's
    @FindBy(css = LoginPagePaths.homeSignInButton)
    @CacheLookup
    WebElement homeSignInButton;
    @FindBy(css = SignupPaths.signupButton)
    @CacheLookup
    WebElement signupButton;
    @FindBy(css = SignupPaths.signupEmail)
    @CacheLookup
    WebElement signupEmail;
    @FindBy(css = SignupPaths.signupPassword)
    @CacheLookup
    WebElement signupPassword;
    @FindBy(css = SignupPaths.signupFullName)
    @CacheLookup
    WebElement signupFullName;
    @FindBy(css = SignupPaths.signupRegisterButton)
    @CacheLookup
    WebElement signupRegisterButton;
    @FindBy(css = LoginPagePaths.accountButton)
    @CacheLookup
    WebElement accountButton;
    @FindBy(css = LoginPagePaths.logoutButton)
    @CacheLookup
    WebElement logoutButton;

    // Signup Function with Email
    public void signupEmailVerify() {
        Waits.clickButton(driver, homeSignInButton, 30);
        Waits.clickButton(driver, signupButton, 30);
        String fakeEmail = faker.internet().safeEmailAddress();
        Waits.sendKeys(driver, signupEmail, fakeEmail, 30);
        Waits.sendKeys(driver, signupPassword, "123123123", 30);
        String fakeFullName = faker.name().fullName();
        Waits.sendKeys(driver, signupFullName, fakeFullName, 30);
        Waits.clickButton(driver, signupRegisterButton, 30);
        Waits.clickButton(driver, accountButton, 30);
        Waits.clickButton(driver, logoutButton, 30);

    }

    // Signup function with Phone
    public void signupPhoneVerify() {
        Waits.clickButton(driver, homeSignInButton, 30);
        Waits.clickButton(driver, signupButton, 30);
        String fakePhoneNumber = faker.number().digits(7);
        Waits.sendKeys(driver, signupEmail, "+97150" + fakePhoneNumber, 30);
        Waits.sendKeys(driver, signupPassword, "123123123", 30);
        String fakeFullName = faker.name().fullName();
        Waits.sendKeys(driver, signupFullName, fakeFullName, 30);
        Waits.clickButton(driver, signupRegisterButton, 30);
        Waits.clickButton(driver, accountButton, 30);
        Waits.clickButton(driver, logoutButton, 30);
    }
}
