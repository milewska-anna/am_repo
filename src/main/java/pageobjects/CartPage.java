package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "[class='added_to_cart wc-forward']") private WebElement viewCartButton;
    @FindBy (css = "table[class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']") private WebElement shopTable;
    private String productId = "39";
    private By productAddToCartButton = By.cssSelector("[href='?add-to-cart=" + productId + "']");
    private By removeProductButton = By.cssSelector("a[data-product_id='" + productId + "']");

    public void addProductAndViewCart() {
        addTheProduct();
        viewCart();
    }

    public void addTheProduct() {
        WebElement addProduct = driver.findElement(productAddToCartButton);
        addProduct.click();
    }

    public void viewCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartButton)).click();
        wait.until(ExpectedConditions.visibilityOf(shopTable));
    }

    public boolean isCorrectAddingProductToCartResult() {
        boolean isCorrectAddToCart = driver.findElements(removeProductButton).size() == 1;
        return isCorrectAddToCart;
    }
}
