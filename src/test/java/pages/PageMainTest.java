package pages;

import elements.ConfigurationProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
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

        Assert.assertTrue(pageMain().getSearchResult(textSearch).getTextSearch().contains(textSearch));
    }

    @Test
    public void testCheckSlidePanel() {
        List<String> expectedListMenuElements = List.of(
                "New Item",
                "People",
                "Build History",
                "Manage Jenkins",
                "My Views",
                "New View");

        Assert.assertEquals(pageMain().getSlidePanel(), expectedListMenuElements);
    }
}