package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;

public class LoginTest extends BaseTest{

    @Test
    public void loggingWhenCorrectCredentialsAreProvided() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo().loginUser("testowekonto@interia.pl", "mko908lop@sa");
        Assertions.assertTrue(loginPage.isUserLoggingCorrect(),"Your account page does not contain correct name");
    }

    @Test
    public void loggingFailedWhenCorrectAddressEmailAndIncorrectPasswordIsProvided() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo().loginUser("testowekonto@interia.pl", "sdcsdv");
        Assertions.assertTrue(loginPage.isIncorrectPasswordAlertDisplayed(),"Error message is not correct");
    }

    @Test
    public void loggingFailedWhenIncorrectUsernameIsProvided() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo().loginUser("testowekonto", "sdcsdv");
        Assertions.assertTrue(loginPage.isIncorrectUsernameAlertDisplayed(),"Error message is not correct");
    }
    @Test
    public void loggingFailedWhenOnlyEmailAddressIsProvided() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo().loginUser("testowekonto@interia.pl", " ");
        Assertions.assertTrue(loginPage.isPasswordFieldEmptyAlertDisplayed(),"Error message is not correct");
    }
    @Test
    public void loggingFailedWhenOnlyPasswordIsProvided() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo().loginUser(" ", "ymtymktmk");
        Assertions.assertTrue(loginPage.isUsernameFieldRequiredAlertDisplayed(),"Error message is not correct");
    }
    @Test
    public void loggingFailedWhenCredentialsAreNotProvided() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo().loginUser(" ", " ");
        Assertions.assertTrue(loginPage.isUsernameFieldRequiredAlertDisplayed(),"Error message is not correct");
    }

    @Test
    public void loggingFailedWhenIncorrectEmailAddressIsProvided() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo().loginUser("testowekonto2@interia.pll", "eowgohw");
        Assertions.assertTrue(loginPage.isIncorrectEmailAddressAlertDisplayed(),"Error message is not correct");
    }

}
