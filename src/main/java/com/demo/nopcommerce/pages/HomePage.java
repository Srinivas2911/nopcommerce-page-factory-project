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

/* Homepage extends to Utility for the methods that needs to be performed.
 * Listing all the elements through their locators
 */

public class HomePage extends Utility {
    /*
     * Private static Logger for logging the elements and methods into the log4j
     * log.info will record the info into log4j and logs and reports
     * Reporter.log will record info into reportng and console
     * Using selenium @Findby and initElement methods for locators/elements
     * Using "_" before locater name will help separate them from variable
     */
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(linkText = "Register")
    WebElement _registerLink;

    @FindBy(linkText = "Log in")
    WebElement _loginLink;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]")
    WebElement _computerLink;

    public void clickOnRegisterLink() {
        Reporter.log("Clicking on Register Link : " + _registerLink.toString() + "<br>");
        clickOnElement(_registerLink);
        log.info("Clicking on Register Link : " + _registerLink.toString());
    }

    public void clickOnLoginLink() {
       Reporter.log("Clicking on Login Link : " + _loginLink.toString() + "<br>");
        clickOnElement(_loginLink);
        log.info("Clicking on Login Link : " + _loginLink.toString());
    }

    public void clickOnComputerLink() {
        Reporter.log("Clicking on Computer Link : " + _computerLink.toString() + "<br>");
        clickOnElement(_computerLink);
        log.info("Clicking on Computer Link : " + _computerLink.toString());
    }

    public void mouseOverToComputers() {
        Reporter.log("Clicking on Computer Link : " + _computerLink.toString() + "<br>");
        mouseHoverToElementAndClick(_computerLink);
        log.info("Clicking on Computer Link : " + _computerLink.toString());
    }
}
