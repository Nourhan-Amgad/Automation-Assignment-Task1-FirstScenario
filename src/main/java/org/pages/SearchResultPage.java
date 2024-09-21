package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.utils.ElementActions;

public class SearchResultPage {
    //Variables
    WebDriver driver;
    ElementActions elementActions;

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        elementActions = new ElementActions(driver);
    }

    //Locators
    By addToCartFirstBtnLocator = By.xpath("(//button[text() = 'Add to cart'])[1]");
    By inCartlabelLocator = By.xpath("//span[text() = '1 in cart']");

    //Actions
    public void addFirstItemToCart(){
        elementActions.click(addToCartFirstBtnLocator);
    }

    public boolean IsInCartLabelOfFirstElementExist(){
        return elementActions.isElementExist(inCartlabelLocator);
    }
}
