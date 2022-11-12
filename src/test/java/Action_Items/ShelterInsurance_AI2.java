package Action_Items;

import ReusableLibrary.ReusableAction_Loggers;
import ReusableLibrary.Reusable_Annotation;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class ShelterInsurance_AI2 extends Reusable_Annotation {

    @Test(priority = 1)
    public void tc001_clickOnAgent() throws InterruptedException {
        //go to shelter insurance website
        driver.navigate().to("https://www.shelterinsurance.com/");
        //hover mouse over insurance
        ReusableAction_Loggers.mouseHover(driver,"//*[@id='nav-bar-insurance' and text()='Insurance']", logger, "Insurance");
        Thread.sleep(3000);
        //click on home insurance on the dropdown menu
        ReusableAction_Loggers.clickAction(driver,"//a[text()='Home Insurance']", logger, "Click Home Insurance");
        //type in zip code
        ReusableAction_Loggers.sendKeysAction(driver, "//*[@id='agentSearchBoxInput']","10467", logger, "Type Zip");
        //click find
        ReusableAction_Loggers.clickAction(driver,"//*[@id='findAgentButton']", logger,"click find");
    }//end of clicking on an agent

    @Test(dependsOnMethods = "tc001_clickOnAgent")
    public void tc002_pickAnAgentInYourArea() throws InterruptedException {
        ReusableAction_Loggers.clickActionByIndex(driver, "//*[@class='circle-cropper']", 2,logger,"Click Agent");
        //click on contact me for your agent
        ReusableAction_Loggers.clickAction(driver,"//*[@class='button text-center large']",logger,"Contact Me");
        Thread.sleep(2000);
        //type in name
        ReusableAction_Loggers.sendKeysAction(driver,"//*[@id='firstName']","Munmun",logger,"First Name");
        Thread.sleep(2000);
        //type laast name
        ReusableAction_Loggers.sendKeysAction(driver,"//*[@id='lastName']","Ahmed", logger,"Last Name");
        Thread.sleep(2000);
        //type email
        ReusableAction_Loggers.sendKeysAction(driver,"//*[@id='emailAddress']","munmunahmed@rocketmail.com", logger,"Email");
        //Type Random info in the info section
        ReusableAction_Loggers.sendKeysAction(driver, "//*[@id='details']", RandomStringUtils.randomAlphabetic(150),logger,"Type info");
        //wait 200 sec
        Thread.sleep(2000);
        //click cancel
        ReusableAction_Loggers.clickAction(driver,"//*[@class='button white close-reveal-modal']",logger,"click cancel");

    }//end of picking an agent

    @Test(priority = 2)
    public void tc003_CaptureAgentsInfoAndTitle() throws InterruptedException {
        //get Name of agent
        String agentInfo = ReusableAction_Loggers.getTextAction(driver,"//*[@class='pad']", logger, "Agent Info");
        //print agents info
        System.out.println(agentInfo);
        //wait 3 sec
        Thread.sleep(3000);
        //catpure info in HTML report
        logger.log(LogStatus.INFO,"The agents info is " + agentInfo);
        //go back to the home page
        ReusableAction_Loggers.clickAction(driver,"//*[@class='left']",logger,"Home Page");
        //verify title name
        String title = driver.getTitle();
        //verify using if else statement
        if (title.equals("Home|Affordable Car Insurance|")){
            System.out.println("Title is correct");
            logger.log(LogStatus.INFO,"Title is correct ");
        }else{
            System.out.println("Title is incorrect and correct title is " + title);
            logger.log(LogStatus.INFO,"Title is incorrect and correct title is " + title);
        }//end of if else condition

    }//end of capturing agents info and website title

}//end of class
