import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class testTest {
    private static String chromeDriver = "webdriver.chrome.driver";
    private static String driverPath = "C://Users/genni/Downloads/chromedriver_win32_101/chromedriver.exe";
    private static WebDriver driver;
    @Test
    public void testTets() {
        System.setProperty(chromeDriver, driverPath);
        driver  = new ChromeDriver();
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
