package Day12_110622;

import ReusableLibrary.ReusableAction_Loggers;
import ReusableLibrary.Reusable_Annotation;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static ReusableLibrary.Reusable_Annotation.driver;
import static ReusableLibrary.Reusable_Annotation.logger;

public class T3_YahooScenario_ReusableAnnotations extends Reusable_Annotation {
    @Test(priority = 1)
    public void tc001_verifySignedInOptionIsChecked() throws InterruptedException {
        //first navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com/");
        //next we need to click on sign in button
        ReusableAction_Loggers.clickAction(driver,"//*[@class = '_yb_1933e']",logger,"Sign In");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
        logger.log(LogStatus.INFO,"The checkbox check condition is: " + isSignInChecked);
    }//end of test 1

    @Test(dependsOnMethods = "tc001_verifySignedInOptionIsChecked")
    public void tc002_verifySignedInOptionIsUnChecked() {
        //click on check box to uncheck it
        ReusableAction_Loggers.clickAction(driver,"//*[@class= 'stay-signed-in checkbox-container']",logger,"Check Box Unchecked");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
        logger.log(LogStatus.INFO,"The checkbox check condition is: " + isSignInChecked);
    }//end of test 2


}
