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

public class LoginPage extends Utility {
    /*
     * Private static Logger for logging the elements and methods into the log4j
     * log.info will record the info into log4j and logs and reports
     * Reporter.log will record info into reportng and console
     * Using selenium @Findby and initElement methods for locators/elements
     * Using "_"  before locater name will help separate them from variable
     */
    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement _loginWelcomeText;

    @FindBy(id = "Email")
    WebElement _loginEmailField;

    @FindBy(xpath = "//input[@name='Password']")
    WebElement _loginPasswordField;

    @FindBy(xpath = "//input[@class='button-1 login-button']")
    WebElement _loginUserButton;

    public String getWelcomeText() {
        Reporter.log(" Getting Login Welcome Text Message : " + _loginWelcomeText.toString() + "<br>");
        log.info("Getting Login Welcome Text Message : " + _loginWelcomeText.toString());
        return getTextFromElement(_loginWelcomeText);
    }

    public void enterReturningUserEmail(String email) {
        // waitUntilVisibilityOfElementLocated((By) _loginEmailField, 90);
        Reporter.log("Entering Email Id : " + email + " On Email Field " + _loginEmailField.toString() + "<br>");
        clickOnElement(_loginEmailField);
        sendTextToElement(_loginEmailField, email);
        log.info("Entering Email Id : " + email + " On Email Field " + _loginEmailField.toString());
    }

    public void enterReturningUserPassword(String password) {
        Reporter.log("Entering Password : " + password + " On Password Field " + _loginPasswordField.toString() + "<br>");
        sendTextToElement(_loginPasswordField, password);
        log.info("Entering Password : " + password + " On Password Field " + _loginPasswordField.toString());
    }

    public void enterReturningUserWrongPassword(String wrongPassword) {
        Reporter.log("Entering A Wrong Password : " + wrongPassword + " On Password Field " + _loginPasswordField.toString() + "<br>");
        sendTextToElement(_loginPasswordField, wrongPassword);
        log.info("Entering A Wrong Password : " + wrongPassword + " On Password Field " + _loginPasswordField.toString());
    }

    public void clickonReturningUserLoginButton() {
        Reporter.log(" Clicking on Login Button : " + _loginUserButton.toString() + "<br>");
        clickOnElement(_loginUserButton);
        log.info(" Clicking on Login Button : " + _loginUserButton.toString());

    }

    public void loginToApplication(String email, String password) {
        enterReturningUserEmail(email);
        enterReturningUserPassword(password);
        clickonReturningUserLoginButton();
    }
}
