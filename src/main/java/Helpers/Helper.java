package Helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;

public class Helper {
    public static WebDriver driver;
    public static void createInstance() {
        driver = BrowserFactory.startBrowser("chrome", "https://cartlow.com/uae/en");
    }

}
