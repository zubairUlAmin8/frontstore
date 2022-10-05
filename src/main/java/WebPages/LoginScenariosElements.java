package WebPages;

import ElementPaths.LoginPagePaths;
import Helpers.Helper;
import Helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginScenariosElements extends Helper{
    //Constructor
    public LoginScenariosElements(WebDriver driver){
        Helper.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Initializing Xpath
    @FindBy(css = LoginPagePaths.homeSignInButton)
    WebElement homeSignInButton;
    @FindBy(css = LoginPagePaths.emailOrNumberInputField)
    WebElement emailOrNumberInputField;
    @FindBy(css = LoginPagePaths.passwordInputField)
    WebElement passwordInputField;
    @FindBy(css = LoginPagePaths.signInButton)
    WebElement signInButton;
    @FindBy(css = LoginPagePaths.accountButton)
    WebElement accountButton;
    @FindBy(css = LoginPagePaths.logoutButton)
    WebElement logoutButton;

    //Login Function
    public void validCredentials(){
        homeSignInButton.click();
        Waits.sendKeys(driver, emailOrNumberInputField, "talha.user@cartlow.com", 30);
        Waits.sendKeys(driver, passwordInputField, "123123123", 30);
        signInButton.click();
        Waits.clickButton(driver, accountButton, 30);
        Waits.clickButton(driver, logoutButton, 30);
    }
    public void invalidCredentials(){
        homeSignInButton.click();
        Waits.sendKeys(driver, emailOrNumberInputField, "talha.user@cartlow.com", 30);
        Waits.sendKeys(driver, passwordInputField, "12312312", 30);
        signInButton.click();
    }
}
