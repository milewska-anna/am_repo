package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;

public class LogoutTests extends BaseTest{

    @Test
    public void correctLogout(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo().loginUser("testowekonto@interia.pl", "mko908lop@sa");
        Assertions.assertTrue(loginPage.isUserLoggingCorrect(),"Your account page does not contain correct name");
        loginPage.logOutUser();
        Assertions.assertTrue(loginPage.isUserLoggingOutCorrect(),"Href 'Lost your password' is not located");
    }
}
