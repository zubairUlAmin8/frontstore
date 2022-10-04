package Helpers;

import org.openqa.selenium.WebDriver;

public class Helper {
    public static WebDriver driver;
    public static void createInstance() {
        driver = BrowserFactory.startBrowser("chrome", "https://web.cartlow.net/uae/en");
    }

}
