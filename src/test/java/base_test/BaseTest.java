package base_test;

import Helpers.Helper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


// This class can be used as reference how to initialize driver and run test cases
// Main Branch
public class BaseTest {
    @BeforeClass
    public void initializeDriver() {
        Helper.createInstance();
    }

    @AfterTest
    public void close() {
        System.out.println("Test End");
//        driver.quit();
    }
}
