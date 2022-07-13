package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocatorsPageMain {

    private WebDriver driver;

    public LocatorsPageMain(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "header")
    private WebElement headerPageMain;

    @FindBy(id = "jenkins-name-icon")
    private WebElement jenkinsIcon;

    @FindBy(linkText = "New Item")
    private WebElement newItem;

    @FindBy(linkText = "People")
    private WebElement people;

    @FindBy(linkText = "Build History")
    private WebElement buildHistory;

    @FindBy(linkText = "Manage Jenkins")
    private WebElement manageJenkins;

    @FindBy(linkText = "My Views")
    private WebElement myViews;

    @FindBy(linkText = "New View")
    private WebElement newView;

    @FindBy(id = "search-box")
    private WebElement search;

    @FindBy(xpath = "//a[contains(@href, 'user')]")
    private WebElement userName;

    @FindBy(xpath = "//a[@href = '/logout']")
    private WebElement logOut;

    public WebElement getHeaderPageMain() {
        return headerPageMain;
    }

    public WebElement getJenkinsIcon() {
        return jenkinsIcon;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getNewItem() {
        return newItem;
    }

    public WebElement getPeople() {
        return people;
    }

    public WebElement getBuildHistory() {
        return buildHistory;
    }

    public WebElement getManageJenkins() {
        return manageJenkins;
    }

    public WebElement getMyViews() {
        return myViews;
    }

    public WebElement getNewView() {
        return newView;
    }

    public WebElement getSearch() {
        return search;
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getLogOut() {
        return logOut;
    }
}
