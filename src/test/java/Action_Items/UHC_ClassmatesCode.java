//package Action_Items;
//
//public class UHC_ClassmatesCode {
//import ReuseableLibabry.ReusableActions;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;

//    public class AI_UHC_Com {
//
//
//        WebDriver driver;
//
//        @BeforeSuite
//
//        public void SetChromeDriver() {
//            driver = ReusableActions.setUpChrome();
//
//        }//end of set driver method
//
//
//        @Test()
//
//        public void Dentist () throws InterruptedException {
//
//            //navigating to uhc homepage
//            driver.navigate().to("https://www.uhc.com/");
//            //wait few seconds
//            Thread.sleep(2000);
//            //clicking on find a doctor
//            ReusableActions.clickAction(driver, "//*[@aria-label='Find a doctor']", "find doctor");
//            //wait few seconds
//            Thread.sleep(3000);
//            //clicking to the side for the popUp to vanish
//            //handle pop up window
//            try {
//                WebElement weValueYourFeedback = driver.findElement(By.xpath("//*[@id='layer-container-127097']"));
//                if (weValueYourFeedback.isDisplayed()) {
//                    driver.findElement(By.xpath("//*[@id='ip-no']")).click();
//                }//end of if condition
//            }catch (Exception e){
//                System.out.println("Unable to find pop up window " + e);
//            }//end of pop up window exception
//
//            //scroll down to Find a dentist
//            ReusableActions.scrollByView(driver, "//*[text()='Find a dentist']", "scroll to Dentist");
//            //wait few seconds
//            Thread.sleep(7000);
//            //click on find a dentist
//            ReusableActions.clickAction(driver, "//*[text()='Find a dentist']", "click on find a dentist");
//            // switching to new tab
//            ReusableActions.switchToTabByIndex(driver, 1, "switch to new tab");
//
//            //clicking on employer and individual plan
//            ReusableActions.clickActionByIndex(driver, "//*[@class='img']", 0, "click on employer");
//        }//end of Test 1 Dentist
//
//
//
//        @Test(dependsOnMethods = "Dentist")
//        public void zipSearch () throws InterruptedException {
//            //wait few seconds
//            Thread.sleep(1000);
//            //sending zipCode values to search box
//            ReusableActions.sendKeysAction(driver, "//*[@id='location']", "11207", "sending zipcodes");
//            //wait few seconds
//            Thread.sleep(1000);
//            //selecting from the dropDown
//            ReusableActions.clickActionByIndex(driver,"//*[@id='auto_0']",0,"dropDown");
//            //wait few seconds
//            Thread.sleep(1000);
//            //clicking on continue
//            ReusableActions.clickAction(driver, "//*[@type='submit']", "click enter button");
//
//            //clicking on National Options
//            ReusableActions.clickActionByIndex(driver,"//*[@class='sc-jomqko TEkcT']",0,"NationalOptions");
//            //wait few seconds
//            Thread.sleep(3000);
//            //refresh the page
//            driver.navigate().refresh();
//            //wait few seconds
//            Thread.sleep(3000);
//            ReusableActions.clickActionByIndex(driver,"//*[@class='sc-jgPyTC gXqeMb']",0,"Click on general dentist");
//
////wait few seconds
//            Thread.sleep(3000);
//        }//test 2
//        @Test(dependsOnMethods = "zipSearch")
//        public void doctorInfo () throws InterruptedException {
////wait few seconds
//            //Thread.sleep(3000);
//            ReusableActions.selectByTextAction(driver,"//*[contains(@class,'radiusMiles ng-pristine')]","'Within 20 Miles","miles dropdown");
//            //refresh the page
//            driver.navigate().refresh();
//            //wait few seconds
//            Thread.sleep(3000);
//            //click on miles dropDown
//
//            //clicking on the doctor name
//            ReusableActions.clickActionByIndex(driver,"//*[@data-test-id='provider-name-link']",0,"doctor name");
//            //wait few second
//            Thread.sleep(3000);
//            //click on save button
//            ReusableActions.clickAction(driver,"//*[contains(@class,'cta-header-button action-btn saved')]","save icon");
//            //capturing address, miles and distance
//            //capturing address
//            String Address = ReusableActions.getTextAction(driver,"//*[@class='btn-label-wrapper']","address");
//            //capturing miles
//            String Miles =  ReusableActions.getTextAction(driver,"//*[@class='block mapLink']","miles");
//            //wait few second
//            Thread.sleep(2000);
//            //capturing network
//            String Network = ReusableActions.getTextAction(driver,"//*[@value='::location.inNetwork']","network");
//            //wait few second
//            Thread.sleep(2000);
//            //printing out address,miles and distance
//            System.out.println("Address Value = " + Address + " Miles value = " +  Miles + "Network Value = " + Network);
//            // closing the second tab
//            driver.close();
//        }//end of text 3
//        @Test(dependsOnMethods = "doctorInfo")
//        public void result() throws InterruptedException {
//// switching back to default tab
//            ReusableActions.switchToTabByIndex(driver,0,"default tab");
//            //wait few second
//            Thread.sleep(2000);
//            //searing "doctor" on search box
//            ReusableActions.sendKeysAction(driver,"//*[@id='search-desktop']", "doctor","search doctor");
//            //clicking on search icon
//            //wait few second
//            Thread.sleep(2000);
//            //click on search icon
//            ReusableActions.submitAction(driver,"//*[@id ='search__button-desktop']","search icon");
//            // capturing  split search numbers
//
//            String searchNumber =  ReusableActions.getTextAction(driver,"//*[@id='search-results-count__header']","searchSplit");
//            String [] split =searchNumber.split(" ");
//            System.out.println("my search result value: " + split[0] + split[1] + split[2]);
//        }//end of test 4
//        @AfterSuite
//        public void quitTheSession(){
//            driver.quit();
//        }//end of after suite
//
//    }//end of class
//
//}
