package WebPages;


import Helpers.Helper;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;

public class AdminOTPVerificationElements extends Helper {

    public static void adminOTPVerify() throws InterruptedException {
        driver.get("https://admin.cartlow.net/");
        pause(1);
        driver.findElement(By.cssSelector("#email")).sendKeys("qa@cartlow.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("123123123");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        pause(1);
        zoomOut();
        pause(1);
        driver.get("https://admin.cartlow.net/admin/sms-verification-log");
    }
}
