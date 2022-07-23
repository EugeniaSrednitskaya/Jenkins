import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BeforeAfterTest;
import pages.PageMain;

public class MainPageTest extends BeforeAfterTest {

    @Test
    public void HeaderElementsIsPresentTest(){

        PageMain mainPage= new PageMain(getDriver());
        SoftAssert asserts = new SoftAssert();

        asserts.assertTrue(mainPage.headerPageMainDisplayed());
        asserts.assertTrue(mainPage.iconMainPageIsDisplayed());

        asserts.assertAll();







    }

}
