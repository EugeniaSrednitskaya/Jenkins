package pages;

import elements.ConfigurationProperties;
import elements.LocatorsPageLogin;
import org.openqa.selenium.WebDriver;

public class PageLogin extends PageBase{

    private LocatorsPageLogin element = new LocatorsPageLogin(getDriver());

    public PageLogin(WebDriver existingDriver) {
        super(existingDriver);
    }

    public void sendUser(String user) {
        element.getXpathLogin().sendKeys(user);
    }

    public void sendPassword(String password) {
        element.getXpathPassword().sendKeys(password);
    }

    public void clickSignIn() {
        element.getSubmitButton().click();
    }

}
