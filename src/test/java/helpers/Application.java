package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.RegistrationPage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Application {

    WebDriver driver;
    WebDriverWait wait;
    Properties properties;

    public RegistrationPage emailValidationTest;
    public MainPage mainPage;

    public Application() throws IOException {

        String browser = java.lang.System.getProperties().getProperty("browser");

        if (browser.equals("firefox")) {
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("intl.accept_languages", "en-US");
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(profile);
            driver = new FirefoxDriver(options);
        }
        // in case browser=chrome or other
        else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--lang=en-US");
            driver = new ChromeDriver(options);
        }

        wait = new WebDriverWait(driver, 5);

        properties = new Properties();
        FileReader file = new FileReader(new File(String.format("src/test/resources/%s.properties", System.getProperty("target", "local"))));
        properties.load(file);

        mainPage = new MainPage(driver, wait, properties);
        emailValidationTest = new RegistrationPage(driver, wait, properties);
    }

    public void quit() {
        driver.quit();
    }

    public void takeScreenshot(String fileName) {
        ScreenSaver.takeScreenshot(driver, fileName);
    }
}
