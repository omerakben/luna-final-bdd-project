package com.softwaretestingboard.magento.test.stepDefinitions;

import com.softwaretestingboard.magento.test.base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Base {

	@Before
    public void launchBrowser() {
    	getDriver();
    }


    //Close the browser and take a screenshot if the scenario fails
    @After
    public void closeBrowser(Scenario scenario) {
    	getScreenshot(scenario);
    	tearDown();
    }
}
