package pages;

import elements.LocatorsPageMain;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class PageMain extends PageBase {

    private LocatorsPageMain element = new LocatorsPageMain(getDriver());

    public PageMain(WebDriver existingDriver) {
        super(existingDriver);
    }

    public Boolean headerPageMainDisplayed() {
        return element.getHeaderPageMain().isDisplayed();
    }

    public String userNameCheck() {
        return element.getUserName().getAttribute("href");
    }

    public PageSearch getSearchResult(String searchText) {
        element.getSearch().clear();
        element.getSearch().sendKeys(searchText, Keys.ENTER);

        return new PageSearch(getDriver());
    }

    public List<String> getSlidePanel() {
        return List.of(element.getNewItem().getText(),
                element.getPeople().getText(),
                element.getBuildHistory().getText(),
                element.getManageJenkins().getText(),
                element.getMyViews().getText(),
                element.getNewView().getText());
    }

    public void clickLogOut() {
        element.getLogOut().click();
    }

    public PageMain clickPageRefresh() {
        getDriver().navigate().refresh();
        return this;
    }
}
