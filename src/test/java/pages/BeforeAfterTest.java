package pages;

import elements.ConfigurationProperties;
import elements.ProjectHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BeforeAfterTest {

    private WebDriver driver;

    protected WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    protected void beforeMethod() {
        driver = new ConfigurationProperties().createDriver();
        //Assert.assertTrue(getDriver().findElement(By.xpath("//div/h1")).isDisplayed());
        ProjectHelpers.login(driver);
    }

    @AfterMethod
    protected void afterMethod() {
       ProjectHelpers.logout(driver);
       driver.quit();
    }
}
