package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.CartPage;
import pageobjects.CouponPage;

public class CouponTests extends BaseTest{


    @Test
    public void shouldInputCouponWhenCorrectCouponCodIsProvided(){
        CartPage addToCart = new CartPage(driver);
        CouponPage couponPage = new CouponPage(driver);
        addToCart.addProductAndViewCart();
        Assertions.assertTrue(addToCart.isCorrectAddingProductToCartResult(),"Remove button was not found for a product with id=39." +
                " Was the product added to cart?");
        couponPage.inputCouponCode("softie");
        Assertions.assertTrue(couponPage.isCorrectCouponCodeAlertDisplayed(),"Message is not correct");
    }

    @Test
    public void shouldDisplayErrorMessageWhenIncorrectCouponIsProvided(){
        CartPage addToCart = new CartPage(driver);
        CouponPage couponPage = new CouponPage(driver);
        addToCart.addProductAndViewCart();
        Assertions.assertTrue(addToCart.isCorrectAddingProductToCartResult(),"Remove button was not found for a product with id=39." +
                " Was the product added to cart?");
        couponPage.inputCouponCode("softie123");
        Assertions.assertTrue(couponPage.isIncorrectCouponCodeAlertDisplayed(),"Message is not correct");
    }
    @Test
    public void shouldDisplayErrorMessageWhenCouponCodeIsNotProvided(){
        CartPage addToCart = new CartPage(driver);
        CouponPage couponPage = new CouponPage(driver);
        addToCart.addProductAndViewCart();
        Assertions.assertTrue(addToCart.isCorrectAddingProductToCartResult(),"Remove button was not found for a product with id=39." +
                " Was the product added to cart?");
        couponPage.inputCouponCode("");
        Assertions.assertTrue(couponPage.couponCodeDoesNotProvidedAlertDisplayed(),"Message is not correct");
    }
}
