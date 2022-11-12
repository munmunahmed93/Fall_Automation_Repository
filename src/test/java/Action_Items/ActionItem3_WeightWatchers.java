package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import okhttp3.Address;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ActionItem3_WeightWatchers {
    public static void main(String[] args) throws InterruptedException {
        //set up chrome driver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        //add options for maximizing windows and go incognito
        options.addArguments("start-maximized" , "incognito");

        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);

        //Create an Array list for zip code
        ArrayList<String> zipCode = new ArrayList<>();

        zipCode.add("10467");
        zipCode.add("11561");
        zipCode.add("11435");

        for (int i = 0; i<zipCode.size(); i++){
            //navigate to weight watchers site
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");

            //wait 2 sec
            Thread.sleep(2000);

            //clear and enter new zip code in search for location/zip/city
            WebElement zCode = driver.findElement(By.xpath("//*[@id='location-search']"));

            //clear zip code
            zCode.click();

            //type new value in zipcode search bar
            zCode.sendKeys(zipCode.get(i));

            //store the search element in web element
            WebElement search = driver.findElement(By.xpath("//*[@class = 'ww button primary cta-1JqRp']"));
            //click on search
            search.click();
            //wait 2 sec
            Thread.sleep(2000);

            //
            ArrayList<WebElement> links = new ArrayList<>(driver.findElements(By.xpath("//*[@class='wrapperLink-2NobU']")));

            if (i==0){
                links.get(2).click();

            }else if (i==1){

                links.get(2).click();

            }else if (i==2){
                links.get(3).click();
            }//end of if else statement

            Thread.sleep(2000);

            //capture the address in a string variable
            String address = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
            //split address
            String[] splitAddress = address.split("Studio");
            //print zipcode with corresponding address
            System.out.println("The address for zip code " +  zipCode.get(i) + " is " + splitAddress[0]);
            //wait 2 sec
            Thread.sleep(2000);

            //define javascript executor
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //store in person schedule into web element variable
            WebElement inPersonSchedule = driver.findElement(By.xpath("//*[@id='studioWorkshopSchedule']"));
            //scroll into view of in person studio schedule
            jse.executeScript("arguments[0].scrollIntoView(true);", inPersonSchedule);
            //wait 2 seconds
            Thread.sleep(2000);

            //store in person schedule element in a string variable
            String schedule = driver.findElements(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).get(0).getText();
            //print statement with in person schedule
            System.out.println("The schedule for in person workshop is " + schedule);


        }//end of for loop
        //quite page
        driver.quit();
    }//end of main
}//end of class
