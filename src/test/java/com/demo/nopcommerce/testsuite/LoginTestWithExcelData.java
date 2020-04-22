package com.demo.nopcommerce.testsuite;
/*
Created by SP
*/

import com.demo.nopcommerce.excelutility.ExcelUtility;
import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.pages.LoginErrorMessagePage;
import com.demo.nopcommerce.pages.LoginPage;
import com.demo.nopcommerce.pages.WelcomeStorePage;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTestWithExcelData extends TestBase {
    /*
     * Using the excel data sheet data for the test data
     * Path subscribed for the excel sheet location
     */

    public static final String FilePath = System.getProperty("user.dir") + "/src/test/java/com/demo/nopcommerce/resources/testdata/NewDataSheet.xlsx/";
    HomePage homePage;
    LoginPage loginPage;
    WelcomeStorePage welcomeStorePage;
    LoginErrorMessagePage loginErrorMessagePage;
    SoftAssert sa = new SoftAssert();

    @BeforeClass(groups = {"sanity", "smoke", "regression"})
    public void setExcel() {
        // Tell the code about location of Excel file
        try {
            ExcelUtility.setExcelFile(FilePath, "LoginTests");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*
    Create object for the class in the setUpMethod
     */
    @BeforeMethod(groups = {"sanity", "smoke", "regression"})
    public void setUpMethod() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        welcomeStorePage = new WelcomeStorePage();
        loginErrorMessagePage = new LoginErrorMessagePage();
    }

    // Calling data information" and from Data Provider Class

    @DataProvider(name = "credentials")
    public Object[][] getData() {
        Object[][] data = ExcelUtility.getTestData("Login_Data");
        return data;
    }

    /*
     * Testing Login with data provided from Excel Sheet
     */

    @Test(priority = 0, groups = {"sanity", "regression"}, dataProvider = "credentials")
    public void verifyUserIsAbleToLoginSuccessfully(String email, String password) {
        homePage.clickOnLoginLink();
        loginPage.loginToApplication(email, password);
        sa.assertEquals(welcomeStorePage.getWelcomeStoreText(), "Welcome to our store");
        sa.assertAll();
    }
}
