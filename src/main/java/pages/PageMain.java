package pages;

import elements.LocatorsPageMain;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PageMain extends PageBase{

    private LocatorsPageMain element = new LocatorsPageMain(getDriver());

    public PageMain(WebDriver existingDriver) {
        super(existingDriver);
    }

    public void clickSearch(String searchText) {
        element.getSearch().sendKeys(searchText, Keys.ENTER);
    }
}
