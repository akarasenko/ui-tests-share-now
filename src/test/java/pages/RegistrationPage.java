package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class RegistrationPage extends BasePage{

    @FindBy(xpath = "//*[@name='language']")
    WebElement languageSelect;

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@name='email']/../p[@class='error_hint']")
    WebElement emailErrorHint;

    @FindBy(xpath = "//*[@id='registration-save-button']")
    WebElement submitButton;

    public RegistrationPage(WebDriver driver, WebDriverWait wait, Properties properties) {
        super(driver, wait, properties);
    }

    public void fillEmailField (String text) {
        emailField.sendKeys(text);
    }

    public String getLanguageOption () {
        return languageSelect.getAttribute("value");
    }

    public String getErrorHintEmail () {
        wait.until(ExpectedConditions.visibilityOf(emailErrorHint));
        return emailErrorHint.getText();
    }

    public void submitForm() {
        submitButton.click();
    }
}
