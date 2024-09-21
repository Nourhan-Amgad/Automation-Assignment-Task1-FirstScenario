package org.tests;

import org.openqa.selenium.WebDriver;
import org.pages.NavBarPage;
import org.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utils.BrowserAction;
import org.utils.BrowserFactory;
import org.utils.JsonFileManager;

import java.io.FileNotFoundException;

public class CheckIfItemsIsAddedTest1 {
    //variables
    WebDriver driver;
    NavBarPage navBarPage;
    SearchResultPage searchResultPage;
    JsonFileManager jsonFileManager;

    //Tests
    @Test
    public void checkItemsAddedSuccessfully(){
        navBarPage.searchForItem(jsonFileManager.getTestData("Category"));
        searchResultPage.addFirstItemToCart();
        Assert.assertTrue(searchResultPage.IsInCartLabelOfFirstElementExist());
    }

    //Configurations
    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        jsonFileManager = new JsonFileManager("src/test/java/org/testData/CheckItemsAddedToCartTestData.json");
        driver = BrowserFactory.getBrowser(jsonFileManager.getTestData("browserName"));
        BrowserAction.navigateToUrl(driver,"https://www.amazon.com/",jsonFileManager.getTestData("ScreenWidth"),jsonFileManager.getTestData("ScreenHeight"));
        navBarPage = new NavBarPage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        BrowserAction.closeAllBrowserTabs(driver);
    }
}
