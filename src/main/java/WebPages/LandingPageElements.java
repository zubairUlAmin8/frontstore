package WebPages;

import ElementPaths.LandingPagePaths;
import Helpers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class LandingPageElements extends Helper {
    public LandingPageElements(WebDriver driver) {
        Helper.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = LandingPagePaths.searchBarInputField)
    WebElement searchBarInputField;

    @FindBy(css = LandingPagePaths.searchResultListSingle)
    WebElement searchResultListSingle;
    @FindBy(css = LandingPagePaths.countryList)
    WebElement countryList;

    public void searchProduct() {

        searchBarInputField.sendKeys("iphone");
    }


    public void selectProductFromSearchBar() throws InterruptedException {
        Waits.waitForElements(driver, searchResultListSingle, 30);
        List<WebElement> searchResultList = driver.findElements(By.cssSelector(LandingPagePaths.searchResultList));
        int random_index = RandomData.randomNumber(searchResultList.size());
        int index = 0;
        for (WebElement element : searchResultList) {
            if (3 == index) {
                element.click();
            }
            index++;
        }
    }

    public void selectCountry(String countryName) {
        Waits.waitForElements(driver, countryList, 30);
        countryList.click();
        List<WebElement> countryList = driver.findElements(By.cssSelector(LandingPagePaths.countryListItems));
        for (WebElement element : countryList) {
            if (element.getText().equals(countryName)) {
                element.click();
                break;
            }
        }
    }

    public void verifyBrokenLinks(WebDriver driver) {
        this.driver=driver;
       List<WebElement> urlLinks= LinkVerficationHelper.getAllPageLinks(driver);
        LinkVerficationHelper.checkBrokenUrl(urlLinks);
    }

    public void verifyBrokenImages(WebDriver driver) {

        this.driver=driver;
        List<WebElement> allImagesLinks= LinkVerficationHelper.getAllImagesLinks(driver);
        LinkVerficationHelper.checkBrokenImages(driver, allImagesLinks);

    }
    }