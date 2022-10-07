package WebPages;

import ElementPaths.ProductDetailsPagePaths;
import Helpers.Helper;
import Helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailPageElements extends Helper {
    public ProductDetailPageElements(WebDriver driver) {
        Helper.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = ProductDetailsPagePaths.addToCartButton)
    WebElement addToCartButton;
    @FindBy(css = ProductDetailsPagePaths.cartIcon)
    WebElement cartIcon;
    @FindBy(css = ProductDetailsPagePaths.viewCartItems)
    WebElement viewCartItems;


    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public void goToViewCartItems() {


        Actions action = new Actions(driver);
        action.moveToElement(cartIcon).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ProductDetailsPagePaths.viewCartItems)));
        element.click();


    }
}
