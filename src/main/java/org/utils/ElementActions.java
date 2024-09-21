package org.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ElementActions {
    private final WebDriver driver;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getExplicitWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(By elementLocator) {
        // Mouse hover on the element before clicking
        getExplicitWait(driver).until(ExpectedConditions.elementToBeClickable(elementLocator));
        driver.findElement(elementLocator).click();
    }

    public void type(By elementLocator, String text) {

        getExplicitWait(driver).until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        driver.findElement(elementLocator).sendKeys(text);
    }

    public boolean isElementExist(By elementLocator){
        getExplicitWait(driver).until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        return driver.findElement(elementLocator).isDisplayed();
    }

}