package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class SearchAmazon {

    ChromeDriver driver;
    public SearchAmazon()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
    public void searchAmazon() {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("amazon");
        driver.findElement(By.xpath("//div[@class='wM6W7d']/span[text()='Amazon']")).click();
       // driver.findElement(By.xpath("(//input[@value='Google Search'])[2]")).click();
        boolean flag = driver.findElement(By.xpath("//h3[text()='Amazon.in' or contains(text(),'Amazon.com.')]")).isDisplayed();
        if(flag) {
            System.out.println("link is present");
        }
        else {
            System.out.println("links are not present");
        }
    }

}
