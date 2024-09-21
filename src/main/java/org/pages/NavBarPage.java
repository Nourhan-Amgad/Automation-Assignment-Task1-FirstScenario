package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.utils.ElementActions;

public class NavBarPage {
    //Variables
    WebDriver driver;
    ElementActions elementActions;

    public NavBarPage(WebDriver driver){
        this.driver = driver;
        elementActions = new ElementActions(driver);
    }

    //Locators
    By searchBarLocator = By.id("twotabsearchtextbox");
    By searchButtonLocator = By.id("nav-search-submit-button");

    //Actions
    public void searchForItem(String itemName){
        elementActions.type(searchBarLocator,itemName);
        elementActions.click(searchButtonLocator);
    }

}
