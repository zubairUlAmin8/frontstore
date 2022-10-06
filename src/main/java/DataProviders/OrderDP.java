package DataProviders;

import org.testng.annotations.DataProvider;

public class OrderDP {
    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {
                {"Value Passed"},
                {"Value Failed"}
        };
    }
    @DataProvider(name = "orderNumberForCancelation")
    public Object[][] dpOrderCancelation(){
        return new Object[][]{
                {"874366"},
                {"874364"},
                {"874361"},
                {"874358"},
                {"874357"},
                {"874336"},
                {"874335"},
                {"874334"},
                {"874326"},
                {"874322"}

        };
    }

}
