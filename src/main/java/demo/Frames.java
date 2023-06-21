package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Frames {

    WebDriver driver;

    public Frames()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void frames(){

        driver.get("https://the-internet.herokuapp.com/nested_frames");
        WebElement textEle;
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        textEle = driver.findElement(By.xpath("//body"));
        System.out.println(textEle.getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        textEle = driver.findElement(By.xpath("//body"));
        System.out.println(textEle.getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        textEle = driver.findElement(By.xpath("//body"));
        System.out.println(textEle.getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        textEle = driver.findElement(By.xpath("//body"));
        System.out.println(textEle.getText());
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

}
