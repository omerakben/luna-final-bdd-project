package com.softwaretestingboard.magento.main.pages;

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

    public void registerUser(String fName, String lName, String email, String pass, String confirmPass) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        emailAddress.sendKeys(email);
        password.sendKeys(pass);
        confirmPassword.sendKeys(confirmPass);
        createAccountButton.click();
    }

    public boolean isRegistrationSuccessful() {
        return driver.getTitle().contains("My Account");
    }
}

