package com.softwaretestingboard.magento.main.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(linkText = "Create an Account")
    WebElement createAccountLink;
    
    @FindBy(linkText = "Sign In")
    WebElement signInAccountLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToRegistrationPage() {
        createAccountLink.click();
    }
    
    public void navigateToSignInPage() {
    	signInAccountLink.click();
    }
}
