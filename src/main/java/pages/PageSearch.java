package pages;

import elements.LocatorsPageSearch;
import org.openqa.selenium.WebDriver;

public class PageSearch extends PageBase{

    private LocatorsPageSearch element = new LocatorsPageSearch(getDriver());

    public PageSearch(WebDriver existingDriver) {
        super(existingDriver);
    }

    public String getTextSearch() {
        return element.getTextSearchPanel().getText();
    }
}
