package Day7_102222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class T1_SelectStatement {
    public static void main(String[] args) throws InterruptedException {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        // add the options for maximizing the chrome meeting
        // options.addArguments("start-fullscreen") for mac
        options.addArguments("start-fullscreen");

        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);

        //navigate to mlcalc
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Show advanced options']")).click();
        Thread.sleep(2000);

        //use select command for march dropdown
        WebElement strtMonth = driver.findElement(By.xpath("//*[@name = 'sm']"));
        Select startMonthDropDown = new Select(strtMonth);
        //select by visible text
        startMonthDropDown.selectByVisibleText("Nov");

        //use select command for year dropdown
        WebElement startYear = driver.findElement(By.xpath("//*[@name='sy']"));
        Select startYearDropDown = new Select(startYear);
        //select visible text
        startYearDropDown.selectByVisibleText("2023");

        // finding it through xpath
//        driver.findElement(By.xpath("//*[@name='sy']"));
//        driver.findElement(By.xpath("//*[text()='2023']")).click();
//        Thread.sleep(2000);



        driver.quit();
    }//end of main
}//end of class
