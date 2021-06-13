package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C1_DependsOnTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void tes01HomePage() {
        driver.get("http://walmart.com");
        String expectedUrl = "https://www.walmart.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test //(dependsOnMethods = "test01HomePage")
    public void tes02Search() {
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='global-search-input']"));
        String searchWord = "Nutella";
        searchBox.sendKeys(searchWord + Keys.ENTER);

        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(searchWord));

    }

    @Test
    public void test03Result() {
        driver.findElement(By.xpath("(//img[@data-pnodetype='item-pimg'])[1]")).click();
        WebElement fiyatWebElementi = driver.findElement(By.xpath("(//span[@class='price-group'])[1]"));
        String actualFiyat = fiyatWebElementi.getText();
        String expectedFiyat = "$7.97";
        Assert.assertEquals(actualFiyat, expectedFiyat);
    }
}
