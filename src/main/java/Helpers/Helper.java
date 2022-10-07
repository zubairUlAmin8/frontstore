package Helpers;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Helper {
    public static WebDriver driver;

    public static void createInstance() throws IOException {
        String url = Utility.getValue("launch", "website");
        String browser = Utility.getValue("launch", "browser");
        driver = BrowserFactory.startBrowser(browser, url);
    }
<<<<<<< HEAD
=======

    public static void pause(int j) throws InterruptedException {
        for (int i = 0; i < j; i++) {
            Thread.sleep(950);
        }
    }
>>>>>>> origin/main
}
