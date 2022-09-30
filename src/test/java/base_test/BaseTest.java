package base_test;

import Helpers.Helper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



// This class can be used as reference how to initialize driver and run test cases
// Main Branch
public class BaseTest extends Helper{

    @BeforeTest
    public static void initializeDriver(){
        createInstance();
    }
    @Test (priority = 1)
    public void run(){
        System.out.println("Website Opened");
    }

    @AfterTest
    public void close(){
        System.out.println("Driver initialized");
//        driver.quit();


    }
}
