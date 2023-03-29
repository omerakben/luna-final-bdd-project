package com.softwaretestingboard.magento.test.base;

import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.softwaretestingboard.magento.main.utils.ConfigReader;
import com.softwaretestingboard.magento.test.driverFactory.DriverFactory;
import io.cucumber.java.Scenario;

public abstract class Base {
	
	protected ConfigReader configReader;
	protected Properties properties;
	protected DriverFactory driverFactory;
	protected WebDriver driver;
    
	public void getDriver() {
		 configReader = new ConfigReader();
	     properties = configReader.initializeProperties();
	     String browserName = configReader.getBrowserName();
	     driverFactory = new DriverFactory();
	     driver = driverFactory.initializeBrowser(browserName);
	     driver.get(configReader.getUrl());
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));   
	}
	
	public void getScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
        	String scenarioName = scenario.getName();
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            byte[] screenshotBytes = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png", scenarioName);
        }
	}
	
	public void tearDown() {
		 if(driver!=null){
	            driver.quit();
	            driver=null;
	        }
	}
}
