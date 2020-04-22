package com.demo.nopcommerce.testsuite;

/*
Created by SP
*/

import com.demo.nopcommerce.pages.ComputersPage;
import com.demo.nopcommerce.pages.DesktopPage;
import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ComputerTest extends TestBase {
    /*
     * Object for various required classes called for running methods for the tests
     */

    HomePage homePage;
    ComputersPage computersPage;
    DesktopPage desktopPage ;
    SoftAssert sa = new SoftAssert();

    @BeforeMethod
    public void setUpMethod(){
        homePage = new HomePage();
        computersPage = new ComputersPage();
        desktopPage = new DesktopPage();

    }
    /*
     * Testing Navigate to Computers Page
     */

    @Test(priority = 0, groups = {"smoke", "sanity"})
    public void verifyUserAbleToNavigateToComputersPage() {
        homePage.mouseOverToComputers();
        sa.assertTrue(computersPage.getComputerText().contains("Computers"));
    }

    /*
     * Testing Navigate to Desktop Page via Computers Page
     */

    @Test(priority = 1, groups = {"sanity", "regression"})
    public void verifyUserIsAbleToNavigateToDesktopPageViaComputersPage() {
        homePage.mouseOverToComputers();
        computersPage.clickOnDesktopLink();
        sa.assertTrue(desktopPage.getDesktopText().contains("Desktops"));
        sa.assertAll();

    }

    //failing a test
    @Test(priority = 2, groups = {"sanity", "regression"})
    public void verifyUserFailedTestToNavigateToDesktopPage() {
        homePage.mouseOverToComputers();
        computersPage.clickOnDesktopLink();
        sa.assertEquals(desktopPage.getDesktopText(), "Desk");
        sa.assertAll();
    }

}

