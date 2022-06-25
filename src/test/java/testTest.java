import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class testTest {

    private static WebDriver driver;

    @Test
    public void testTests() {
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

        driver.findElement(By.name("j_username")).sendKeys("EugeniaSrednitskaya");
        driver.findElement(By.name("j_password")).sendKeys("ffeea7a4cd5941178f942304df1f8a1f");
        driver.findElement(By.name("Submit")).click();
    }

    @AfterTest
    public void exit() {
        driver.quit();
    }
}
