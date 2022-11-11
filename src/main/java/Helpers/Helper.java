package Helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Helper {
    public static WebDriver driver;
    public static String parentWindowId;
    public static String childWindowId;
    protected static String linkFolder = "Links";
    protected static String linkFile = "link.txt";
    static FileWriter fileWriter;
    static BufferedWriter bufferedWriter;
    protected static String url;

    public static void createInstance() throws IOException {
        String url = Utility.getValue("launch", "website");
        String browser = Utility.getValue("launch", "browser");
        driver = BrowserFactory.startBrowser(browser, url);
    }

    public static void pause(int j) throws InterruptedException {
        for (int i = 0; i < j; i++) {
            Thread.sleep(950);
        }
    }

    // Function for zoom out screen
    public static void zoomOut() {
        String zoomOutJS;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        zoomOutJS = "document.body.style.zoom='0.7'";
        js.executeScript(zoomOutJS);
    }

    // Function for Window Switch
    public static void switchWindow() {
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> handles = driver.getWindowHandles();
        List<String> ls = new ArrayList<>(handles);
        parentWindowId = ls.get(0);
        childWindowId = ls.get(1);
    }
    public static String getCurrentDir() {
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }

    public static void initFileWriter() throws IOException {
        fileWriter = new FileWriter(linkFolder + "/" + linkFile, true);
        bufferedWriter = new BufferedWriter(fileWriter);
    }

    public static void writeFile(String href) throws IOException {
        bufferedWriter.write(href);
        bufferedWriter.newLine();
    }
    public static void tearDown() throws IOException {
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
