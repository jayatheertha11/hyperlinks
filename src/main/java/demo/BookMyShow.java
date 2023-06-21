package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookMyShow {

    ChromeDriver driver;
    public BookMyShow()
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

    public void bookMyShow() {
        driver.get("https://in.bookmyshow.com/explore/home/chennai");

        List<WebElement> images = driver.findElements(By.xpath("(//div[@class='sc-lnhrs7-4 bmyqGC'])[1]//img"));

        for(int i=0; i<images.size(); i++) {
            WebElement image = images.get(i);
            String url = image.getAttribute("src");
            System.out.println(url);
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("((//div[@class='sc-lnhrs7-0 hCzkOF'])[3]//div[@class='sc-133848s-3 cWbeuJ'])[2]")));
        List<WebElement> ele = driver.findElements(By.xpath("((//div[@class='sc-lnhrs7-0 hCzkOF'])[3]//div[@class='sc-133848s-3 cWbeuJ'])[2]/div/div"));
        for(WebElement e: ele) {
            System.out.println(e.getText());
        }


    }
 }
