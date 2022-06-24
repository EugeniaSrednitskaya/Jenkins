package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import static runner.BaseUtils.getProperties;

public abstract class BaseTest {

    private WebDriver driver;
    static final String PREFIX_PROP = "default.";
    private static final String PROP_ADMIN_USERNAME = PREFIX_PROP + "admin.username";
    //private static final String PROP_ADMIN_USERNAME = "default.admin.username";
    private static final String PROP_ADMIN_PAS = PREFIX_PROP + "admin.password";

    @BeforeMethod
    protected void beforeMethod() {

        driver = BaseUtils.createDriver();
        BaseUtils.get(driver);

        WebElement name = driver.findElement(By.name("j_username"));
        name.sendKeys(getProperties().getProperty(PROP_ADMIN_USERNAME));
        //name.sendKeys("EugeniaSrednitskaya");

        WebElement password = driver.findElement(By.name("j_password"));
        password.sendKeys(getProperties().getProperty(PROP_ADMIN_PAS));
        //password.sendKeys("ffeea7a4cd5941178f942304df1f8a1f");

        WebElement SignIn = driver.findElement(By.name("Submit"));
        SignIn.click();

    }

    @AfterMethod
    protected void afterMethod() {
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
