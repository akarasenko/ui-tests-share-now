package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EmailValidationTest extends BaseTest {
    @Parameters({"email","expectedHint"})
    @Test
    public void EmailValidationTest(String email, String expectedHint) {
        app.mainPage.open();
        app.mainPage.clickOnJoinButton();

        app.emailValidationTest.fillEmailField(email);
        app.emailValidationTest.submitForm();

        Assert.assertEquals(app.emailValidationTest.getErrorHintEmail(), expectedHint);
    }
}

