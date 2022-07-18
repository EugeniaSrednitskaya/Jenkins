package elements;

import org.openqa.selenium.WebDriver;
import pages.PageLogin;
import pages.PageMain;

import static elements.ConfigurationProperties.PROPERTIES_PREFIX;
import static elements.ConfigurationProperties.getProperty;

public final class ProjectHelpers {

    private static final String PROPERTIES_PORT = PROPERTIES_PREFIX + "port";
    private static final String PROPERTIES_START_PAGE = PROPERTIES_PREFIX + "loginpage";

    public static final String PROPERTIES_ADMIN_USERNAME = PROPERTIES_PREFIX + "admin.username";
    private static final String PROPERTIES_ADMIN_PASSWORD = PROPERTIES_PREFIX + "admin.password";

    public static void getURL(WebDriver driver) {
        driver.get(String.format("http://localhost:%s", getProperty(PROPERTIES_PORT)));
    }

    public static void login(WebDriver driver) {
        getURL(driver);

        new PageLogin(driver).sendUser(getProperty(PROPERTIES_ADMIN_USERNAME))
                             .sendPassword(getProperty(PROPERTIES_ADMIN_PASSWORD))
                             .clickSignIn();
    }

    public static void logout(WebDriver driver) {
        new PageMain(driver).clickLogOut();
    }
}
