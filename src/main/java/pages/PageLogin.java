package pages;

import elements.LocatorsPageLogin;
import org.openqa.selenium.WebDriver;

public class PageLogin extends PageBase{

    private LocatorsPageLogin element = new LocatorsPageLogin(getDriver());

    public PageLogin(WebDriver existingDriver) {
        super(existingDriver);
    }

    public PageLogin sendUser(String user) {
        element.getXpathLogin().sendKeys(user);
        return this;
    }

    public PageLogin sendPassword(String password) {
        element.getXpathPassword().sendKeys(password);
        return this;
    }

    public void clickSignIn() {
        element.getSubmitButton().click();
    }

}
