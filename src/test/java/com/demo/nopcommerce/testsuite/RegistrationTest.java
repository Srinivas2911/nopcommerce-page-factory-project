package com.demo.nopcommerce.testsuite;

/*
Created by SP
*/

import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.pages.RegisterPage;
import com.demo.nopcommerce.pages.RegistrationCompletePage;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.demo.nopcommerce.utility.Utility.getRandomString;

public class RegistrationTest extends TestBase {

    /*
     * Object for various required classes called for running methods for the tests
     */

    HomePage homePage;
    RegisterPage registerPage;
    RegistrationCompletePage registrationCompletePage;
    SoftAssert sa = new SoftAssert();

    /*
     * Test data provided in the Test Class
     */

    String firstName = "Roger";
    String lastName = "Moore";
    String dateOfBirth = "1";
    String monthOfBirth = "January";
    String yearOfBirth = "1980";
    String email = null;
    String companyName = "Roger Moore International";
    String password = null;
    String wrongPassword = "Roger77777";

    @BeforeMethod(groups = {"smoke", "sanity", "regression"})
    public void setUpEmail() {
        email = "Roger" + getRandomString(4) + "@gmail.com";
        password = "Roger" + getRandomString(3);

        homePage = new HomePage();
        registerPage = new RegisterPage();
        registrationCompletePage = new RegistrationCompletePage();
    }

    /*
     * Navigating to Registration Page
     */

    @Test(priority = 0, groups = {"smoke", "sanity"})
    public void verifyThatUserIsAbleToNavigateToRegisterPage() {
        homePage.clickOnRegisterLink();
        registerPage.verifyRegisterText();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(registerPage.getRegisterText().contains("Register"));
        sa.assertAll();
    }
    /*
     * Testing Registration with valid credentials
     */

    @Test(priority = 1, groups = {"sanity", "regression"})
    public void verifyThatNewUserIsAbleToRegisterSuccessfully() {
        homePage.clickOnRegisterLink();
        registerPage.clickOnMaleGenderRadioButton();
        //registerPage.waitForElementIsVisible();
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterDayOfBirth(dateOfBirth);
        registerPage.enterMonthOfBirth(monthOfBirth);
        registerPage.enterYearOfBirth(yearOfBirth);
        registerPage.enterEmail(email);
        registerPage.enterCompanyName(companyName);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.clickOnRegisterButton();
        sa.assertTrue(registrationCompletePage.getRegistrationConfirmText().contains("Your registration completed"));
        sa.assertAll();
    }

    ////failing a test
    @Test(priority = 2, groups = {"regression"})
    public void verifyThatNewUserFailedTestToRegister() {
        homePage.clickOnRegisterLink();
        registerPage.clickOnMaleGenderRadioButton();
       // registerPage.waitForElementIsVisible();
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterDayOfBirth(dateOfBirth);
        registerPage.enterMonthOfBirth(monthOfBirth);
        registerPage.enterYearOfBirth(yearOfBirth);
        registerPage.enterEmail(email);
        registerPage.enterCompanyName(companyName);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.clickOnRegisterButton();
        Assert.assertEquals(registrationCompletePage.getRegistrationConfirmText(), "Your registration");
        sa.assertAll();
    }

    /*
     * Testing Login with invalid credentials
     * Expected error message
     */
    @Test(priority = 3, groups = {"sanity", "regression"})
    public void verifyUserisNotBeAbleToRegisterWithInvalidCredentials() {
        homePage.clickOnRegisterLink();
        registerPage.clickOnMaleGenderRadioButton();
        //registerPage.waitForElementIsVisible();
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterDayOfBirth(dateOfBirth);
        registerPage.enterMonthOfBirth(monthOfBirth);
        registerPage.enterYearOfBirth(yearOfBirth);
        registerPage.enterEmail(email);
        registerPage.enterCompanyName(companyName);
        registerPage.enterPassword(password);
        registerPage.enterWrongConfirmPassword(wrongPassword);
        registerPage.clickOnRegisterButton();
        registerPage.registrationErrorMessageText();
        sa.assertTrue(registerPage.getRegistrationErrorMessage().contains("The password and confirmation password do not match."));
        sa.assertAll();

    }
}
