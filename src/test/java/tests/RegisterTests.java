package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;
import pageobjects.RegisterPage;

public class RegisterTests extends BaseTest{

    @Test
    public void registrationWhenCorrectCredentialsAreProvided(){
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        loginPage.goTo().goToRegisterPage("@gmail.com");
        registerPage.registerUser("123username567","","678heycdbdbh");
        Assertions.assertTrue(registerPage.headerOfMyAccountPageIsCorrect(),"The Header's pf the page title is not expected");
    }

    @Test
    public void registrationFailedWhenUsernameIsNotProvided(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo().goToRegisterPage("@gmail.com");
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerUser("","","678heycdbdbh");
        Assertions.assertTrue(registerPage.usernameIsNotProvidedAlertDisplayed(),"Error message");
    }

    @Test
    public void registrationFailedWhenUserEmailAddressIsNotProvided(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerUser("randomusername","","678heycdbdbh");
        Assertions.assertTrue(registerPage.emailAddressIsNotProvidedAlertDisplayed(),"Error message");
    }
    @Test
    public void registrationFailedWhenUserPasswordIsNotProvided(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo().goToRegisterPage("@gmail.com");
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerUser("randomusername","","");
        Assertions.assertTrue(registerPage.passwordNotProvidedAlertDisplayed(),"Error message");
    }
    @Test
    public void registrationFailedWhenCredentialsAreNotProvided(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerUser("","","");
        Assertions.assertTrue(registerPage.credentialsNotProvidedAlertDisplayed(),"Error message");
    }

    @Test
    public void registrationFailedWhenIsProvidedExistingEmailAddress(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerUser("randomusername","testowekonto@interia.pl","jdhfwru34957ty39");
        Assertions.assertTrue(registerPage.isProvidedExistingEmailAddressAlertDisplayed(),"Error message");
    }
}
