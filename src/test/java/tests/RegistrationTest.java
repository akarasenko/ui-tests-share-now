package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    @Parameters({"email","expectedMessage"})
    @Test
    public void FirstTest(String email, String expectedMessage) {
        app.mainPage.open();
    }
}

