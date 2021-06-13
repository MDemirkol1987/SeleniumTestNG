package tests.day14;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
public class C4_UploadFile extends TestBase {
    /*
        https://the-internet.herokuapp.com/upload adresine gidelim
        chooseFile butonuna basalim
        Yuklemek istediginiz dosyayi secelim.
        Upload butonuna basalim.
        “File Uploaded!” textinin goruntulendigini test edelim.
     */
    @Test
    public void uploadFile() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        // 1- dosya sec butonunu locate edin
        WebElement dosyaSecButonu=driver.findElement(By.id("file-upload"));
        // 2- Yuklemekistedigimiz dosyanin dosya yolunu kaydedin
        String dosyaYolu= System.getProperty("user.home")+"\\Desktop\\FLOWER.jpg";
        // 3- SendKeys ile dosyayi dosyasec butonuna yollayin
        dosyaSecButonu.sendKeys(dosyaYolu);
        Thread.sleep(5000);
        // Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedYazisiElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedYazisiElementi.isDisplayed());
    }
}