package com.softwaretestingboard.magento.main.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    // Load the configuration properties from file
    public Properties initializeProperties() {
        prop = new Properties();
        File proFile = new File("src/test/resources/config/config.properties");

        try {
            FileInputStream fis = new FileInputStream(proFile);
            prop.load(fis);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return prop;
    }

    // Get the browser name from the configuration properties
    public String getBrowserName() {

        return prop.getProperty("browserName");
    }

    // Get the URL from the configuration properties
    public String getUrl() {

        return prop.getProperty("url");
    }

    public void setProperty(String keyName, String value) {
        prop = new Properties();
        this.prop.setProperty(keyName, value);
    }

    public String getProperty(String keyName) {

        return prop.getProperty(keyName);
    }

}
