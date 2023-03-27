package com.softwaretestingboard.magento.main.pages;

import com.softwaretestingboard.magento.main.utils.CommonUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegistrationPage {

    WebDriver driver;

    @FindBy(id = "firstname")
    WebElement firstName;

    @FindBy(id = "lastname")
    WebElement lastName;

    @FindBy(id = "email_address")
    WebElement emailAddress;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "password-confirmation")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[@title='Create an Account']")
    WebElement createAccountButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void registerUser() {
        firstName.sendKeys(CommonUtils.generateRandomFirstName());
        lastName.sendKeys(CommonUtils.generateRandomLastName());
        emailAddress.sendKeys(CommonUtils.generateRandomEmailAddress());

        //Storing the password in a variable for later use.
        String randomPassword = CommonUtils.generateRandomPassword();
        password.sendKeys(randomPassword);
        confirmPassword.sendKeys(randomPassword);

        createAccountButton.click();
    }

    public boolean isRegistrationSuccessful() {
        return driver.getTitle().contains("My Account");
    }
}

