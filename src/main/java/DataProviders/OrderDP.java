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
                {"874306"},
                {"874303"},
                {"874302"},
                {"874312"},
                {"874313"}

        };
    }

}
