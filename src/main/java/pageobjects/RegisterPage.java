package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css ="input[id='reg_username']") private WebElement usernameInputField;
    @FindBy(css ="input[id='reg_password']") private WebElement passwordInputField;
    @FindBy(css ="input[id='reg_email']") private WebElement emailAddressInputField;
    @FindBy(css ="button[name='register']") private WebElement registerButton;
    @FindBy(css ="ul[class='woocommerce-error']") private WebElement errorMessage;
    @FindBy(css ="h1[class='entry-title']") private WebElement pageTitle;


    public void registerUser(String username, String emailAddress, String password) {
        usernameInputField.sendKeys(username);
        emailAddressInputField.sendKeys(emailAddress);
        passwordInputField.sendKeys(password);
        registerButton.click();
    }

    public boolean usernameIsNotProvidedAlertDisplayed() {
        String expectedText = errorMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Error: Please enter a valid account username.");
        return isCorrectAlertText;
    }

    public boolean emailAddressIsNotProvidedAlertDisplayed() {
        String expectedText = errorMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Error: Please provide a valid email address.");
        return isCorrectAlertText;
    }

    public boolean passwordNotProvidedAlertDisplayed() {
        String expectedText = errorMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Error: Please enter an account password.");
        return isCorrectAlertText;
    }

    public boolean credentialsNotProvidedAlertDisplayed() {
        String expectedText = errorMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Error: Please provide a valid email address.");
        return isCorrectAlertText;
    }
    public boolean isProvidedExistingEmailAddressAlertDisplayed() {
        String expectedText = errorMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Error: An account is already registered with your email address. Please log in.");
        return isCorrectAlertText;
    }
    public boolean headerOfMyAccountPageIsCorrect() {
        String expectedText = pageTitle.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("My account");
        return isCorrectAlertText;
    }
}

