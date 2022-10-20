package base_test;

import Helpers.Helper;
import Helpers.MyScreenRecorder;
import org.testng.annotations.*;

public class BaseTest {
    @BeforeClass

    public  void initializeDriver() throws Exception {
        Helper.createInstance();
        String className = getTestClassName();
        MyScreenRecorder.startRecording(className);
    }

    public String getTestClassName() throws Exception {
        String className = this.getClass().getSimpleName();
        return className;
    }


    @AfterClass
    public void close() throws Exception {
        Helper.driver.quit();
        MyScreenRecorder.stopRecording();
    }
}
