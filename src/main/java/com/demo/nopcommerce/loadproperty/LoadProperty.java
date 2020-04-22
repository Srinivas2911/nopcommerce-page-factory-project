package com.demo.nopcommerce.loadproperty;

/*
Created by SP
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/*
 * Calling the properties from the config properties to the Load Property Class.
 * Load property class is called as object for access the config.properties file
 * for accessing the various properties like baseURL, browser, etc.
 *
 * FileInputStream access the "user.dir"+ config.properties file.
 */

public class LoadProperty {
    String projectPath = System.getProperty("user.dir");

    static Properties prop;
    static FileInputStream input;

    public String getProperty(String key) {
        prop = new Properties();

        try {
            input = new FileInputStream(projectPath + "/src/test/java/com/demo/nopcommerce/resources/propertiesfile/config.properties/");
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }


}
