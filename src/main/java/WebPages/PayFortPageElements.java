package WebPages;


import ElementPaths.PayFortPagePaths;
import Helpers.Helper;
import Helpers.Utility;
import Helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class PayFortPageElements extends Helper {
    public PayFortPageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = PayFortPagePaths.countryDropDown)
    WebElement countryDropDown;
    @FindBy(css = PayFortPagePaths.bankDropDown)
    WebElement bankDropDown;
    @FindBy(css = PayFortPagePaths.installmentTypeDropDown)
    WebElement installmentTypeDropDown;
    @FindBy(css = PayFortPagePaths.cardHolderName)
    WebElement cardHolderName;
    @FindBy(css = PayFortPagePaths.cardNumber)
    WebElement cardNumber;
    @FindBy(css = PayFortPagePaths.expiryDate)
    WebElement expiryDate;
    @FindBy(css = PayFortPagePaths.CVV_Code)
    WebElement CVV_Code;
    @FindBy(css = PayFortPagePaths.agreementCheckBox)
    WebElement agreementCheckBox;
    @FindBy(css = PayFortPagePaths.payButton)
    WebElement payButton;
    public void fillBankForInstallment() throws IOException {
        Waits.waitForElements(driver,countryDropDown,60);
        cardHolderName.sendKeys(Utility.getValue("Credentials", "cardHolderName"));
        cardNumber.sendKeys(Utility.getValue("Credentials", "cardNumber"));
        expiryDate.sendKeys(Utility.getValue("Credentials", "expiryDate"));
        CVV_Code.sendKeys(Utility.getValue("Credentials", "CVV_Code"));
        agreementCheckBox.click();
        payButton.click();
    }
}
