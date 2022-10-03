package WebPages;

import ElementPaths.LandingPagePaths;
import Helpers.Helper;
import Helpers.RandomData;
import Helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPageElements extends Helper {
    public LandingPageElements(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = LandingPagePaths.searchBarInputField)
    WebElement searchBarInputField;

    @FindBy(css = LandingPagePaths.searchResultListSingle)
    WebElement searchResultListSingle;

    public void searchProduct() {

        searchBarInputField.sendKeys("iphone");
    }

    public void selectProductFromSearchBar() throws InterruptedException {
        Waits.waitForElements(driver, searchResultListSingle,30);
        List<WebElement> searchResultList=driver.findElements(By.cssSelector(LandingPagePaths.searchResultList));
        int random_index = RandomData.randomNumber(searchResultList.size());
        int index=0;
        for (WebElement element:searchResultList) {
            if (0 == index) {
                element.click();
            }
            index++;
        }
    }

}