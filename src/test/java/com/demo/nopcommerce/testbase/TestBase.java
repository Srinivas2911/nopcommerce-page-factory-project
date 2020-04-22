package com.demo.nopcommerce.testbase;

/*
Created by SP
*/

import com.demo.nopcommerce.basepage.BasePage;
import com.demo.nopcommerce.browserselector.BrowserSelector;
import com.demo.nopcommerce.loadproperty.LoadProperty;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase extends BasePage {
    /*
     * TestBase Page extends to BasePage for the driver.
     * This page is used for browser selection, getting the url
     * And assigning browser open and close methods before and after tests in the tests.

     * Object created for Browser Selector for choosing browser and running the browser
     * Object for Load Property for calling the browser and URL
     */

    BrowserSelector browserSelector = new BrowserSelector();
    LoadProperty loadProperty = new LoadProperty();
    String baseUrl = loadProperty.getProperty("baseUrl");
    String browser = loadProperty.getProperty("browser");

    @BeforeMethod(groups = {"sanity", "smoke", "regression"})
    public void openBrowser() {
        browserSelector.selectBrowser(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @AfterMethod(groups = {"sanity", "smoke", "regression"})
    public void tearDown() {
        driver.quit();
    }
}
