package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Linkedln {

    WebDriver driver;
    String message = "hey";
    public Linkedln()
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
    public void linkedinPost() throws InterruptedException {
        driver.get("https://www.linkedin.com/feed/");
        driver.findElement(By.xpath("//p/a[text()='Sign in']")).click();
        driver.findElement(By.id("username")).sendKeys("jayatheertha11@gmail.com");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        driver.findElement(By.xpath("//span[text()='Start a post']/..")).click();
        Thread.sleep(2000);

        if(driver.findElement(By.xpath("//div[text()='Post to Connections only']")).isDisplayed()) {
            driver.findElement(By.xpath("//div[@data-placeholder='What do you want to talk about?']")).sendKeys(message);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='Post']/..")).click();
        }
        else {
            driver.findElement(By.xpath("//div[text()='Post to Connections only']/../../..")).click();
            driver.findElement(By.xpath("(//strong[text()='Connections only'])[1]")).click();
            driver.findElement(By.xpath("//span[text()='Done']/..")).click();
            driver.findElement(By.xpath("//div[@data-placeholder='What do you want to talk about?']")).sendKeys(message);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='Post']/..")).click();
        }
        Thread.sleep(2000);
        String text = driver.findElement(By.xpath("(//div[@dir='ltr'])[1]/span/span")).getText();

        if(text.equals(message)) {
            System.out.println("message is posted");
        }
        else {
            System.out.println("message is not posted");
        }

    }
}
