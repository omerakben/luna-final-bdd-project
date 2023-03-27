package com.softwaretestingboard.magento.test.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/softwaretestingboard/magento/test/stepDefinitions"},
        publish = true,
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty"}
)
public class TestRunner {

}
