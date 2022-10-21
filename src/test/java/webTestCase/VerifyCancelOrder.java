package webTestCase;

import DataProviders.OrderDP;
import WebPages.LoginElements;
import WebPages.MyOrdersPageElements;
import base_test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

import static Helpers.Helper.driver;

public class VerifyCancelOrder extends BaseTest {
    LoginElements loginElements;
    MyOrdersPageElements myOrdersPageElements;

//    @Test(dataProvider = "data-provider", dataProviderClass = OrderDP.class)
//    public void myTest (String val) {
//        System.out.println("Current Status : " + val);
//    }

    @Test(priority = 1)
    void userLogin() {
        loginElements = new LoginElements(driver);
        loginElements.clickOnAccountIcon();
        loginElements.login();
    }

    @Test(priority = 2)
    void openOrderList() throws InterruptedException {
        myOrdersPageElements = new MyOrdersPageElements(driver);
        myOrdersPageElements.openMyOrderList();

    }

    @Test(priority = 3, dataProvider = "orderNumberForCancelation", dataProviderClass = OrderDP.class)
    void cancelOrder(String orderNumber) throws InterruptedException {
        myOrdersPageElements.cancelOrder(orderNumber);
    }

    @Test
    void testmy() {
        System.out.println("Test Resport");
    }
}
