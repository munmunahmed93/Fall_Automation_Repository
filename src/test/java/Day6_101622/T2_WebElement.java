package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_WebElement {
    public static void main(String[] args) throws InterruptedException {

        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        //add the options for maximizing the chrome meeting
        //options.addArguments("start-fullscreen")
        options.addArguments("start-fullscreen");

        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);

        //navigate to the google site
        driver.navigate().to("https://www.mlcalc.com");

        //sleep statement
        Thread.sleep(3000);

        //clear and enter a new value on purchase price field
        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));

        //clear purchase price
        pPrice.clear();

        //type new value on the purchase price
        pPrice.sendKeys("4500000");

        //clear and enter a new value on down payment field
        WebElement dPayment = driver.findElement(By.xpath("//*[@id='dp']"));

        //clear the down payment
        dPayment.clear();

        //type new value on the down payment
        dPayment.sendKeys("25");

        Thread.sleep(3000);

        driver.quit();

    }
}
