package com.demo.nopcommerce.testsuite;

/*
Created by SP
*/

import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.pages.RegisterPage;
import com.demo.nopcommerce.pages.RegistrationCompletePage;
import com.demo.nopcommerce.resources.testdata.TestData;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.demo.nopcommerce.utility.Utility.getRandomString;

public class RegistrationTestWithDataProvider extends TestBase {

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

    String email = null;
    String password = null;
    String confirmPassword = null;
    String wrongPassword = "RogerJames123";

    @BeforeMethod(groups = {"smoke", "sanity", "regression"})
    public void setUpEmail() {
        email = "Roger" + getRandomString(4) + "@gmail.com";
        password = "Roger" + getRandomString(3);
        confirmPassword = password;

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
        sa.assertEquals(registerPage.getRegisterText(), "Register");
        sa.assertAll();
    }
    /*
     * Testing Registration with valid credentials
     */

    @Test(priority = 1,groups = {"sanity", "regression"},dataProvider = "registrationCredentials", dataProviderClass = TestData.class)
    public void verifyThatNewUserIsAbleToRegisterSuccessfully
            (String firstName, String lastName, String dateOfBirth, String monthOfBirth, String yearOfBirth, String companyName) {
        homePage.clickOnRegisterLink();
        registerPage.registrationApplication(firstName, lastName, dateOfBirth, monthOfBirth, yearOfBirth, companyName);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.clickOnRegisterButton();
        sa.assertEquals(registrationCompletePage.getRegistrationConfirmText(), "Your registration completed");
        sa.assertAll();
    }

    /*
     * Testing Registration with invalid credentials
     * Expected error message
     */


    @Test(priority = 2,groups = {"sanity", "regression"},dataProvider = "registrationCredentials", dataProviderClass = TestData.class)
    public void verifyUserIsNotAbleToRegisterWithInvalidCredentials
                (String firstName, String lastName, String dateOfBirth, String monthOfBirth, String yearOfBirth, String companyName){
        homePage.clickOnRegisterLink();
        registerPage.registrationApplication(firstName, lastName, dateOfBirth, monthOfBirth, yearOfBirth, companyName);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(wrongPassword);
        registerPage.clickOnRegisterButton();
        sa.assertTrue(registerPage.getRegistrationErrorMessage().contains("The password and confirmation password do not match."));
        sa.assertAll();
    }

    /*
     * Failing a test with false assertion
     */

    @Test(priority = 3,groups = {"regression"},dataProvider = "registrationCredentials", dataProviderClass = TestData.class)
    public void verifyThatNewUserFailedTestToRegister
            (String firstName, String lastName, String dateOfBirth, String monthOfBirth, String yearOfBirth, String companyName) {
        homePage.clickOnRegisterLink();
        registerPage.registrationApplication(firstName, lastName, dateOfBirth, monthOfBirth, yearOfBirth, companyName);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(wrongPassword);
        registerPage.clickOnRegisterButton();
        sa.assertEquals(registrationCompletePage.getRegistrationConfirmText(), "Your registration completed");
        sa.assertAll();
    }

}
