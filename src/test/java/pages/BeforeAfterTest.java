package pages;

import elements.ConfigurationProperties;
import elements.ProjectHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BeforeAfterTest {

    private WebDriver driver;

    protected WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    protected void beforeMethod() {
        driver = new ConfigurationProperties().createDriver();
        ProjectHelpers.login(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    protected void afterMethod() {
       ProjectHelpers.logout(driver);
       driver.quit();
    }
}
