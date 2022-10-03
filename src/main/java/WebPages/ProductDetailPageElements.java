package WebPages;

import ElementPaths.ProductDetailsPagePaths;
import Helpers.Helper;
import Helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPageElements extends Helper {
    public ProductDetailPageElements(WebDriver driver) {
        this.driver = driver;
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
        cartIcon.click();
        Waits.clickButton(driver, viewCartItems,30);
    }
}
