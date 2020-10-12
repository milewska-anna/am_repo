package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.ChangeAddressPage;
import pageobjects.LoginPage;

public class ChangeAddressTest extends BaseTest{

    @Test
    public void correctChangingRegisterUserAddress(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.goTo();
        loginPage.loginUser("testowekonto@interia.pl","mko908lop@sa");
        ChangeAddressPage changeAddressPage = new ChangeAddressPage(driver);
        changeAddressPage.changeUserAddress("Słoneczna 12/4","32006","Warszawa");
        Assertions.assertTrue(changeAddressPage.isCorrectAddressChangedAlertDisplayed(),"The message after saving your changes is not correct");
        }
    }
