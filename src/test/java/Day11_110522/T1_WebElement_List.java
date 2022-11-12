package Day11_110522;

import ReusableLibrary.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class T1_WebElement_List {

    WebDriver driver;
    ArrayList<WebElement> totalNumberHeaders, mainMenuHeader;
    @BeforeSuite
    public void SetChromeDriver(){
        driver = ReusableActions.setUpDriver();
        //navigate to website
        driver.navigate().to("https://www.usps.com");
        //store all the elements of the menu header into an arraylist of web elements
        totalNumberHeaders = new ArrayList<>(driver.findElements(By.xpath("//*[@class='nav-list']/li")));
    }//end of before suite


    //Test Case 1 should verify the total count of the displayed menu headers
    @Test(priority = 1)
    public void tc001_verifyTotalCountOfNumberHeaders(){
        System.out.println("The total number of menu headers is: " + totalNumberHeaders.size());
    }//end of test 1

    //click on first dropdown
    @Test(priority = 2)
    public void tc002_ClickOnTheFirstDropDown(){
        totalNumberHeaders.get(0).click();
    }//end of test 2

    //verify the sub menu header
    @Test(priority = 3)
    public void tc003_verifyCountOfMainMenuHeader(){
        mainMenuHeader= new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'menuheader']")));
        System.out.println("The total number of the menu header is " + mainMenuHeader.size());
    }//end of test 2


    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of after suite
}//end of class
