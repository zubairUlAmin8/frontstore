package WebPages;

import ElementPaths.CartPagePaths;
import Helpers.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPageElements extends Helper {
    public CartPageElements(WebDriver driver) {
        Helper.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = CartPagePaths.checkoutButton)
    WebElement checkoutButton;

    public void clickOnCheckoutButton() {
        checkoutButton.click();
    }
}
