package pages;

import elements.ConfigurationProperties;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static elements.ConfigurationProperties.PROPERTIES_PREFIX;

public class PageMainTest extends BeforeAfterTest{

    private static final String PROPERTIES_ADMIN_USERNAME = PROPERTIES_PREFIX + "admin.username";

    private PageMain pageMain() {
        return new PageMain(getDriver());
    }

    @Test
    public void testHeaderDisplay() {
        Assert.assertTrue(pageMain().headerPageMainDisplayed());
    }

    @Test
    public void testUserNameCheck() {
        Assert.assertTrue(pageMain().userNameCheck().toLowerCase()
                .contains(ConfigurationProperties.getProperty(PROPERTIES_ADMIN_USERNAME).toLowerCase()));
    }
    
    @Test
    public void testClickSearch() {

        String textSearch = "Search item";
        pageMain().clickSearch(textSearch);
        Assert.assertTrue(getDriver()
                .findElement(By.xpath("//div[@id = 'main-panel']/h1")).getText().contains(textSearch));

    }

//    @Test
//    public void testClickLogOut() {
//
//        pageMain().clickLogOut();
//        Assert.assertTrue(getDriver()
//                .findElement(By.xpath("//div[@id = 'loginIntroDefault']/h1"))
//                .getText().equals("Welcome to Jenkins!"));
//    }
}