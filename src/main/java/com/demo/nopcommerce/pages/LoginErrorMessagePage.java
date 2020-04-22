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

public class LoginErrorMessagePage extends Utility {

    /*
     * Private static Logger for logging the elements and methods into the log4j
     * log.info will record the info into log4j and logs and reports
     * Reporter.log will record info into reportng and console
     * Using selenium @Findby and initElement methods for locators/elements
     * Using "_" before locater name will help separate them from variable
     */
    private static final Logger log = LogManager.getLogger(LoginErrorMessagePage.class.getName());

    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement _errorMessageText;

      public String getErrorMessageText() {
          Reporter.log(" Getting Error Message Text : " + _errorMessageText.toString() + "<br>");
          log.info("Clicking Error Message Text : " + _errorMessageText.toString());
          return getTextFromElement(_errorMessageText);
    }
}
