package Helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;

public class Helper {
    public static WebDriver driver;
    public static ExtentReports extentReports;
    public static ExtentSparkReporter spark;
    public static ExtentTest test;
    public static void createInstance() {
        driver = BrowserFactory.startBrowser("edge", "https://web.cartlow.net/uae/en");
    }

    public static void startReport() {
        extentReports = new ExtentReports();
        spark = new ExtentSparkReporter("spark.html");
        spark.config().setDocumentTitle("Login Test Cases");
        spark.config().setReportName("Extent Report for Login");
        spark.config().setTheme(Theme.DARK);
        spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        extentReports.attachReporter(spark);
    }
}
