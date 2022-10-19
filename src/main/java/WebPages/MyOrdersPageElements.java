package WebPages;

import Helpers.Helper;
import Helpers.Utility;
import org.bouncycastle.dvcs.DVCSRequestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MyOrdersPageElements extends Helper {
    public MyOrdersPageElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    LoginElements loginElements;

    public void openMyOrderList() throws InterruptedException {
        Thread.sleep(6000);
        Actions actions = new Actions(driver);
        loginElements = new LoginElements(driver);
        WebElement element = driver.findElement(By.cssSelector("a.topbar-link.dropdown-toggle>span[class=\"text username-limit\"]"));
        actions.moveToElement(element).perform();
        driver.findElement(By.cssSelector("a[class=\"dropdown-item\"]:first-of-type")).click();
    }

    public void cancelOrder(String orderNumber) throws InterruptedException {
        System.out.println(orderNumber);
        String orderNumberPath = "tr>td:first-of-type";
        WebElement ancestor = driver.findElement(By.cssSelector("table[class=\"table table-hover mb-0\"]>tbody"));
        List<WebElement> orderNumbers = driver.findElements(By.cssSelector(orderNumberPath));
        for (WebElement element : orderNumbers) {
            String backUrl=driver.getCurrentUrl();
            WebElement status = driver.findElement(By.cssSelector(orderNumberPath + "+td+*"));
//            System.out.println(element.getText() +" ::::"+status.getText());
            String newpath = Utility.getXpath(element, ancestor);
            System.out.println(newpath);
            String mypath = "/" + newpath + "/following-sibling::td[2]";
            String orderClickablePath="/" + newpath + "//a";
            System.out.println(mypath);
            WebElement orderStatus = driver.findElement(By.xpath(mypath));
            WebElement orderClickable = driver.findElement(By.xpath(orderClickablePath));
            System.out.println(orderStatus.getText());
            try {
                if (orderStatus.getText().equals("Pending") && element.getText().equals(orderNumber)){
                    System.out.println("condition satisfy");
                    orderClickable.click();
                    System.out.println(element.getText());
                }
                else {
                    System.out.println("Order#"+element.getText()+" is not in pending so state so we can't cancel this order");
                    continue;
                }
            } catch (Exception e) {

            }
            WebElement cancelButton = driver.findElement(By.xpath("//a[@href=\"#order-cancel\"]"));
            cancelButton.click();
            Thread.sleep(500);
            WebElement reason = driver.findElement(By.cssSelector("select[name=\"cancellation_reason\"]"));
            Select cancellationReason = new Select(reason);
            cancellationReason.selectByIndex(1);
            driver.findElement(By.cssSelector("textarea[name=\"comments\"]")).sendKeys("don't linke");
            driver.findElement(By.cssSelector("div[class=\"form-group\"]>button[type=\"submit\"]")).click();
            driver.get(backUrl);
            break;
        }

    }

}
