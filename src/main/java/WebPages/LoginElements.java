package WebPages;

import ElementPaths.LoginPagePaths;
import Helpers.Helper;
import Helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginElements extends Helper {
    public LoginElements(WebDriver driver) {
        Helper.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = LoginPagePaths.emailOrNumberInputField)
    WebElement emailOrNumberInputField;
    @FindBy(css = LoginPagePaths.passwordInputField)
    WebElement passwordInputField;
    @FindBy(css = LoginPagePaths.signInButton)
    WebElement signInButton;

    public void login() {
        Waits.sendKeys(driver, emailOrNumberInputField, "zubairul.amin@cartlow.com", 30);
        Waits.sendKeys(driver, passwordInputField, "123123123", 30);
        signInButton.click();
    }
}