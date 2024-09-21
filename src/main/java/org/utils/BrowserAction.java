package org.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class BrowserAction {


    public static void navigateToUrl (WebDriver driver, String url, String ScreenWidth, String ScreenHeight){
            Dimension dimension = new Dimension(Integer.parseInt(ScreenWidth), Integer.parseInt(ScreenHeight));
            driver.manage().window().maximize();
            driver.manage().window().setSize(dimension);
            driver.get(url);
    }

    public static void closeAllBrowserTabs(WebDriver driver){
        if(driver != null){
            driver.quit();
        }else{
            System.out.println("Driver is already closed and driver object is null");
        }
    }
}
