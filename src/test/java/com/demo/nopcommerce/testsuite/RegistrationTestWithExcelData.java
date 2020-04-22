package com.demo.nopcommerce.testsuite;

/*
Created by SP
*/

import com.demo.nopcommerce.excelutility.ExcelUtility;
import com.demo.nopcommerce.pages.*;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.demo.nopcommerce.utility.Utility.getRandomString;

public class RegistrationTestWithExcelData extends TestBase {

    /*
     * Using the excel data sheet data for the test data
     * Path subscribed for the excel sheet location
     */

    public static final String FilePath = System.getProperty("user.dir") + "/src/test/java/com/demo/nopcommerce/resources/testdata/NewDataSheet.xlsx/";
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

    @BeforeClass(groups = {"sanity", "smoke", "regression"})
    public void setExcel() {
        // Tell the code about location of Excel file
        try {
            ExcelUtility.setExcelFile(FilePath, "Registration");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
        Create object for the class in the setUpMethod
         */
    @BeforeMethod(groups = {"sanity", "smoke", "regression"})
    public void setUpMethod() {
        email = "Roger" + getRandomString(4) + "@gmail.com";
        password = "Roger" + getRandomString(3);
        confirmPassword = password;

        homePage = new HomePage();
        registerPage = new RegisterPage();
        registrationCompletePage = new RegistrationCompletePage();

    }

    // Calling data information" and from Data Provider Class

    @DataProvider(name = "registrationCredentials")
    public Object[][] getData() {
        Object[][] data = ExcelUtility.getTestData("registrationData");
        return data;
    }
    /*
     * Testing Registration with valid credentials
     */


    @Test(priority = 0,groups = {"smoke", "regression"},
            dataProvider = "registrationCredentials")
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
     * Failing the Registration Test with wrong confirm Password.
     * Expected error message
     */


    @Test(priority = 1,groups = {"sanity", "regression"},
            dataProvider = "registrationCredentials")
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

    @Test(priority = 3,groups = {"regression"},
            dataProvider = "registrationCredentials")
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
