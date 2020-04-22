package com.demo.nopcommerce.browserselector;

/*
Created by SP
*/

import com.demo.nopcommerce.basepage.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

// Browser Selector  Class extends to BasePage in search of the Webdriver

public class BrowserSelector extends BasePage {
    /* projectPath as String is assigned for all project to choose local user directory
     * thru the ("user*dir")
     */
    String projectPath = System.getProperty("user.dir");

    //Logger for logging the reports for the Browser into log4j logs.
    private static final Logger log = Logger.getLogger(BrowserSelector.class.getName());

    // browser choosing and logging browser launch in reportNg and the log4j reports
    public void selectBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
            Reporter.log("Launching Chrome Browser");
            log.info("Launching Chrome Browser");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver.exe");
            Reporter.log("Launching Chrome Browser");
            log.info("Launching Chrome Browser");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", projectPath + "/drivers/IEDriverServer.exe");
            Reporter.log("Launching Chrome Browser");
            log.info("Launching Chrome Browser");
            driver = new InternetExplorerDriver();
        } else {
            Reporter.log("Browser Not Launched");
            log.info("Browser Not Launched");
            System.out.println("Wrong browser name");
        }
    }
}
