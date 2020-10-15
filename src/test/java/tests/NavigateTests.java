package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.NavigatePage;

public class NavigateTests extends BaseTest {

    @Test
    public void shouldBeAbleToPositiveNavigationToMyAccountPage(){
        NavigatePage navigatePage = new NavigatePage(driver);
        navigatePage.goToMyAccountPage();
        Assertions.assertTrue(navigatePage.headerOfMyAccountPageIsCorrect(),"Header of 'My Account page' is not correct");
    }

    @Test
    public void shouldBeAbleToPositiveNavigationToCheckoutPage(){
        NavigatePage navigatePage = new NavigatePage(driver);
        navigatePage.goToCheckoutPage();
        Assertions.assertTrue(navigatePage.headerOfCheckoutPageIsCorrect(),"Header of 'Checkout page' is not correct");
    }
    @Test
    public void shouldBeAbleToPositiveNavigationToCartPage(){
        NavigatePage navigatePage = new NavigatePage(driver);
        navigatePage.goToCartPage();
        Assertions.assertTrue(navigatePage.headerOfCartPageIsCorrect(),"Header of 'Cart page' is not correct");
    }
    @Test
    public void shouldBeAbleToPositiveNavigationToAboutUsPage(){
        NavigatePage navigatePage = new NavigatePage(driver);
        navigatePage.goToAboutUsPage();
        Assertions.assertTrue(navigatePage.headerOfAboutUsPageIsCorrect(),"Header of 'About us page' is not correct");
    }
    @Test
    public void shouldBeAbleToPositiveNavigationToHomePage(){
        NavigatePage navigatePage = new NavigatePage(driver);
        navigatePage.goToHomePage();
        Assertions.assertTrue(navigatePage.headerOfHomePageIsCorrect(),"Header of 'Home page' is not correct");
    }
}
