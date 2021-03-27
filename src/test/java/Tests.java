import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Tests

{
    private WebDriver driver;
    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafal\\Desktop\\ChromeDriver\\ChromeDriver89\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://www.wikipedia.pl");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); // 1 typ waita
    }

    @Test
    public void wikiTest()
    {
        WebDriverWait wait = new WebDriverWait(driver, 5);    // 2 typ waita
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("searchButton"))));
        Assert.assertEquals(driver.getTitle(), "Wikipedia, wolna encyklopedia");
        driver.findElement(By.cssSelector("#searchInput")).sendKeys("Częstochowa");
        driver.findElement(By.id("searchButton")).click();
        Assert.assertEquals(true, verifyElementPresent(driver, By.id("Nazwa")));
        Assert.assertEquals(false, verifyElementPresent(driver, By.id("qqqq")));
        verifyElementPresent(driver, By.id("Historia"));
        verifyElementPresent(driver, By.id("qqqqqqqq"));
        driver.findElement(By.linkText("Historia Częstochowy")).click();
        Assert.assertEquals(driver.getTitle(), "Historia Częstochowy – Wikipedia, wolna encyklopedia");

        try{                                 // 3 typ waita
            Thread.sleep(4000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"toc\"]/ul/li[3]/a/span[2]"));
    }

    public static boolean verifyElementPresent(WebDriver driver, By by)
    {
        try{
            driver.findElement(by);
            System.out.println("Element found");
            return true;
        }
        catch (NoSuchElementException e){
            System.out.println("Element not found");
            return false;
        }
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
