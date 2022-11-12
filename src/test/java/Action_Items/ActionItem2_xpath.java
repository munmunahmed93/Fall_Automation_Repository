package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class ActionItem2_xpath {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> sports = new ArrayList<>();
        sports.add("Badminton");
        sports.add("Kickball");
        sports.add("Hockey");
        sports.add("Swimming");

        WebDriverManager.chromedriver().setup();

        WebDriver Driver = new ChromeDriver();

        for (int i = 0; i< sports.size(); i++){
            //getting to the website Bing
            Driver.navigate().to("https://www.bing.com/");
            Driver.manage().window().maximize();
            Thread.sleep(2000);
            Driver.findElement(By.xpath("//*[@name='q']")).sendKeys(sports.get(i));
            Driver.findElement(By.xpath("//*[@id='search_icon']")).submit();

            //getting search result for arraylist
            Thread.sleep(2000);
            String result = Driver.findElement(By.xpath("//*[@class= 'sb_count']")).getText();
            String[] splitResult = result.split(" ");
            System.out.println("The search number for " +sports.get(i) + " is " + splitResult[0]);



        }//end of for loop
        Driver.quit();
    }//end of main
}//end of java class
