package com.demo.nopcommerce.basepage;

/*
Created by SP
*/

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

    /*
     *    WebDriver assigned as static and placed in the Basepage and extended to the classes
     */
    public static WebDriver driver;

    /*    Constructor created for this class to
     *    To initialise and WebElements for PageFactory thru the driver.
     *    Configure the path for log4j properties for logging the records for the init elements
     */
    public BasePage() {

        PageFactory.initElements(driver, this);
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/java/com/demo/nopcommerce/resources/propertiesfile/log4j.properties");
    }
}
