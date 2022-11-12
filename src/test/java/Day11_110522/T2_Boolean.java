package Day11_110522;

import ReusableLibrary.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T2_Boolean {
    WebDriver driver;
    @BeforeSuite
    public void SetChromeDriver(){
        driver = ReusableActions.setUpDriver();
    }//end of set driver method


    //verify that by default signed in option should be checked
    @Test(priority = 1)
    public void tc001_verifySignedInOptionIsChecked(){
        //navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com");
        //next we need to click on sign in button
        ReusableActions.clickAction(driver, "//*[@class = '_yb_1933e']", "Sign in button");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
    }//end of test 1

    @Test(dependsOnMethods = "tc001_verifySignedInOptionIsChecked")
    public void tc002_verifySignedInOptionIsUnChecked(){
        //click on check box to uncheck it
        ReusableActions.clickAction(driver, "//*[@class = 'stay-signed-in checkbox-container']", "Sign in check box");
        //verify that sign is option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
    }//end of test 1



    @AfterSuite
    public void quitTheSession() {

        driver.quit();
    }
}
