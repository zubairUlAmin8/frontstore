package WebPages;

import ElementPaths.ThankYouPagePaths;
import Helpers.Helper;
import Helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankYouPageElements extends Helper {
    public ThankYouPageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ThankYouPagePaths.thankYou)
    WebElement thankYou;

    public boolean verifyOrderPlacedOrNot() {
        Waits.waitForElements(driver,thankYou,100);
        driver.switchTo().defaultContent();
        Boolean status = false;
        Waits.waitForElements(driver,thankYou,50);
        String checkString = thankYou.getText();
        System.out.println("string is:" +checkString);

        if (checkString.startsWith("Thank you for your order")) {
            status = true;
        }
        return status;
    }
}
