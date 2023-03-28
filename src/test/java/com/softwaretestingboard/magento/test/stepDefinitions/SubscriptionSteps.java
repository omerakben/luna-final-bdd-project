package com.softwaretestingboard.magento.test.stepDefinitions;

import com.softwaretestingboard.magento.main.pages.SubscriptionPage;
import com.softwaretestingboard.magento.test.driverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SubscriptionSteps {

    private final WebDriver driver =  DriverFactory.getDriver();
    private SubscriptionPage subscriptionPage;

    @When("Enter  email address in input")
    public void enterEmailAddressInInput() {
        subscriptionPage = new SubscriptionPage(driver);
        subscriptionPage.enterEmailAddress();
    }

    @Then("Click Subscribe button")
    public void clickSubscribeButton() {
        subscriptionPage.clickSubscribeBtn();

    }
    @Then("Verify success message Thank you for your subscription. is visible")
    public void verify_success_message_thank_you_for_your_subscription_is_visible() {
        subscriptionPage.verifySuccessMsg();
    }




}
