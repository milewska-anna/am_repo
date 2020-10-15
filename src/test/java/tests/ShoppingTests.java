package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.CartPage;
import pageobjects.ShoppingPage;

public class ShoppingTests extends BaseTest{

    @Test
    public void shouldPlaceAndOrderForAddedProductAndCredentialsProvided(){
        CartPage addToCart = new CartPage(driver);
        addToCart.addProductAndViewCart();
        Assertions.assertTrue(addToCart.isCorrectAddingProductToCartResult(),"Remove button was not found for a product with id=39." +
                " Was the product added to cart?");
        ShoppingPage shoppingPage=new ShoppingPage (driver);
        shoppingPage.goToCheckOutPage();
        shoppingPage.typeBillingDetails("Anna","Milewicz","Ogrodowa 17c/5","33031","Kraków",
                "809767891","anna.milewicz4526@interia.pl");
        Assertions.assertTrue(shoppingPage.isCorrectMakingOrderAlertDisplayed(),"The alert message is not correct");
    }
    @Test
    public void shouldDisplayErrorMessageWhenFirstNameIsNotProvided(){
        CartPage addToCart = new CartPage(driver);
        addToCart.addProductAndViewCart();
        Assertions.assertTrue(addToCart.isCorrectAddingProductToCartResult(),"Remove button was not found for a product with id=39." +
                " Was the product added to cart?");
        ShoppingPage shoppingPage=new ShoppingPage (driver);
        shoppingPage.goToCheckOutPage();
        shoppingPage.typeBillingDetails("","Milewicz","Ogrodowa 17c/5","33031","Kraków",
                "809767891","anna.milewicz4526@interia.pl");
        Assertions.assertTrue(shoppingPage.firstNameIsRequiredAlertDisplayed(),"The alert message is not correct");
    }
    @Test
    public void shouldDisplayErrorMessageWhenLastNameIsNotProvided(){
        CartPage addToCart = new CartPage(driver);
        addToCart.addProductAndViewCart();
        Assertions.assertTrue(addToCart.isCorrectAddingProductToCartResult(),"Remove button was not found for a product with id=39." +
                " Was the product added to cart?");
        ShoppingPage shoppingPage=new ShoppingPage (driver);
        shoppingPage.goToCheckOutPage();
        shoppingPage.typeBillingDetails("Anna","","Ogrodowa 17c/5","33031","Kraków",
                "809767891","anna.milewicz4526@interia.pl");
        Assertions.assertTrue(shoppingPage.lastNameIsRequiredAlertDisplayed(),"The alert message is not correct");
    }
    @Test
    public void shouldDisplayErrorMessageWhenStreetAddressIsNotProvided(){
        CartPage addToCart = new CartPage(driver);
        addToCart.addProductAndViewCart();
        Assertions.assertTrue(addToCart.isCorrectAddingProductToCartResult(),"Remove button was not found for a product with id=39." +
                " Was the product added to cart?");
        ShoppingPage shoppingPage=new ShoppingPage (driver);
        shoppingPage.goToCheckOutPage();
        shoppingPage.typeBillingDetails("Anna","Milewicz","","33031","Kraków",
                "809767891","anna.milewicz4526@interia.pl");
        Assertions.assertTrue(shoppingPage.addressIsRequiredAlertDisplayed(),"The alert message is not correct");
    }
    @Test
    public void shouldDisplayErrorMessageWhenPostcodeIsNotProvided(){
        CartPage addToCart = new CartPage(driver);
        addToCart.addProductAndViewCart();
        Assertions.assertTrue(addToCart.isCorrectAddingProductToCartResult(),"Remove button was not found for a product with id=39." +
                " Was the product added to cart?");
        ShoppingPage shoppingPage=new ShoppingPage (driver);
        shoppingPage.goToCheckOutPage();
        shoppingPage.typeBillingDetails("Anna","Milewicz","Ogrodowa 17c/5","","Kraków",
                "809767891","anna.milewicz4526@interia.pl");
        Assertions.assertTrue(shoppingPage.postcodeIsRequiredAlertDisplayed(),"The alert message is not correct");
    }

    @Test
    public void shouldDisplayErrorMessageWhenCityIsNotProvided(){
        CartPage addToCart = new CartPage(driver);
        addToCart.addProductAndViewCart();
        Assertions.assertTrue(addToCart.isCorrectAddingProductToCartResult(),"Remove button was not found for a product with id=39." +
                " Was the product added to cart?");
        ShoppingPage shoppingPage=new ShoppingPage (driver);
        shoppingPage.goToCheckOutPage();
        shoppingPage.typeBillingDetails("Anna","Milewicz","Ogrodowa 17c/5","33031","",
                "809767891","anna.milewicz4526@interia.pl");
        Assertions.assertTrue(shoppingPage.cityIsRequiredAlertDisplayed(),"The alert message is not correct");
    }
    @Test
    public void shouldDisplayErrorMessageWhenPhoneNumberIsNotProvided(){
        CartPage addToCart = new CartPage(driver);
        addToCart.addProductAndViewCart();
        Assertions.assertTrue(addToCart.isCorrectAddingProductToCartResult(),"Remove button was not found for a product with id=39." +
                " Was the product added to cart?");
        ShoppingPage shoppingPage=new ShoppingPage (driver);
        shoppingPage.goToCheckOutPage();
        shoppingPage.typeBillingDetails("Anna","Milewicz","Ogrodowa 17c/5","33031","Kraków",
                "","anna.milewicz4526@interia.pl");
        Assertions.assertTrue(shoppingPage.phoneNumberIsRequiredAlertDisplayed(),"The alert message is not correct");
    }

    @Test
    public void shouldDisplayErrorMessageWhenEmailAddressNumberIsNotProvided(){
        CartPage addToCart = new CartPage(driver);
        addToCart.addProductAndViewCart();
        Assertions.assertTrue(addToCart.isCorrectAddingProductToCartResult(),"Remove button was not found for a product with id=39." +
                " Was the product added to cart?");
        ShoppingPage shoppingPage=new ShoppingPage (driver);
        shoppingPage.goToCheckOutPage();
        shoppingPage.typeBillingDetails("Anna","Milewicz","Ogrodowa 17c/5","33031","Kraków",
                "809767891","");
        Assertions.assertTrue(shoppingPage.emailAddressNumberIsRequiredAlertDisplayed(),"The alert message is not correct");
    }
}
