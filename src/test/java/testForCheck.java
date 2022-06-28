import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class testForCheck {

    private static WebDriver driver;

    @Test
    public void testCucu() {

        //System.setProperty(chromeDriver, driverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        String options = "--disable-gpu;--no-sandbox;--disable-dev-shm-usage;--headless;--window-size=1920,1080";

        if (options != null) {
            for (String argument : options.split(";")) {
                chromeOptions.addArguments(argument);
            }
        }

        WebDriverManager.chromedriver().setup();
        driver  = new ChromeDriver(chromeOptions);

        driver.get("http://localhost:8080");
        //driver.get("http://192.168.99.100:8080/");

        driver.findElement(By.name("j_username")).sendKeys("EugeniaSrednitskaya");
        driver.findElement(By.name("j_password")).sendKeys("ffeea7a4cd5941178f942304df1f8a1f");
        driver.findElement(By.name("Submit")).click();

        //Assert.assertTrue(driver.findElement(By.id("jenkins-name-icon")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("security-token")).isDisplayed());
        //Assert.assertFalse(driver.findElement(By.id("security-token")).isDisplayed());

    }

    @AfterTest
    public void exit() {
        driver.quit();
    }
}
