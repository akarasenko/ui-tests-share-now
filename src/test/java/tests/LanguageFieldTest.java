package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LanguageFieldTest extends BaseTest {

    @Parameters("defaultLanguage")
    @Test
    public void DefaultLanguage(String defaultLanguage) {
        app.mainPage.open();
        app.mainPage.clickOnJoinButton();

        Assert.assertEquals(app.registrationPage.getLanguageOption(), defaultLanguage);
    }
}
