package pageobjects;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import java.util.Random;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(css = "input[id='username']") private WebElement usernameField;
    @FindBy(css = "input[id='password']") private WebElement passwordField;
    @FindBy(css = "button[name='login']") private WebElement submitButton;
    @FindBy(css = "p a[href*='/my-account/customer-logout']") private WebElement logOutHref;
    @FindBy(css = "ul.nav-menu a[href*='/my-account/']") private WebElement goToMyAccount;
    @FindBy(css = "input[id='reg_email']") private WebElement registerEmailInputField;
    @FindBy(css = "ul.woocommerce-error") private WebElement alertMessage;
    @FindBy(css = "button[name='login']") private WebElement loginButton;
    @FindBy(css = "div.woocommerce-MyAccount-content") private WebElement myAccountMessage;
    @FindBy(css = "p a[href*='/my-account/lost-password/']") private WebElement lostPassword;
    private String userNameDisplayed = "Alina Lenon";
    private String lostPasswordDisplayed = "Lost your password?";

    public LoginPage goTo() {
        goToMyAccount.click();
        return new LoginPage(driver);
    }

    public RegisterPage goToRegisterPage(String email) {
        Random random = new Random();
        String newEmail = "randomEmailAddress" + random.nextInt(100000) + email;
        registerEmailInputField.sendKeys(newEmail);
        System.out.println(newEmail);
        return new RegisterPage(driver);
    }

    public void loginUser(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public void logOutUser() {
        logOutHref.click();
    }

    public boolean isIncorrectPasswordAlertDisplayed() {
        String expectedText = alertMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Error: The password you entered for the email address testowekonto@interia.pl is incorrect. Lost your password?");
        return isCorrectAlertText;
    }

    public boolean isIncorrectUsernameAlertDisplayed() {
        String expectedText = alertMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Unknown username. Check again or try your email address.");
        return isCorrectAlertText;
    }

    public boolean isIncorrectEmailAddressAlertDisplayed() {
        String expectedText = alertMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Unknown email address. Check again or try your username.");
        return isCorrectAlertText;
    }

    public boolean isPasswordFieldEmptyAlertDisplayed() {
        String expectedText = alertMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Error: The password field is empty.");
        return isCorrectAlertText;
    }

    public boolean isUsernameFieldRequiredAlertDisplayed() {
        String expectedText = alertMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Error: Username is required.");
        return isCorrectAlertText;
    }

    public boolean isUserLoggingCorrect() {
        String expectedText = myAccountMessage.getText();
        boolean isCorrectLogging = expectedText.contains(userNameDisplayed);
        return isCorrectLogging;
    }

    public boolean isUserLoggingOutCorrect() {
        String expectedText = lostPassword.getText();
        boolean isCorrectLogout = expectedText.contains(lostPasswordDisplayed);
        return isCorrectLogout;
    }
}
