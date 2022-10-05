package WebPages;

import ElementPaths.SandboxPagePaths;
import Helpers.Helper;
import Helpers.Utility;
import Helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SandboxPathElements extends Helper {
    public SandboxPathElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = SandboxPagePaths.sandboxPasswordInputField)
    WebElement sandboxPasswordInputField;
    @FindBy(css = SandboxPagePaths.continueButton)
    WebElement continueButton;

    @FindBy(css = SandboxPagePaths.sandboxIframe)
    WebElement sandboxIframe;

    public void verifyPaymentProcessBySandbox() throws IOException, InterruptedException {
        Waits.waitForElements(driver, sandboxIframe, 60);
        System.out.println("sandbox address: "+driver.getCurrentUrl());
        driver.switchTo().frame(sandboxIframe);
        Waits.waitForElements(driver, sandboxPasswordInputField, 60);
        sandboxPasswordInputField.sendKeys(Utility.getValue("Credentials","sandboxPassword"));
        Waits.clickButton(driver, continueButton,30);
        Thread.sleep(5000);
        driver.switchTo().parentFrame();
    }

}
