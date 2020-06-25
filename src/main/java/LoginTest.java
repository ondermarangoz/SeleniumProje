import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    @Test
    public void doTestCase() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //BaseUrl değişkenine url bilgisi atanır.
        String baseUrl = "https://www.trendyol.com";
        //Web sitesini browser da açar
        driver.get(baseUrl);

        //Açık Bekleme Tipi olan WebdriverWait Tanımlanır.
        //Bu, bir TimeoutException özel durumu oluşturmadan önce 15 saniye kadar bekler veya öğenin bulduğu takdirde 0 - 15 saniye içinde döndürür
        //WebDriverWait wait = new WebDriverWait(driver,TimeOut);
        WebDriverWait wait = new WebDriverWait(driver,10);

        //browser'ı maksimum boyuta getirir
        driver.manage().window().maximize();

        //İlk çıkan boxu kapatır
       /* WebElement closeBox = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[11]/div/div/a"))));
        closeBox.click();*/


        //Giriş yap navbarda görünene kadar bekler ve tıklar
        WebElement navBarLogin = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div/div[3]/div/div/ul/li[1]/div[2]/span[1]/div/div[1]"))));
        navBarLogin.click();


        //Username textbox'ı için veri gönderir
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[11]/div/div/div/div/div/div/div[1]/div/div[1]/div/div/form/section[1]/div/input")));
        //driver.findElement(By.xpath("/html/body/div[11]/div/div/div/div/div/div/div[1]/div/div[1]/div/div/form/section[1]/div/input"));
        username.sendKeys("xxx@gmail.com");

        //Password textbox'ı için veri gönderir
        WebElement password = driver.findElement(By.xpath("/html/body/div[11]/div/div/div/div/div/div/div[1]/div/div[1]/div/div/form/section[2]/div/input"));
        password.sendKeys("xxxxxx");

        //Giriş Yap Butonuna Tıklar
        WebElement loginClick = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[11]/div/div/div/div/div/div/div[1]/div/div[1]/div/div/form/div[2]/a"))));
        loginClick.click();

        //Giriş yapmadan arama yapmaması için girişi bekle
        TimeUnit.SECONDS.sleep(3);


    }

}