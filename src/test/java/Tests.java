import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests

{
    private WebDriver driver;
    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafal\\Desktop\\ChromeDriver\\Nowy folder\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://www.wikipedia.pl");
    }

    @Test
    public void wikiTest()
    {
        Assert.assertEquals(driver.getTitle(), "Wikipedia, wolna encyklopedia");
        driver.findElement(By.id("searchInput")).sendKeys("Częstochowa");
        driver.findElement(By.id("searchButton")).click();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
