package Action_Items;

import ReusableLibrary.ReusableAction_Loggers;
import ReusableLibrary.Reusable_Annotation;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ShelterInsurance_AI1 extends Reusable_Annotation {

    @Test (priority = 1)
        public void tc001_verifyHomeInsuranceGetAQuote() throws InterruptedException {
        //go to shelter insurance website
        driver.navigate().to("https://www.shelterinsurance.com/");
        //hover mouse over insurance
        ReusableAction_Loggers.mouseHover(driver,"//*[@id='nav-bar-insurance' and text()='Insurance']", logger, "Insurance");
        Thread.sleep(3000);
        //click on home insurance on the dropdown menu
        ReusableAction_Loggers.clickAction(driver,"//a[text()='Home Insurance']", logger, "Click Home Insurance");
        //click on learn more
        ReusableAction_Loggers.clickActionByIndex(driver,"//*[@class='button']",0,logger,"Learn more");
        //click on quote to get a quote
        ReusableAction_Loggers.clickAction(driver, "//*[@class='button white postfix getQuoteBtn']", logger, "Quote Button");
        //click on select a policy state dropdown
        ReusableAction_Loggers.clickAction(driver,"//*[@id='policyState']", logger, "select A policy state");
        //choose a policy state using select command
        ReusableAction_Loggers.selectByText(driver,"//*[@id='policyState']", "Colorado",logger,"Colorado");
        //click continue
        ReusableAction_Loggers.clickAction(driver,"//*[@class='button']", logger, "Continue");
    }//end of verify get a quote for home insurance

    @Test (dependsOnMethods = "tc001_verifyHomeInsuranceGetAQuote")
    public void tc002_fillingInformation(){
        //Type first name
        ReusableAction_Loggers.sendKeysAction(driver, "//*[@name='firstName']","Munmun",logger, "First Name");
        //Type Last Name
        ReusableAction_Loggers.sendKeysAction(driver, "//*[@name='lastName']","Ahmed",logger,"Last Name");
        //Type street address
        ReusableAction_Loggers.sendKeysAction(driver,"//*[@name='addressLine1']", "jdbisdfius", logger, "Address");
        //Type city
        ReusableAction_Loggers.sendKeysAction(driver,"//*[@name='city']", "Boulder", logger, "City");
        //Type zip
        ReusableAction_Loggers.sendKeysAction(driver, "//*[@name='zip']", "80301",logger,"Zip Code");
        //Type phone number - area code
        ReusableAction_Loggers.sendKeysAction(driver, "//*[@name='areaCode']", "516", logger, "Area code");
        //Type 3 digit phone number
        ReusableAction_Loggers.sendKeysAction(driver,"//*[@name='phone1']", "456", logger,"First 3 digits of number");
        //Type last 4 digits of
        ReusableAction_Loggers.sendKeysAction(driver,"//*[@name='phone2']","7865", logger,"last 4 digits of phone number");
        //click no for having an active policy with shelter insurance
        ReusableAction_Loggers.clickAction(driver,"//*[@id='hasOtherActivePolicies2']", logger, "ActiveMember");
        //click continue
        ReusableAction_Loggers.clickAction(driver,"//*[@class='button']",logger,"Continue");
    }//end of fill in info test case

    @Test (dependsOnMethods = "tc002_fillingInformation")
    public void tc003_findingAProvider() throws InterruptedException {
        //click on agent
        ReusableAction_Loggers.clickAction(driver, "//*[@id='agentKeyword1']",logger, "click box");
        //click continue
        ReusableAction_Loggers.clickAction(driver,"//*[@id='continue']",logger,"Continue");
        //typing in email
        ReusableAction_Loggers.sendKeysAction(driver,"//*[@id='emailAddress']","munmunahmed@rocketmail.com",logger,"Email");
        //wait 3 sec
        Thread.sleep(3000);
        //enter random text in the additional information section
        ReusableAction_Loggers.sendKeysAction(driver, "//textarea[@id='comments']", RandomStringUtils.randomAlphabetic(150),logger, "Random Text");
        //get Name of agent
        String agentName = ReusableAction_Loggers.getTextAction(driver,"//*[@class='four columns container margT']", logger, "Agent Info0");
        //split agent info
        String[] splitAgentInfo = agentName.split("Search");
        //print agents info
        System.out.println(splitAgentInfo[0]);
        //wait 3 sec
        Thread.sleep(3000);
        //HTML report
        logger.log(LogStatus.INFO,"The agents info is " + splitAgentInfo[0]);

    }//end of find a provider test case

}//end of class
