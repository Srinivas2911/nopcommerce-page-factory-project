package com.demo.nopcommerce.testsuite;

/*
Created by SP
*/

import com.demo.nopcommerce.pages.*;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestBase {
    /*
     * Object for various required classes called for running methods for the tests
     */

    HomePage homePage;
    LoginPage loginPage;
    WelcomeStorePage welcomeStorePage;
    LoginErrorMessagePage loginErrorMessagePage;
    SoftAssert sa = new SoftAssert();

    /*
     * Test data provided in the Test Class
     */

    String email = "Roger123@gmail.com";
    String password = "Roger1980";
    String wrongPassword = "Roger197777";

    @BeforeMethod(groups = {"sanity", "smoke", "regression"})

    public void setUp() {

        homePage = new HomePage();
        loginPage = new LoginPage();
        welcomeStorePage = new WelcomeStorePage();
        loginErrorMessagePage = new LoginErrorMessagePage();

    }


    /*
     * Navigating to Login Page
     */

    @Test(priority = 0, groups = {"smoke", "sanity"})
    public void verifyUserIsAbleToNavigatetoLoginPage() {
        homePage.clickOnLoginLink();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(loginPage.getWelcomeText().contains("Welcome, Please Sign In!"));
        sa.assertAll();
    }

    /*
     * Testing Login with valid credentials
     */

    @Test(priority = 1, groups = {"sanity", "regression"})
    public void verifyUserIsAbleToLoginSuccessfully() {
        homePage.clickOnLoginLink();
        loginPage.enterReturningUserEmail(email);
        loginPage.enterReturningUserPassword(password);
        loginPage.clickonReturningUserLoginButton();
        sa.assertTrue(welcomeStorePage.getWelcomeStoreText().contains("Welcome to our store"));
        sa.assertAll();
    }

    ////failing a test
    @Test(priority = 2, groups = {"regression"})
    public void verifyUserFailedLoginWithWrongDetails() {
        homePage.clickOnLoginLink();
        loginPage.enterReturningUserEmail(email);
        loginPage.enterReturningUserPassword(wrongPassword);
        loginPage.clickonReturningUserLoginButton();
        Assert.assertEquals(welcomeStorePage.getWelcomeStoreText(), "Wrong email");
        sa.assertAll();
    }

    /*
     * Testing Login with invalid credentials
     */


    @Test(priority = 3, groups = {"sanity", "regression"})
    public void verifyUserIsNotAbleToLoginWithInvalidCredentials() {
        homePage.clickOnLoginLink();
        loginPage.enterReturningUserEmail(email);
        loginPage.enterReturningUserWrongPassword(wrongPassword);
        loginPage.clickonReturningUserLoginButton();
        sa.assertTrue(loginErrorMessagePage.getErrorMessageText().contains("Login was unsuccessful. Please correct the errors and try again."));
        sa.assertAll();
    }

}
