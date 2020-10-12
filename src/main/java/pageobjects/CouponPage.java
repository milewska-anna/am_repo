package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CouponPage extends BasePage {
    public CouponPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css ="input[id='coupon_code']") private WebElement couponCodeField;
    @FindBy(css ="div button[name='apply_coupon']") private WebElement applyCouponButton;
    @FindBy(css ="div[class='woocommerce-notices-wrapper']") private WebElement couponAlertMessage;
    By loader=By.cssSelector(".blockUI");

    public void inputCouponCode(String couponCode) {
        couponCodeField.sendKeys(couponCode);
        applyCouponButton.click();
        waitForProcessingEnd();
    }

    public boolean isCorrectCouponCodeAlertDisplayed() {
        String expectedText = couponAlertMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Coupon code applied successfully.");
        return isCorrectAlertText;
    }

    public boolean isIncorrectCouponCodeAlertDisplayed() {
        String expectedText = couponAlertMessage.getText();
        boolean isCorrectAlertText = expectedText.equals("Coupon \"softie123\" does not exist!");
        return isCorrectAlertText;
    }

    public boolean couponCodeDoesNotProvidedAlertDisplayed() {
        String expectedText = couponAlertMessage.getText();
        boolean isCorrectAlertText = expectedText.equals("Please enter a coupon code.");
        return isCorrectAlertText;
    }
    private void waitForProcessingEnd(){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(loader, 0));
        wait.until(ExpectedConditions.numberOfElementsToBe(loader,0));
    }
}