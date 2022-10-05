package base_test;

import Helpers.Helper;
import Helpers.MyScreenRecorder;
import org.testng.annotations.*;

// This class can be used as reference how to initialize driver and run test cases
// Main Branch
public class BaseTest {
    @BeforeClass
<<<<<<< HEAD
    public  void initializeDriver() throws Exception {
=======
    public void initializeDriver() {
>>>>>>> origin
        Helper.createInstance();

    }

<<<<<<< HEAD
    @AfterClass
    public void close() throws Exception {
=======
    @AfterTest
    public void close() {
>>>>>>> origin
        System.out.println("Test End");
//        Helper.driver.quit();
    }
}
