package WebPages;

import ElementPaths.CheckOutPagePaths;
import Helpers.Helper;
import Helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPageElements extends Helper {
    public CheckoutPageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = CheckOutPagePaths.codRadioButton)
    WebElement codRadioButton;

    @FindBy(css = CheckOutPagePaths.placeOrderButton)
    WebElement placeOrderButton;

    public void placeOrderWithCOD() throws InterruptedException {
        Waits.clickButton(driver, codRadioButton,30);
        Thread.sleep(5000);
//        Waits.clickButton(driver, placeOrderButton,30);
    }
}
