package base_test;

import Helpers.Helper;
import Helpers.MyScreenRecorder;
import org.testng.annotations.*;

// This class can be used as reference how to initialize driver and run test cases
// Main Branch
public class BaseTest {
    @BeforeClass
    public  void initializeDriver() throws Exception {
        Helper.createInstance();
//        MyScreenRecorder.startRecording("OrderWithCard");
    }
    @AfterClass
    public void close() throws Exception {
        Helper.driver.quit();
//        MyScreenRecorder.stopRecording();
    }
}
