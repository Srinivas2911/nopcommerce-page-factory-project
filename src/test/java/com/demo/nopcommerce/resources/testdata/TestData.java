package com.demo.nopcommerce.resources.testdata;

/*
Created by SP
*/

import org.testng.annotations.DataProvider;

/*
 * Test data Class provided the various sample user data, required to run the tests
 * like Login Tests / Registration Tests / usernames / passwords etc.
 */
public class TestData {

    /*
     * returns two dimensional object
     *  pass all the data
     */

    @DataProvider(name = "validCredentials")
    public Object[][] validcredentials() {
        return new Object[][]{
                {" jamesbond@aol.com", "bond123"},
                {" Roger123@gmail.com", "Roger1980"}
        };

    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] data() {
        return new Object[][]{
                {" jamesbond@aol.com", "bondage123"},
                {" Roger123@gmail.com", "roger123"},

        };
    }

    @DataProvider(name = "wrongCredentials")
    public Object[][] data1() {
        return new Object[][]{
                {" jamesbondaol.com", "bond123"},
                {" Roger123gmail.com", "Roger1980"},
        };
    }

    @DataProvider(name = "registrationCredentials")
    public Object[][] data2() {
        return new Object[][]{
                {"Roger", "Moore", "1", "January", "1980", "Roger Moore International"},
                {"James", "Bond", "1", "April", "1970", "James Bond International"},
                {"Test", "Case", "1", "May", "1990", "Advance Testing"}
        };
    }

    }

