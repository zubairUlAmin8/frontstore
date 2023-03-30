package WebPages;

import ElementPaths.HomepageCategoryLinks;
import Helpers.Helper;
import Helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class HomePageCategoryLinkElements extends Helper {

    // Constructor
    public HomePageCategoryLinkElements(WebDriver driver) {
        Helper.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Initializing Xpath's
    @FindBy(xpath = HomepageCategoryLinks.allCategoryLink)
    @CacheLookup
    WebElement allCategoryLink;
    @FindBy(how = How.XPATH, using = "//*[@id=\"navbarCollapse\"]/div/ul/li/div/div//following-sibling::a")
    @CacheLookup
    public List<WebElement> allNavBarLinks;

    public void verifyHomePageCategoryLinks() throws IOException {

        Waits.clickButton(driver, allCategoryLink, 30);

        // Delete existing file to avoid duplication of data in file
        try {
            boolean is_Deleted = Files.deleteIfExists(Paths.get(Helper.linkFolder + "/" + Helper.linkFile));
            if (is_Deleted) {
                System.out.println("File is successfully deleted!");
            } else {
                System.out.println("Sorry, the file was not deleted.");
            }
        } catch (DirectoryNotEmptyException e) {
            System.out.println("Directory is not empty!");
        }

        // If some I/O error occurred
        catch (IOException e) {
            System.out.println("I/O error occurred");
        }

        // Delete access denied issue
        catch (SecurityException e) {
            System.out.println("Delete access denied!");
        }

        // Function calling for initializing link.txt file
        Helper.initFileWriter();

        for (WebElement element : allNavBarLinks) {
            // Function calling for writing links in link.txt
            writeFile(element.getAttribute("href"));
        }
        // Function calling to close txt file when all data is written
        tearDown();

        // Reading file and opening all links mentioning in file
        File file = new File(Helper.linkFolder + "/" + Helper.linkFile);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Reading file using while loop
        /*String str = null;
        while ((str = bufferedReader.readLine())!= null){
            *//*driver.get(str);*//*
            System.out.println(str);
        }*/

        //Reading file using for loop
        for (int i = 1; i <= allNavBarLinks.size(); i++) {
            String printURL = bufferedReader.readLine();
            System.out.println(printURL+" || URL count is: "+i);
        }
        bufferedReader.close();
    }
}
