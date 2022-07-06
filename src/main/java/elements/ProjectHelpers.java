package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.PageLogin;

import static elements.ConfigurationProperties.PROPERTIES_PREFIX;
import static java.lang.System.getProperties;

public final class ProjectHelpers {

    private static final String PROPERTIES_PORT = PROPERTIES_PREFIX + "port";
    private static final String PROPERTIES_START_PAGE = PROPERTIES_PREFIX + "loginpage";

    private static final String PROPERTIES_ADMIN_USERNAME = PROPERTIES_PREFIX + "admin.username";
    private static final String PROPERTIES_ADMIN_PASSWORD = PROPERTIES_PREFIX + "admin.password";

    public static void getURL(WebDriver driver) {
        //driver.get(String.format("http://localhost:%s", getProperties().getProperty(PROPERTIES_PORT)));
        driver.get(String.format(PROPERTIES_START_PAGE+"%s", getProperties().getProperty(PROPERTIES_PORT)));
    }

    public static void login(WebDriver driver) {
        getURL(driver);

        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.sendUser(PROPERTIES_ADMIN_USERNAME);
        pageLogin.sendPassword(PROPERTIES_ADMIN_PASSWORD);
        pageLogin.clickSignIn();
    }

    public static void logout(WebDriver driver) {
        driver.findElement(By.xpath("//a[@href='/logout']")).click();
    }
}
