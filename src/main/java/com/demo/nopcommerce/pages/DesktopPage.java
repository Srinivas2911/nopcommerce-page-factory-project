package com.demo.nopcommerce.pages;

/*
Created by SP
*/

import com.demo.nopcommerce.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DesktopPage extends Utility {
    /*
     * Private static Logger for logging the elements and methods into the log4j
     * log.info will record the info into log4j and logs and reports
     * Reporter.log will record info into reportng and console
     * Using selenium @Findby and initElement methods for locators/elements
     * Using "_" before locater name will help separate them from variable
     */
    private static final Logger log = LogManager.getLogger(DesktopPage.class.getName());

    @FindBy(xpath = "/html/body/div[6]/div[3]/div[2]/div[2]/div/div[1]/h1")
    WebElement _desktopText;

    public void verifyDesktopText() {
        Reporter.log("Verifying Desktop Text : " +_desktopText.toString()+"<br>");
        verifyThatTextIsDisplayed(_desktopText, "Desktops");
        log.info("Verifying Desktop Text : " +_desktopText.toString());
    }
    public String getDesktopText() {
        Reporter.log("Getting Desktop Text : " +_desktopText.toString()+"<br>");
        log.info("Getting Desktop Text : " +_desktopText.toString());
        return getTextFromElement(_desktopText);
    }
    public void clickOnDesktopLink() {
        Reporter.log("Clicking on Desktop Text : " +_desktopText.toString()+"<br>");
        clickOnElement(_desktopText);
        log.info("Clicking on Desktop Text : " +_desktopText.toString());
    }
}