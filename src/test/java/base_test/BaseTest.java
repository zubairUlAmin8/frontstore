package base_test;

import Helpers.Helper;
import Helpers.MyScreenRecorder;
import org.testng.annotations.*;

public class BaseTest {
    @BeforeClass

    public  void initializeDriver() throws Exception {
        Helper.createInstance();
    }
    @BeforeTest
    public void check() throws Exception {
        String className = this.getClass().getSimpleName();
        MyScreenRecorder.startRecording(className);
        System.out.println(className);
    }
    @AfterClass
    public void close() throws Exception {
        Helper.driver.quit();
        MyScreenRecorder.stopRecording();

    }
}
