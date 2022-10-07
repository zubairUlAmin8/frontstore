package base_test;

import Helpers.Helper;
import Helpers.MyScreenRecorder;
import org.testng.annotations.*;

public class BaseTest {
    @BeforeClass
<<<<<<< HEAD
    public  void initializeDriver() throws Exception {
        Helper.createInstance();
        MyScreenRecorder.startRecording("OrderWithCard");
    }
    @AfterClass
    public void close() throws Exception {
        Helper.driver.quit();
        MyScreenRecorder.stopRecording();
=======
    public void initializeDriver() throws Exception {
        Helper.createInstance();
        MyScreenRecorder.startRecording("Valid Login");

    }

    @AfterClass
    public void close() throws Exception {
        System.out.println("Test End");
        MyScreenRecorder.stopRecording();
//        Helper.driver.quit();
>>>>>>> origin/main
    }
}
