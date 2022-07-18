package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocatorsPageSearch {

    private WebDriver driver;

    public LocatorsPageSearch(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id = 'main-panel']/h1")
    WebElement textSearchPanel;

    public WebElement getTextSearchPanel() {
        return textSearchPanel;
    }
}
