package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[id='woocommerce-product-search-field-0']")
    private WebElement searchInput;
    @FindBy(css = "p[class='woocommerce-info']")
    private WebElement resultMessage;
    @FindBy(css = "a h2[class='woocommerce-loop-product__title']")
    private List<WebElement> productTitles;
    private String headerOfProduct;

    public void searchProducts(String searchPhrase) {
        searchInput.sendKeys(searchPhrase);
        searchInput.sendKeys(Keys.ENTER);
    }

    public boolean brittaniaCoinsAreFounded() {
        for (WebElement elements : productTitles) {
            headerOfProduct = elements.getText();
        }
        boolean isCorrectSearchingResults = headerOfProduct.contains("Britannia");
        return isCorrectSearchingResults;
    }

    public boolean barAreFounded() {
        for (WebElement elements : productTitles) {
            headerOfProduct = elements.getText();
        }
        boolean isCorrectSearchingResults = headerOfProduct.contains("Bar");
        return isCorrectSearchingResults;
    }

    public boolean resultsAreNotFounded() {
        String expectedText = resultMessage.getText();
        boolean isCorrectAlertText = expectedText.equals
                ("No products were found matching your selection.");
        return isCorrectAlertText;
    }
}