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

public class ComputersPage extends Utility {

    /*
     * Private static Logger for logging the elements and methods into the log4j
     * log.info will record the info into log4j and logs and reports
     * Reporter.log will record info into reportng and console
     * Using selenium @Findby and initElement methods for locators/elements
     * Using "_" before locater name will help separate them from variable
     */

    private static final Logger log = LogManager.getLogger(ComputersPage.class.getName());

//Using selenium @Findby and initElement methods for locators/elements
// using _ help separate them from variable

@FindBy(xpath = "//div[@class='page-title']//h1")
WebElement _computerText;

@FindBy(xpath = "//h2[@class='title']//a[contains(text(),'Desktops')]")
WebElement _desktopLink;

    public void verifyComputerText(){
        Reporter.log("Verifying Computer Text : " +_computerText.toString()+"<br>");
        verifyThatTextIsDisplayed(_computerText, "Computers");
        log.info("Verifying Computer Text : " +_computerText.toString());
    }
    public String getComputerText() {
        Reporter.log("Getting Computer Text : "+getTextFromElement(_computerText)+" " +_computerText.toString()+"<br>");
        log.info("Getting Computer Text : "+getTextFromElement(_computerText)+" " +_computerText.toString());
        return getTextFromElement(_computerText);
    }
    public void clickOnDesktopLink() {
        Reporter.log("Clicking on Desktop Link : " +_desktopLink.toString()+"<br>");
        clickOnElement(_desktopLink);
        log.info("Clicking on Desktop Link : " +_desktopLink.toString());
    }
    public void verifyDesktopLink() {
        Reporter.log("Verifying Desktop Link Text : " +_desktopLink.toString()+"<br>");
        verifyThatTextIsDisplayed(_desktopLink, " Desktops ");
        log.info("Verifying Desktop Link Text : " +_desktopLink.toString());
    }
    public String getDesktopText() {
        Reporter.log("Getting Verifying Desktop Link Text : " +_desktopLink.toString()+"<br>");
        log.info("Getting Verifying Desktop Link Text : " +_desktopLink.toString());
        return getTextFromElement(_desktopLink);
    }
}