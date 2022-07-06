package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConfigurationProperties {

    private static FileInputStream fileInputStream;
    private static Properties PROPERTIES;
    private static final ChromeOptions chromeOptions;

    private static final String ENV_BROWSER_OPTIONS = "CHROME_OPTIONS";
    private static final String ENV_APP_OPTIONS = "APP_OPTIONS";

    private static String PROPERTIES_PREFIX = "default.";
    private static final String PROP_CHROME_OPTIONS = PROPERTIES_PREFIX + ENV_BROWSER_OPTIONS.toLowerCase();

    static {
        if (System.getenv("CI_RUN") != null) {
            PROPERTIES.setProperty(PROP_CHROME_OPTIONS, System.getenv(ENV_BROWSER_OPTIONS));

            for (String option : System.getenv(ENV_APP_OPTIONS).split(";")) {
                String[] optionArr = option.split("=");
                PROPERTIES.setProperty(PROPERTIES_PREFIX + optionArr[0], optionArr[1]);

            }
        }
        else {
            try {
                fileInputStream = new FileInputStream("src/test/resources/config.properties");
                PROPERTIES = new Properties();
                PROPERTIES.load(fileInputStream);

            } catch (IOException e) {
                System.err.println("ERROR: file config.properties not found");
            } finally {
                if (fileInputStream != null)
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }

    static {
        chromeOptions = new ChromeOptions();

        String options = getProperty(PROP_CHROME_OPTIONS);
        if (options != null) {
            for (String argument : options.split(";")) {
                chromeOptions.addArguments(argument);
            }
        }

        WebDriverManager.chromedriver().setup();
    }

    public WebDriver createDriver() {
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}