package Day12_110622;

import ReusableLibrary.ReusableAction_Loggers;
import ReusableLibrary.Reusable_Annotation;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class T2_GoogleSearch_ReusableAnnotations extends Reusable_Annotation {

        @Test
        public void searchForBmw(){
            driver.navigate().to("https://www.google.com");
            //search for bmw on the search field
            ReusableAction_Loggers.sendKeysAction(driver,"//*[@name='q']","BMW",logger,"Search Field");
            //hit submit on google search button
            ReusableAction_Loggers.submitAction(driver,"//*[@name='btnK']",logger,"Google Search");
        }//end of test 1

        @Test(dependsOnMethods = "searchForBmw")
        public void captureSearchNumber(){
            //capture the search results text
            String results = ReusableAction_Loggers.getTextAction(driver,"//*[@id='result-stats']",logger,"Search Results");
            String[] arrayResult = results.split(" ");
            //print back to html report by using log INFO
            logger.log(LogStatus.INFO,"Search number for BMW is " + arrayResult[1]);
        }//end of test 2


}
