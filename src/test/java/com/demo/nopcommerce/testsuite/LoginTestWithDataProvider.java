package com.demo.nopcommerce.testsuite;

/*
Created by SP
*/

import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.pages.LoginErrorMessagePage;
import com.demo.nopcommerce.pages.LoginPage;
import com.demo.nopcommerce.pages.WelcomeStorePage;
import com.demo.nopcommerce.resources.testdata.TestData;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTestWithDataProvider extends TestBase {

    /*
     * Object for various required classes called for running methods for the tests
     */

    HomePage homePage;
    LoginPage loginPage;
    WelcomeStorePage welcomeStorePage;
    LoginErrorMessagePage loginErrorMessagePage;
    SoftAssert sa = new SoftAssert();

    @BeforeMethod
    public void setUpMethod (){
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

    @Test(priority = 1, groups = {"sanity", "regression"},
            dataProvider = "validCredentials", dataProviderClass = TestData.class)
    public void verifyUserIsAbleToLoginSuccessfully(String email, String password) {
        homePage.clickOnLoginLink();
        loginPage.loginToApplication(email, password);
        sa.assertEquals(welcomeStorePage.getWelcomeStoreText(), "Welcome to our store");
        sa.assertAll();
    }
    /*
     * Testing Login with invalid credentials
     * Error message expected
     */

    @Test(priority = 2, groups = {"sanity", "regression"},
            dataProvider = "invalidCredentials", dataProviderClass = TestData.class)
    public void verifyUserIsNotAbleToLoginWithInvalidCredentials (String email, String wrongPassword){
        homePage.clickOnLoginLink();
        loginPage.loginToApplication(email, wrongPassword);
        sa.assertTrue(loginErrorMessagePage.getErrorMessageText().contains("Login was unsuccessful. Please correct the errors and try again."));        sa.assertAll();
    }
/*
*Failing the test
 */

    @Test(priority = 3, groups = {"regression"},
            dataProvider = "wrongCredentials", dataProviderClass = TestData.class)
    public void verifyUserFailedLoginTest(String email, String password){
        homePage.clickOnLoginLink();
        loginPage.enterReturningUserEmail(email);
        loginPage.enterReturningUserPassword(password);
        loginPage.clickonReturningUserLoginButton();
        Assert.assertEquals(welcomeStorePage.getWelcomeStoreText(), "Wrong email");
        sa.assertAll();
    }
}
