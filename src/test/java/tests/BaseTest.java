package tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import helpers.Application;

import java.io.IOException;

public class BaseTest {
    public Application app;

    @BeforeMethod
    public void start() throws IOException {
        app = new Application();
    }

    @AfterMethod
    public void stop(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            app.takeScreenshot(result.getName());
        }
        app.quit();
    }
}
