package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[@id='reggie-link-register-now']")
    WebElement joinButton;

    public MainPage(WebDriver driver, WebDriverWait wait, Properties properties) {
        super(driver, wait, properties);
    }

    public void clickOnJoinButton () {
        joinButton.click();
    }
}
