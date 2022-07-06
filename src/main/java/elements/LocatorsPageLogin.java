package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocatorsPageLogin {

    private WebDriver driver;

    public LocatorsPageLogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "j_username")
    private WebElement xpathLogin;

    @FindBy(name = "j_password")
    private WebElement xpathPassword;

    @FindBy(name = "Submit")
    private WebElement submitButton;

    public WebElement getXpathLogin() { return xpathLogin; }

    public WebElement getXpathPassword() {
        return xpathPassword;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

}
