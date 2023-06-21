package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Imdb {

    WebDriver driver;

    public Imdb()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void imdb() {
        driver.get("https://www.imdb.com/chart/top");
        //*************** highest rated movie on Imdb ****************

        WebElement movie = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/a"));
        System.out.println("highest rated movie on Imdb " + movie.getText());
        //*************** all movies present ********************
        List<WebElement> moviesNamesList = driver.findElements(By.xpath("//tbody/tr/td[2]/a"));
        System.out.println("all movies present in the list are " + moviesNamesList.size());
        //****************** oldest movie & newest movie **********************
        List<WebElement> movieYearsList = driver.findElements(By.xpath("//tbody/tr/td[2]/span"));
       // List<WebElement> moviesNamesList = driver.findElements(By.xpath("//tbody/tr/td[2]/a"));
        WebElement movieName = driver.findElement(By.xpath("(//tbody/tr/td[2])[1]/a"));
        int year =2024;
        int i=0;
        while(i<movieYearsList.size()) {
            WebElement text = movieYearsList.get(i);
            String yearNum = text.getText();
            String s = "";
            for(int j=0; j<yearNum.length(); j++) {
                if(yearNum.charAt(j)=='(' || yearNum.charAt(j)==')') {
                }
                else {
                    s=s+String.valueOf(yearNum.charAt(j));
                }
            }
            int yearNumber = Integer.parseInt(s);
            if(yearNumber<year) {
                year = yearNumber;
                movieName = moviesNamesList.get(i);
            }
            i++;
        }
        System.out.println(movieName.getText() + " " + year);

        //For newest movie make year as 0(zero) and in If condition yearNumber>year make these changes

        //**************** highest user ratings *********************
        WebElement highestRatedMovie = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/a"));
        System.out.println("highest rated movie on Imdb " + highestRatedMovie.getText());

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
}
