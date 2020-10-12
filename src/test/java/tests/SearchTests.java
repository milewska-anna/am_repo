package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;
import pageobjects.SearchResultPage;

public class SearchTests extends BaseTest{

    @Test
    public void isCorrectBrittaniaCoinsSearchingResults(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        SearchResultPage searchResultsPage = new SearchResultPage(driver);
        searchResultsPage.searchProducts("britannia coin");
        Assertions.assertTrue(searchResultsPage.brittaniaCoinsAreFounded(),"The result of searching is not expected");
    }

    @Test
    public void isCorrectBarsSearchingResults(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        SearchResultPage searchResultsPage = new SearchResultPage(driver);
        searchResultsPage.searchProducts("bar");
        Assertions.assertTrue(searchResultsPage.barAreFounded(),"The result of searching is not expected");
    }

    @Test
    public void shouldDisplayEmptySearchResultsWhenSearchForNotExistingProduct(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        SearchResultPage searchResultsPage = new SearchResultPage(driver);
        searchResultsPage.searchProducts("Not existing product");
        Assertions.assertTrue(searchResultsPage.resultsAreNotFounded(),"The result of searching is not expected");
    }
}
