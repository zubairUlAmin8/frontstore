package Helpers;

import BluePrint.LinkSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkVerficationHelper {
    public static List<LinkSheet> statusList = new ArrayList<>();
    public static List<WebElement> getAllPageLinks(WebDriver driver) {
        List<WebElement> allUrls=driver.findElements(By.tagName("a"));
        return allUrls;
    }

    public static List<WebElement> getAllImagesLinks(WebDriver driver) {
        List<WebElement> allImagesUrls=driver.findElements(By.tagName("img"));
        System.out.println("total number of images on this page: "+ allImagesUrls.size());
        return allImagesUrls;
    }

    public static void checkBrokenImages(WebDriver driver, List<WebElement> allImagesUrls) {
        //checking the links fetched.
        for(int index=0;index<allImagesUrls.size();index++)
        {
            WebElement image= allImagesUrls.get(index);
            String imageURL= image.getAttribute("src");
            System.out.println("URL of Image " + (index+1) + " is: " + imageURL);
            verifyLinks(imageURL);

            //Validate image display using JavaScript executor
            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);", image);
                if (imageDisplayed) {
                    System.out.println("DISPLAY - OK");
                }else {
                    System.out.println("DISPLAY - BROKEN");
                }
            }
            catch (Exception e) {
                System.out.println("Error Occured");
            }
    }
    }
    public static void checkBrokenUrl(List<WebElement> urlList) throws IOException {

        String link = "";
        Iterator<WebElement> urlListIterator= urlList.iterator();
        System.out.println(urlList.size());
//        while (urlListIterator.hasNext()) {
//            link=urlListIterator.next().getText();
//            System.out.println(link);
//        }
        int ok=0;
        int broken=0;


        for(int i=0;i<urlList.size();i++)
        {
            WebElement E1= urlList.get(i);
            String url= E1.getAttribute("href");
            if(verifyLinks(url)) {
                ok++;
                System.out.println(ok);
            }
            else {
                broken++;
            }
        }
        ExcelFileUtils.writeData(statusList);
        System.out.println("total Ok link"+ ok);
        System.out.println("total broken link"+ broken);
    }

    public static boolean verifyLinks(String linkUrl)
    {

        boolean status=false;
        try
        {
            URL url = new URL(linkUrl);

            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(20000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
                TextFile.writeFile("brokenLink", linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
                statusList.add(new LinkSheet(linkUrl, httpURLConnect.getResponseMessage()));

            }

            //Fetching and Printing the response code obtained
            else{
//                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
                TextFile.writeFile("brokenLink", linkUrl+" - "+httpURLConnect.getResponseMessage());

                statusList.add(new LinkSheet(linkUrl, httpURLConnect.getResponseMessage()));




                return true;
            }
        }catch (Exception e) {
        }
        return status;
    }
}
