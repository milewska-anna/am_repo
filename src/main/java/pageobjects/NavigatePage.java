package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigatePage extends BasePage {
    public NavigatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css ="a[href*='/my-account/']") private WebElement myAccountPageHref;
    @FindBy(css ="a[href*='/checkout/']") private WebElement checkoutPageHref;
    @FindBy(css ="a[href*='/cart/'") private WebElement cartPageHref;
    @FindBy(css ="a[href*='/about-us/']") private WebElement aboutUsPageHref;
    @FindBy(xpath =".//ul[@class='nav-menu']//a[text()='Home']" ) private WebElement homePageHref;
    @FindBy(css ="h1[class='entry-title']") private WebElement pageTitle;
    @FindBy(css ="h1.page-title") private WebElement homePageTitle;

    public void goToMyAccountPage() {
        myAccountPageHref.click();
    }
    public void goToCheckoutPage() {
        checkoutPageHref.click();
    }
    public void goToCartPage(){
        cartPageHref.click();
    }
    public void goToAboutUsPage(){
        aboutUsPageHref.click();
    }
    public void goToHomePage() {
        homePageHref.click();
    }
    public boolean headerOfMyAccountPageIsCorrect() {
        String expectedText = pageTitle.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("My account");
        return isCorrectAlertText;
    }
    public boolean headerOfCheckoutPageIsCorrect() {
        String expectedText = pageTitle.getText();
        boolean isCorrectAlertText = expectedText.contains("Cart");
        return isCorrectAlertText;
    }
    public boolean headerOfCartPageIsCorrect() {
        String expectedText = pageTitle.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Cart");
        return isCorrectAlertText;
    }
    public boolean headerOfAboutUsPageIsCorrect() {
        String expectedText = pageTitle.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("About us");
        return isCorrectAlertText;
    }
    public boolean headerOfHomePageIsCorrect() {
        String expectedText = homePageTitle.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("Shop");
        return isCorrectAlertText;
    }
}
