package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    private WebDriver driver;

    public PageBase(WebDriver existingDriver) {
        PageFactory.initElements(existingDriver, this);
        this.driver = existingDriver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
