package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HyperLinks {

    ChromeDriver driver;
    public HyperLinks()
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


    public  void hyperLinksCount(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        List<WebElement> size = driver.findElements(By.xpath("//a"));
        System.out.println(size.size());
    }

}
