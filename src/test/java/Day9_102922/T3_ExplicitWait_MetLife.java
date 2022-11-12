package Day9_102922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class T3_ExplicitWait_MetLife {
    public static void main(String[] args) throws InterruptedException {


        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        //add options for maximizing the chrome window
        options.addArguments("start-maximized", "incognito");

        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);

        //declare your implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //go to mortgage calc site
        driver.navigate().to("https://www.metlife.com");

        //Declare the explicit wait
        WebDriverWait wait = new WebDriverWait(driver,20);

        //click on solution tab using  explicit wait
        //presence of all element = findElements
        //explicit wait is more professional
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(text(),'SOLUTIONS')]"))).get(0).click();

        //click on dental
        //presenceOfElementLocated = findElement
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Dental']"))).click();

        //can also do

    }
}
