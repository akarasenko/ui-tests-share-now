package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.EmailValidationTest;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class Application {

    public WebDriver driver;
    WebDriverWait wait;
    Properties properties;

    public EmailValidationTest emailValidationTest;
    public MainPage mainPage;

    public Application() throws IOException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-US");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);

        properties = new Properties();
        FileReader file = new FileReader(new File(String.format("src/test/resources/%s.properties", System.getProperty("target", "local"))));
        properties.load(file);

        mainPage = new MainPage(driver, wait, properties);
        emailValidationTest = new EmailValidationTest(driver, wait, properties);
    }


    public void quit() {
        driver.quit();
    }

    public void takeScreenshot(String fileName) {
        ScreenSaver.takeScreenshot(driver, fileName);
    }
}
