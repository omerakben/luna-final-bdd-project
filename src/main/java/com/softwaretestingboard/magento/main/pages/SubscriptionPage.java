package com.softwaretestingboard.magento.main.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.*;

public class SubscriptionPage {

    WebDriver driver;
    Faker faker;

    public SubscriptionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy (xpath = "//input[@id='newsletter']")
    private WebElement emailSubscribeInput;

    @FindBy (xpath = "//span[text()='Subscribe']")
    private WebElement subscribeBtn;

    @FindBy (xpath = "//div[text() = 'Thank you for your subscription.']")
    private WebElement successMsg;

    public void enterEmailAddress () {
        faker = new Faker();
        String emailAddress = faker.internet().emailAddress();
       emailSubscribeInput.sendKeys(emailAddress);


    }
    public void clickSubscribeBtn () {
        subscribeBtn.click();
    }

    public void verifySuccessMsg () {
     assertTrue(successMsg.isDisplayed());
    }

}




