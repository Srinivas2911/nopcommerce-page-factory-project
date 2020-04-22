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

public class RegisterPage extends Utility {

    /*
     * Private static Logger for logging the elements and methods into the log4j
     * log.info will record the info into log4j and logs and reports
     * Reporter.log will record info into reportng and console
     * Using selenium @Findby and initElement methods for locators/elements
     * Using "_" before locater name will help separate them from variable
     */
    private static final Logger log = LogManager.getLogger(RegisterPage.class.getName());

    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement _registerText;

    @FindBy(id = "gender-male")
    WebElement _genderMaleRadioButton;

    @FindBy(xpath = "//input[@name='FirstName']")
    WebElement _firstNameField;

    @FindBy(xpath = "//input[@name='LastName']")
    WebElement _lastNameField;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement _dayOfBirthField;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement _monthOfBirthField;

    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    WebElement _yearOfBirthField;

    @FindBy(xpath = "//input[@name='Email']")
    WebElement _newUserEmailField;

    @FindBy(xpath = "//input[@name='Company']")
    WebElement _companyField;

    @FindBy(xpath = "//input[@name='Password']")
    WebElement _newUserPasswordField;

    @FindBy(xpath = "//input[@name='ConfirmPassword']")
    WebElement _confirmPasswordField;

    @FindBy(xpath = "//input[@name='register-button']")
    WebElement _newUserRegisterButton;

    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    WebElement _registrationErrorMessage;

    public void verifyRegisterText() {
        Reporter.log("Verifying Register Text : " + _registerText.toString() + "<br>");
        verifyThatTextIsDisplayed(_registerText, "Register");
        log.info("Verifying Register Text : " + _registerText.toString());
    }

    public String getRegisterText() {
        Reporter.log("Getting Register Text : " + _registerText.toString() + "<br>");
        log.info("Getting Register Text : " + _registerText.toString());
        return getTextFromElement(_registerText);
    }

    public void clickOnMaleGenderRadioButton() {
        Reporter.log("Clicking on Male Gender Radio Button  : " + _genderMaleRadioButton.toString() + "<br>");
        clickOnElement(_genderMaleRadioButton);
        log.info("Clicking on Male Gender Radio Button : " + _genderMaleRadioButton.toString());
    }

    public void waitForElementIsVisible() {
//        waitUntilElementToBeClickable((By) _firstNameField, 20);
    }

    public void enterFirstName(String firstName) {
        Reporter.log("Entering First Name : " + firstName + " On First Name Field : " + _firstNameField.toString() + "<br>");
        sendTextToElement(_firstNameField, firstName);
        log.info("Entering First Name : " + firstName + " On First Name Field : " + _firstNameField.toString());
    }

    public void enterLastName(String lastName) {
        Reporter.log("Entering Last Name : " + lastName + " On Last Name Field : " + _lastNameField.toString() + "<br>");
        sendTextToElement(_lastNameField, lastName);
        log.info("Entering Last Name : " + lastName + " On Last Name Field : " + _lastNameField.toString());
    }

    public void enterDayOfBirth(String dateOfBirth) {
        Reporter.log("Selecting Day of Birth : " + dateOfBirth + " On Day of Birth Field : " + _dayOfBirthField.toString() + "<br>");
        selectByVisibleTextFromDropDown(_dayOfBirthField, dateOfBirth);
        log.info("Selecting Day of Birth : " + dateOfBirth + " On Day of Birth Field : " + _dayOfBirthField.toString());
    }

    public void enterMonthOfBirth(String monthOfBirth) {
        Reporter.log("Selecting Month of Birth : " + monthOfBirth + " On Month of Birth Field : " + _monthOfBirthField.toString() + "<br>");
        selectByVisibleTextFromDropDown(_monthOfBirthField, monthOfBirth);
        log.info("Selecting Month of Birth : " + monthOfBirth + " On Month of Birth Field : " + _monthOfBirthField.toString());
    }

    public void enterYearOfBirth(String yearOfBirth) {
        Reporter.log("Selecting Year of Birth : " + yearOfBirth + " On Year of Birth Field : " + _yearOfBirthField.toString() + "<br>");
        selectByVisibleTextFromDropDown(_yearOfBirthField, yearOfBirth);
        log.info("Selecting Year of Birth : " + yearOfBirth + " On Year of Birth Field : " + _yearOfBirthField.toString());
    }

    public void enterEmail(String email) {
        Reporter.log("Entering Email ID : " + email + " On Email Field : " + _newUserEmailField.toString() + "<br>");
        sendTextToElement(_newUserEmailField, email);
        log.info("Entering Email ID : " + email + " On Email Field : " + _newUserEmailField.toString());
    }

    public void enterCompanyName(String companyName) {
        Reporter.log("Entering Company Name : " + companyName + " On Company Name Field : " + _companyField.toString() + "<br>");
        clickOnElement(_companyField);
        sendTextToElement(_companyField, companyName);
        log.info("Entering Company Name : " + companyName + " On Company Name Field : " + _companyField.toString());
    }

    public void enterPassword(String password) {
        Reporter.log("Entering Password : " + password + " On Password Field : " + _newUserPasswordField.toString() + "<br>");
        sendTextToElement(_newUserPasswordField, password);
        log.info("Entering Password : " + password + " On Password Field : " + _newUserPasswordField.toString());
    }

    public void enterConfirmPassword(String password) {
        Reporter.log("Confirming Password : " + password + " On Confirm Password Field : " + _confirmPasswordField.toString() + "<br>");
        sendTextToElement(_confirmPasswordField, password);
        log.info("Confirming Password : " + password + " On Confirm Password Field : " + _confirmPasswordField.toString());
    }

    // wrongPassword for failing a test or invalid credential check
    public void enterWrongConfirmPassword(String wrongPassword) {
        Reporter.log("Providing Wrong Confirm Password : " + wrongPassword + " On Confirm Password Field : " + _confirmPasswordField.toString() + "<br>");
        sendTextToElement(_confirmPasswordField, wrongPassword);
        log.info("Providing Wrong Confirm Password : " + wrongPassword + " On Confirm Password Field : " + _confirmPasswordField.toString());
    }

    public void clickOnRegisterButton() {
        Reporter.log("Clicking on Register Button  : " + _newUserRegisterButton.toString() + "<br>");
        mouseHoverToElementAndClick(_newUserRegisterButton);
        log.info("Clicking on Register Button  : " + _newUserRegisterButton.toString());
    }

    public void registrationErrorMessageText() {
        Reporter.log("Verifying Registration Error Message : " + _registrationErrorMessage.toString() + "<br>");
        verifyThatTextIsDisplayed(_registrationErrorMessage, "The password and confirmation password do not match.");
        log.info("Verifying Registration Error Message : " + _registrationErrorMessage.toString());
    }

    public String getRegistrationErrorMessage() {
        Reporter.log("Getting Registration Error Message : " + _registrationErrorMessage.toString() + "<br>");
        log.info("Getting Registration Error Message : " + _registrationErrorMessage.toString());
        return getTextFromElement(_registrationErrorMessage);
    }

    public void registrationApplication
            (String firstName, String lastName, String dateOfBirth,
             String monthOfBirth, String yearOfBirth, String companyName) {
        waitForElementIsVisible();
        clickOnMaleGenderRadioButton();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterDayOfBirth(dateOfBirth);
        enterMonthOfBirth(monthOfBirth);
        enterYearOfBirth(yearOfBirth);
//        enterEmail(email);
        enterCompanyName(companyName);
//        enterPassword(password);
//        enterConfirmPassword(confirmPassword);
//        clickOnRegisterButton();



    }

}
