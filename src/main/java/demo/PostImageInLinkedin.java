package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class PostImageInLinkedin {

    WebDriver driver;

    public PostImageInLinkedin()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        // driver.close();
        //  driver.quit();

    }

    public void postingAnImage() throws InterruptedException, AWTException {

        driver.get("https://www.linkedin.com/feed/");
        driver.findElement(By.xpath("//p/a[text()='Sign in']")).click();
        driver.findElement(By.id("username")).sendKeys("jayatheertha11@gmail.com");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        driver.findElement(By.xpath("//span[text()='Start a post']/..")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//*[local-name()='svg'])[6]/../..")).click();
        driver.findElement(By.xpath("//label[text()='Select images to share']"));//.sendKeys("C:\\Users\\hp\\Pictures\\Screenshots.jpg");
        Thread.sleep(3000);
        Robot robot = new Robot();
        StringSelection ss = new StringSelection("C:\\Users\\hp\\Pictures\\Screenshots\\IMG_0495.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Done']/..")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@data-placeholder='What do you want to talk about?']/p")).sendKeys("Automated with Robot class");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Post']/..")).click();
        Thread.sleep(5000);

    }


}
