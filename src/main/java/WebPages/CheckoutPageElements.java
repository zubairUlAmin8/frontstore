package WebPages;

import ElementPaths.CheckOutPagePaths;
import Helpers.Helper;
import Helpers.Utility;
import Helpers.Waits;
import dev.failsafe.internal.util.Assert;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CheckoutPageElements extends Helper {
    public CheckoutPageElements(WebDriver driver) {
        Helper.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = CheckOutPagePaths.codRadioButton)
    WebElement codRadioButton;

    @FindBy(css = CheckOutPagePaths.placeOrderButton)
    WebElement placeOrderButton;
    @FindBy(css = CheckOutPagePaths.cardNumberInputField)
    WebElement cardNumberInputField;
    @FindBy(css = CheckOutPagePaths.cardExpiryMonth)
    WebElement cardExpiryMonth;
    @FindBy(css = CheckOutPagePaths.cardExpiryYear)
    WebElement cardExpiryYear;
    @FindBy(css = CheckOutPagePaths.CVV_CodeInputField)
    WebElement CVV_CodeInputField;
    @FindBy(css = CheckOutPagePaths.cardHolderNameInputFiled)
    WebElement cardHolderNameInputFiled;
    @FindBy(css = CheckOutPagePaths.payNowButton)
    WebElement payNowButton;
    @FindBy(css = CheckOutPagePaths.creditCardWithInstallmentRadio)
    WebElement creditCardWithInstallmentRadio;

    public void placeOrderWithCOD() throws InterruptedException {
        Waits.clickButton(driver, codRadioButton, 30);
        Thread.sleep(5000);
        Waits.clickButton(driver, placeOrderButton, 30);
    }

    public void payWithCard() throws IOException {
        Waits.waitForElements(driver, cardNumberInputField, 30);
        cardNumberInputField.sendKeys(Utility.getValue("Credentials", "cardNumber"));
        cardExpiryMonth.sendKeys(Utility.getValue("Credentials", "cardExpiryMonth"));
        cardExpiryYear.sendKeys(Utility.getValue("Credentials", "cardExpiryYear"));
        CVV_CodeInputField.sendKeys(Utility.getValue("Credentials", "CVV_Code"));
        cardHolderNameInputFiled.sendKeys(Utility.getValue("Credentials", "cardHolderName"));
    }

    public void clickToPayWithCard() {
        payNowButton.click();
    }

    public void selectCreditCardWithInstallment() {
        Waits.waitForElements(driver, creditCardWithInstallmentRadio, 30);
        creditCardWithInstallmentRadio.click();
    }
}
