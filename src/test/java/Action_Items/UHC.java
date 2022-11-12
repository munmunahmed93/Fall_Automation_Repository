package Action_Items;

import ReusableLibrary.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class UHC {

    WebDriver driver;
    @BeforeSuite
    public void SetChromeDriver(){
        //reusable method to define and launch webdriver
        driver = ReusableActions.setUpDriver();
    }//end of set driver method

    @Test(priority = 0)
    public void testCase1() throws InterruptedException {
        //navigate to website
        driver.navigate().to("https://www.uhc.com");
        //wait 3 sec
        Thread.sleep(3000);
        //click find a doctor
        ReusableActions.clickAction(driver, "//*[@href='/find-a-doctor']", "Find a Doctor");
        //wait 3 sec
        Thread.sleep(3000);
        //declare javascript executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll down
        jse.executeScript("scroll (0,700)");
        //wait 3 sec
        Thread.sleep(3000);
        //click on find a dentist
        ReusableActions.clickAction(driver, "//*[@aria-label='Find a dentist Opens a new window']", "Click find a dentist");
        //arraylist for tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch tabs
        driver.switchTo().window(tabs.get(1));
        //refresh page
        driver.navigate().refresh();
        //wait 3 sec
        Thread.sleep(3000);
      //  ReusableActions.clickAction(driver, "//*[text()='Employer and Individual Plans']", "Plan");
        List<WebElement> links = driver.findElements(By.xpath("//*[@ng-repeat='child in ::GuidedSearch.step.children']"));
        links.get(0).click();
        //wait 1 sec
        Thread.sleep(1000);
    }

    @Test(priority = 1)
    public void testCase2() throws InterruptedException {
        //wait 5 sec
        Thread.sleep(5000);
        //click on search
        ReusableActions.clickAction(driver, "//*[@id='location']", "click search");
        //wait 3 sec
        Thread.sleep(3000);
        //type in zipcode
        ReusableActions.sendKeysAction(driver,"//*[@id='location']","10467 ", "Zip Code");
        //wait 5 sec
        Thread.sleep(5000);
       // ReusableActions.mouseHover(driver, "//*[@class='link result truncated ally-focus-within active']", "Hovering mouse for zip code");
      ReusableActions.clickAction(driver, "//*[@id='locationTypeaheadResults']","Zip Code Link");
        //wait 3 sec
      Thread.sleep(3000);
      //hover mouse on continue
      ReusableActions.mouseHover(driver,"//*[text()='Continue']", "Hovering Mouse");
      //submit continue
      ReusableActions.submitAction(driver,"//*[@cs-id='locationSubmit']","Continue");
        //wait 5 sec
      Thread.sleep(5000);
      //click on national options
      ReusableActions.clickActionByIndex(driver,"//*[@class='sc-jomqko TEkcT']",0,"NationalOptions");
      //wait 3 sec
        Thread.sleep(3000);
        //refresh the page
        driver.navigate().refresh();
        //click on general dentist
        ReusableActions.clickActionByIndex(driver,"//*[@class='sc-jgPyTC gXqeMb']",0,"Click on general dentist");
        //wait 3 sec
        Thread.sleep(3000);
//        ReusableActions.clickActionByIndex(driver,"//*[@class='sc-gSYDnn fslDuO']", 0,"General Dentist");
    }//Second test


    @Test(priority = 2)
    public void testCase3() throws InterruptedException {
        //click on within 20 miles to find a dentist
        ReusableActions.selectByText(driver,"//*[contains(@class,'radiusMiles ng-pristine')]","'Within 20 Miles","miles dropdown");
        //refresh the page
        driver.navigate().refresh();
        //wait 4 sec
        Thread.sleep(4000);
        //click on dentist name
        ReusableActions.clickActionByIndex(driver, "//*[@class='ally-focus-within']", 0, "Dentist Name");
        //wait 4 sec
        Thread.sleep(4000);
        //click on save button
        ReusableActions.clickAction(driver, "//*[@class='cta-header-button action-btn saved-provider-button negative ally-focus-within']", "save");
        //wait 4 sec
        Thread.sleep(4000);
        //string to print address
        String address = ReusableActions.getTextAction(driver,"//*[@id='label__selectedLocation0']", "Address");
        //wait 4 sec
        Thread.sleep(4000);
        //string to print mile
        String mile = ReusableActions.getTextAction(driver, "//*[text()='0.3 Miles Away']", "Mile");
        //wait 4 sec
        Thread.sleep(4000);
        //string to print in network
        String inNetwork = ReusableActions.getTextAction(driver, "//*text()='In-Network']", "In Network");
        //wait 4 sec
        Thread.sleep(4000);
        //print statement
        System.out.println("Address:" +address + " Miles:"+ mile + " Network:"+ inNetwork);
        //close tab
        driver.close();

    }//Third test



    @Test(priority = 3)
    public void t4 () throws InterruptedException {
        //Switch back to original tab
        ReusableActions.switchToTabByIndex(driver, 0);
//        //click in search field
//        ReusableActions.clickAction(driver,"//*[@id='search-desktop']", "Click on Search");
        //wait 3 sec
        Thread.sleep(3000);
        //type doctor in search field
        ReusableActions.sendKeysAction(driver,"//*[@id='search-desktop']", "Doctor", "Search Doctor");
        //wait 3 sec
        Thread.sleep(3000);
        //click search
        ReusableActions.submitAction(driver, "//*[@id='search__button-desktop']", "Click Search");
        //Get heading by storing it in a string
        String searchNumber =  ReusableActions.getTextAction(driver,"//*[@id='search-results-count__header']","searchSplit");
        //split string
        String [] split =searchNumber.split(" ");
        //print statement
        System.out.println("my search result value: " + split[0] + split[1] + split[2]);
    }//fourth test




    @AfterSuite
    public void quitTheSession(){
        //quit windows
        driver.quit();
    }//end of after suite


}//End of class
