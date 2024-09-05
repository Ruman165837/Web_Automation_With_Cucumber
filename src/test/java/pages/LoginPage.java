package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(css = "input[data-test='password']")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(css ="h3[data-test='error']")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void passingUsernameAndPassword(String usernamme, String password) {
        usernameField.sendKeys(usernamme);
        passwordField.sendKeys(password);
    }

    public void pressingLoginButton() {
        loginButton.click();
    }

    public void errorMessageForInvalidCredentials(){
        Assert.assertTrue(errorMessage.getText().contains("Username and password do not match any user in this service"));
    }
}
