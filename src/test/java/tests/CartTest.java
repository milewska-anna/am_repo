package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.CartPage;

public class CartTest extends BaseTest {

    @Test
    public void shouldDisplaySearchResultsWhenSearchForExistingProduct(){
        CartPage addToCart = new CartPage(driver);
        addToCart.addProductAndViewCart();
        Assertions.assertTrue(addToCart.isCorrectAddingProductToCartResult(),"Remove button was not found for a product with id=39." +
                " Was the product added to cart?");
    }
}
