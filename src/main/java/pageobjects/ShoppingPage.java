package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingPage extends BasePage {
    public ShoppingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css ="a[class='checkout-button button alt wc-forward']") private WebElement checkOutButton;
    @FindBy(css ="input[id='billing_first_name']") private WebElement firstNameInputField;
    @FindBy(css ="input[id='billing_last_name']") private WebElement lastNameInputField;
    @FindBy(css ="input[id='billing_address_1']") private WebElement addressInputField;
    @FindBy(css ="input[id='billing_postcode']") private WebElement postcodeInputField;
    @FindBy(css ="input[id='billing_city']") private WebElement townInputField;
    @FindBy(css ="input[id='billing_phone']") private WebElement phoneNumberInputField;
    @FindBy(css ="input[id='billing_email']") private WebElement emailAddressInputField;
    @FindBy(css ="button[id='place_order']") private WebElement placeOrderButton;
    @FindBy(css ="ul[class='woocommerce-error']") private WebElement errorTextMessage;
    @FindBy(css ="p.woocommerce-thankyou-order-received") private WebElement positiveTextMessage;

    public void goToCheckOutPage() {
        checkOutButton.click();
    }


    public void typeBillingDetails(String firstName, String lastName, String address, String postcode,
                                   String town, String phoneNumber, String emailAddress) {
        firstNameInputField.sendKeys(firstName);
        lastNameInputField.sendKeys(lastName);
        addressInputField.sendKeys(address);
        postcodeInputField.sendKeys(postcode);
        townInputField.sendKeys(town);
        phoneNumberInputField.sendKeys(phoneNumber);
        emailAddressInputField.sendKeys(emailAddress);
        placeOrderButton.submit();
    }

    public boolean isCorrectMakingOrderAlertDisplayed() {
        String expectedText = positiveTextMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Thank you. Your order has been received.");
        return isCorrectAlertText;
    }

    public boolean firstNameIsRequiredAlertDisplayed() {
        String expectedText = errorTextMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Billing First name is a required field.");
        return isCorrectAlertText;
    }

    public boolean lastNameIsRequiredAlertDisplayed() {
        String expectedText = errorTextMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Billing Last name is a required field.");
        return isCorrectAlertText;
    }

    public boolean addressIsRequiredAlertDisplayed() {
        String expectedText = errorTextMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Billing Street address is a required field.");
        return isCorrectAlertText;
    }

    public boolean postcodeIsRequiredAlertDisplayed() {
        String expectedText = errorTextMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Billing Postcode / ZIP is not a valid postcode / ZIP.");
        return isCorrectAlertText;
    }

    public boolean cityIsRequiredAlertDisplayed() {
        String expectedText = errorTextMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Billing Town / City is a required field.");
        return isCorrectAlertText;
    }

    public boolean phoneNumberIsRequiredAlertDisplayed() {
        String expectedText = errorTextMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Billing Phone is a required field.");
        return isCorrectAlertText;
    }

    public boolean emailAddressNumberIsRequiredAlertDisplayed() {
        String expectedText = errorTextMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Billing Email address is a required field.");
        return isCorrectAlertText;
    }
}
