package WebPages;

import ElementPaths.LandingPagePaths;
import Helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageElements extends Helper {
    public LandingPageElements(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = LandingPagePaths.searchBarInputField)
    WebElement searchBarInputField;

    public void searchProduct() {

        searchBarInputField.sendKeys("iphone");
    }

}