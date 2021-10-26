package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver, WebDriverWait wait, Properties properties) {
        super(driver, wait, properties);
    }
}
