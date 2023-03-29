package com.softwaretestingboard.magento.test.stepDefinitions;

import java.time.Duration;
import java.util.Properties;

import com.softwaretestingboard.magento.main.utils.ConfigReader;
import com.softwaretestingboard.magento.test.driverFactory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private ConfigReader configReader;
    private Properties properties;
    private DriverFactory driverFactory;
    private WebDriver driver;

    // Load the configuration properties
    @Before(order = 0)
    public void getPropertyValues() {
        configReader = new ConfigReader();
        properties = configReader.initializeProperties();
    }

    // Launch the browser and navigate to the URL
    @Before(order = 1)
    public void launchBrowser() {
        String browserName = configReader.getBrowserName();
        driverFactory = new DriverFactory();
        driver = driverFactory.initializeBrowser(browserName);
        driver.get(configReader.getUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


    //Close the browser and take a screenshot if the scenario fails
    @After
    public void closeBrowser(Scenario scenario) {
        String scenarioName = scenario.getName();
        if (scenario.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            byte[] screenshotBytes = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png", scenarioName);
        }
        driver.quit();
    }

}
