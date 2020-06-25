import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchAndAddCartTest {

    @Before
    public void setEnvironment(){

    }
    @Test
    public void doTestCase() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //BaseUrl değişkenine url bilgisi atanır.
        String baseUrl = "https://www.trendyol.com";
        //Web sitesini browser da açar
        driver.get(baseUrl);

        //Açık Bekleme Tipi olan WebdriverWait Tanımlanır.
        //Bu, bir TimeoutException özel durumu oluşturmadan önce 15 saniye kadar bekler veya öğenin bulduğu takdirde 0 - 15 saniye içinde döndürür
        //WebDriverWait wait = new WebDriverWait(driver,TimeOut);
        WebDriverWait wait = new WebDriverWait(driver, 15);

        //browser'ı maksimum boyuta getirir
       driver.manage().window().maximize();

        //İlk açılan popupı kapatır
      // WebElement closePopUp = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[8]/div/div/a"))));
       //closePopUp.click();



        try {
            //Arama Kutucuğuna tıklar ve sorguyu yazar
            WebElement searchBar = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div/div[2]/div/div/div/input"));
            searchBar.sendKeys("Bilgisayar");
            //Arama buttonuna tıkla
            WebElement searchClick = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div/div[2]/div/div/div/i"))));
            searchClick.click();
            searchClick.click();

            TimeUnit.SECONDS.sleep(3);
            //Aramada çıkan ürüne git
            WebElement productClick = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div[2]/div/div[1]/div[1]/a"))));
            productClick.click();


            //Sepete Ekle
            WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div[2]/div[5]/button[1]"))));
            addToCart.click();

            //Sepete git
            WebElement goToCart = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[3]/div/div/ul/li[3]/div[4]/div/div[2]/a[1]"))));
            goToCart.click();

            //Ürün sayısını değiştir
            WebElement changeQuantity = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/section/section[1]/div[3]/div/div/ul/li/div[2]/div[2]/div/select/option[2]"))));
            changeQuantity.click();
        }catch (Exception ex){

            System.out.println("Failed");
        }






        //İlk ürüne tıkla
        //WebElement productClick =  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("p-card-img"))));
        //productClick.click();

    }
}
