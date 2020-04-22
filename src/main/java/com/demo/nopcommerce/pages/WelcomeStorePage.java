package com.demo.nopcommerce.pages;

/*
Created by SP
*/

import com.demo.nopcommerce.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class WelcomeStorePage extends Utility {
    /*
     * Private static Logger for logging the elements and methods into the log4j
     * log.info will record the info into log4j and logs and reports
     * Reporter.log will record info into reportng and console
     * Using selenium @Findby and initElement methods for locators/elements
     * Using "_" before locater name will help separate them from variable
     */
    private static final Logger log = LogManager.getLogger(WelcomeStorePage.class.getName());

@FindBy(xpath = "//div[@class='topic-block-title']//h2")
WebElement _welcomeStoreText;

    public String getWelcomeStoreText() {
        Reporter.log("Getting Welcome Store Text" + _welcomeStoreText.toString() + "<br>");
        log.info("Getting Welcome Store Text" + _welcomeStoreText.toString());
        return getTextFromElement(_welcomeStoreText);
    }


}
