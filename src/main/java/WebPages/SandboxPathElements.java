package WebPages;

import ElementPaths.SandboxPagePaths;
import Helpers.Helper;
import Helpers.Utility;
import Helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SandboxPathElements extends Helper {
    String currentFrame = null;
    public SandboxPathElements(WebDriver driver) {
        Helper.driver = driver;
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
        System.out.println("sandbox address: " + driver.getCurrentUrl());
        driver.switchTo().frame(sandboxIframe);
        Waits.waitForElements(driver, sandboxPasswordInputField, 60);
        sandboxPasswordInputField.sendKeys(Utility.getValue("Credentials", "sandboxPassword"));
        Waits.clickButton(driver, continueButton, 30);

//        System.out.println(sandboxIframe.getTagName());
//      Thread.sleep(50000);
//      driver.switchTo().parentFrame();
//      Thread.sleep(50000);




        String frame = "lo-cs-frame";

// make this currentFrame as global

        if ((null != frame) && (!"".equals(frame))) {
            if (!frame.equals(currentFrame)) {
                switchToFrame(frame);
                currentFrame = frame;
            }
        } else {
            currentFrame = "";
            driver.switchTo().defaultContent();
        }
    }
    public void switchToFrame(String frame) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frame);
    }

}
