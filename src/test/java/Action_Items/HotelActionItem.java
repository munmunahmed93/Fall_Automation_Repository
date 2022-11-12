package Action_Items;

import com.sun.tools.javac.Main;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class HotelActionItem {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> destination = new ArrayList<>();
        destination.add("California");
        destination.add("Texas");
        destination.add("Florida");

        ArrayList<Integer> adults = new ArrayList<>();
        adults.add(1);
        adults.add(2);
        adults.add(3);

        ArrayList<String> childAge = new ArrayList<>();
        childAge.add("5");
        childAge.add("8");
        childAge.add("2");

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        //add options for maximizing the chrome window
        options.addArguments("start-maximized", "incognito");

        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);


       for (int i = 0; i<destination.size(); i++) {

           //go to hotels site
           driver.navigate().to("https://www.hotels.com");


           //clicking on search option
           WebElement search = driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']"));
           //click on search icon
           search.click();

           //capture typing in search element
           WebElement type = driver.findElement(By.xpath("//*[@id='destination_form_field']"));
           //type in destinations
           type.sendKeys(destination.get(i));
           //wait 2 sec
           Thread.sleep(2000);

           //capture array list of destination
           ArrayList<WebElement> clickDestination = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-typeahead-button-label truncate']")));
           //click on first index
           clickDestination.get(0).click();
           //wait 2 sec
           Thread.sleep(2000);

           //store travelers in webelement
           WebElement travelers = driver.findElement(By.xpath("//*[@class='uitk-menu-trigger uitk-fake-input uitk-form-field-trigger']"));
           //click on travelers tab
           travelers.click();
           //wait 1 sec
           Thread.sleep(2000);

           //store multiple elements of similar xpaths for adding or minusing - into an arraylist
           ArrayList<WebElement> amount = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-icon uitk-step-input-icon uitk-icon-medium']")));
           //minus amount of adult to equal 1
           amount.get(0).click();
           Thread.sleep(2000);

           //Create a for loop to add adult
           for (int j=1; j < adults.get(i); j++) {
               //capture add icon then click
               driver.findElement(By.xpath("//*[@aria-label='Increase the number of adults in room 1']")).click();
               //wait 3 sec
               Thread.sleep(3000);

           }//end of for loop

           //capture xpath for adding a child
           ArrayList<WebElement> addChild= new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-icon uitk-step-input-icon uitk-icon-medium']")));
           //click on add 1 time
           addChild.get(3).click();
           //wwait 2 sec
           Thread.sleep(2000);

           //element for selecting childs age
           WebElement age = driver.findElement(By.xpath("//*[@name='child-traveler_selector_children_age_selector-0-0']"));
           //capture dropdown of childs age in select command
           Select kidsAge = new Select(age);
           //select age by visual text
           kidsAge.selectByVisibleText(childAge.get(i));
           // wait 3 sec
           Thread.sleep(3000);

           //click on done button after choosing childs age
           driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();
           //click on
           driver.findElement(By.xpath("//*[@id='submit_button']")).click();
           Thread.sleep(2000);

           //Arraylist for resorts
           ArrayList<WebElement> resort = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-card-link']")));

           //if else statements
           //if i is equal to the first state(california) then choose the first resort
           if (i==0){
               resort.get(1).click();
               //wait 4 sec
               Thread.sleep(4000);

               //if i is equal to the second state(Texas) then choose 3rd resort
           } else if (i==1) {
               resort.get(3).click();
               //wait 4 sec
               Thread.sleep(4000);

               //if i is equal to 3rd state(Florida) then click on the 2nd resort
           } else if (i==2) {
               resort.get(2).click();
               //wait 4 sec
               Thread.sleep(4000);
               
           }//end of if else statement

           //capture tab in an array list
           ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
           //switch tabs
           driver.switchTo().window(tabs.get(1));
           //wait 4 sec
           Thread.sleep(4000);

           //capture resort name in a string variable
           String name = driver.findElement(By.xpath("//*[@class='uitk-spacing uitk-spacing-padding-small-blockend-four uitk-spacing-padding-large-blockstart-three']")).getText();
           //
           Thread.sleep(4000);
           //split resort name
           String[] splitName = name.split("\\R");
           //print resort name
           System.out.println(splitName[0]);
           //wait 4 sec
           Thread.sleep(4000);








       }//end of for loop

        //driver.quit();
    }//end of main
}//end of class
