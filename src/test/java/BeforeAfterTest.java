import elements.ConfigurationProperties;
import elements.ProjectHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BeforeAfterTest {

    private WebDriver driver;

    @BeforeMethod
    protected void beforeMethod() {
        driver = new ConfigurationProperties().createDriver();
        ProjectHelpers.login(driver);

    }

    @AfterMethod
    protected void afterMethod() {
       ProjectHelpers.logout(driver);
       driver.quit();
    }

}
