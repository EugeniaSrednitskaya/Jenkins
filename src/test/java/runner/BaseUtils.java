package runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;


public final class BaseUtils {

    private static final String CHROME_OPTIONS = "CHROME_OPTIONS";
    private static final String CHROME_OPTIONS_PROP = "default." + CHROME_OPTIONS.toLowerCase();
    static final String PREFIX_PROP = "default.";
    private static final String PROP_PORT = PREFIX_PROP + "port";
    protected static FileInputStream fileInputStream;
    private static Properties properties;

//    static Properties getProperties() {
//        return properties;
//    }

    private static void initProperties() {
        try {
            //указание пути до файла с настройками
            fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            //обработка возможного исключения (нет файла и т.п.)
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * метод для возврата строки со значением из файла с настройками
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

//    private static void initProperties() {
//        if (properties == null) {
//            properties = new Properties();
//            if (isServerRun()) {
//                properties.setProperty(CHROME_OPTIONS_PROP, System.getenv(CHROME_OPTIONS));
//            } else {
//                try {
//                    InputStream inputStream = BaseUtils.class.getClassLoader().getResourceAsStream("config.properties");
//                    if (inputStream == null) {
//                        System.out.println("ERROR: The \u001B[config.properties\u001B[0m file not found in src/test/resources/ directory.");
//                        System.out.println("You need to create it from config.properties.TEMPLATE file.");
//                        System.exit(1);
//                    }
//                    properties.load(inputStream);
//                } catch (IOException ignore) {}
//            }
//        }
//    }


    private static final ChromeOptions chromeOptions;

    static {
        initProperties();

        chromeOptions = new ChromeOptions();
        String options = properties.getProperty(CHROME_OPTIONS_PROP);
        if (options != null) {
            for (String argument : options.split(";")) {
                chromeOptions.addArguments(argument);
            }
        }

        WebDriverManager.chromedriver().setup();
    }

    static boolean isServerRun() {
        return System.getenv("CI_RUN") != null;
    }

    static WebDriver createDriver() {
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

//    static void get(WebDriver driver) {
//        driver.get(String.format("http://localhost:%s", getProperties().getProperty(PROP_PORT)));
//        //driver.get("http://localhost:8080");
//    }
}