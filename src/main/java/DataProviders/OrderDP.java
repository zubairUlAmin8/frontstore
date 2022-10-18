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
                {"874624"},
                {"874636"},
                {"874638"},
                {"874635"},
                {"874633"},
                {"874631"},
                {"874630"},
                {"874630"},
                {"874628"},
                {"874626"},
                {"874625"}

        };
    }

}
