package pages;

import elements.ConfigurationProperties;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static elements.ProjectHelpers.PROPERTIES_ADMIN_USERNAME;

public class PageMainTest extends BeforeAfterTest{

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
}