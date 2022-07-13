package pages;

import elements.ConfigurationProperties;
import elements.ProjectHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BeforeAfterTest {

    private WebDriver driver;

    protected WebDriver getDriver() {
        return driver;
    }

    //@BeforeMethod
    @BeforeTest
    protected void beforeMethod() {
        driver = new ConfigurationProperties().createDriver();
        ProjectHelpers.login(driver);
    }

    @AfterTest
    //@AfterMethod
    protected void afterMethod() {
       ProjectHelpers.logout(driver);
       driver.quit();
    }

}
