package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C2_Dropdown01 {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Before method calisti");
        driver.get("https://the-internet.herokuapp.com/dropdown");

    }

    @AfterMethod
    public void tearDown() {
        //driver.close();
    }

    @Test (priority = 0)
    public void DropdownIndex() {

        WebElement dropdownMenu = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropdownList = new Select(dropdownMenu);

        dropdownList.selectByIndex(1);
        System.out.println(dropdownList.getFirstSelectedOption().getText());

    }

    @Test (priority = 1)
    public void DropdownValue() throws InterruptedException {

        WebElement dropdownMenu = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropdownList = new Select(dropdownMenu);
        Thread.sleep(5000);
        dropdownList.selectByValue("2");
        System.out.println(dropdownList.getFirstSelectedOption().getText());

    }

    @Test (priority = 2)
    public void DropdownVisibleText() throws InterruptedException {

        WebElement dropdownMenu = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropdownList = new Select(dropdownMenu);
        Thread.sleep(5000);
        dropdownList.selectByVisibleText("Option 1");
        System.out.println(dropdownList.getFirstSelectedOption().getText());

    }

    @Test (priority = 3)
    public void Dropdown() throws InterruptedException {

        WebElement dropdownMenu = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Thread.sleep(5000);
        System.out.println(dropdownMenu.getText());
    }

    @Test (priority = 10)
    public void DropdownSize(){
        WebElement dropdownMenu = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropdownList = new Select(dropdownMenu);
        List<WebElement> size= dropdownList.getOptions();
        for (WebElement each:size) {
            each.getText();
        }
        System.out.println(size.size());
    }
    @Test (priority = 15)
    public void DropdownEquals(){
        WebElement dropdownMenu = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropdownList = new Select(dropdownMenu);
        List<WebElement> isItEquals = dropdownList.getOptions();
        int expected = 5;
        int actual = isItEquals.size();
        Assert.assertEquals(actual,expected);
    }
}
