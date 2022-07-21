package pages;

import elements.LocatorsPageMain;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PageMain extends PageBase{

    private LocatorsPageMain element = new LocatorsPageMain(getDriver());

    public PageMain(WebDriver existingDriver) {
        super(existingDriver);
    }

    public Boolean headerPageMainDisplayed() {
        return element.getHeaderPageMain().isDisplayed();
    }

    public Boolean iconMainPageIsDisplayed(){
        return element.getJenkinsIcon().isDisplayed();
    }



    public String userNameCheck() {

        return element.getUserName().getAttribute("href");
    }

    public void clickSearch(String searchText) {

        element.getSearch().sendKeys(searchText, Keys.ENTER);
    }

    public void clickLogOut() {

        element.getLogOut().click();
    }

    public PageMain clickPageRefresh() {
        getDriver().navigate().refresh();
        return this;
    }


}
