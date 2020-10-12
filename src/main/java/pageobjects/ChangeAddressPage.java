package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangeAddressPage extends BasePage {
    public ChangeAddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href*='/my-account/edit-address/']")
    private WebElement goToBillingAddress;
    @FindBy(css = "a[href*='/my-account/edit-address/billing']")
    private WebElement goToBillingAddressEditPage;
    @FindBy(css = "input[id='billing_address_1']")
    private WebElement streetAddressInputField;
    @FindBy(css = "input[id='billing_postcode']")
    private WebElement postcodeInputField;
    @FindBy(css = "input[id='billing_city']")
    private WebElement townInputField;
    @FindBy(css = "button[name='save_address']")
    private WebElement saveAddressButton;
    @FindBy(css = "div[class='woocommerce-message']")
    private WebElement alertMessage;

    public void changeUserAddress(String address, String postcode, String town) {
        goToBillingAddress.click();
        goToBillingAddressEditPage.click();
        streetAddressInputField.clear();
        streetAddressInputField.sendKeys(address);
        postcodeInputField.clear();
        postcodeInputField.sendKeys(postcode);
        townInputField.clear();
        townInputField.sendKeys(town);
        saveAddressButton.click();
    }

    public boolean isCorrectAddressChangedAlertDisplayed() {
        String expectedText = alertMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Address changed successfully.");
        return isCorrectAlertText;
    }
}
