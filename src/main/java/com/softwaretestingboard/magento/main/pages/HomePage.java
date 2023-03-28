package com.softwaretestingboard.magento.main.pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(linkText = "Create an Account")
    WebElement createAccountLink;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement searchInputField;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToRegistrationPage() {
        createAccountLink.click();
    }

    public void searchForAProduct(String product) {
        searchInputField.sendKeys(product + Keys.ENTER);
    }
    public boolean isHomePageDisplayed() {
        String expectedUrl = "https://magento.softwaretestingboard.com/";
        return driver.getCurrentUrl().equals(expectedUrl);
    }


    // Method to click on the "Contact Us" link on the home page
    public void clickContactUsLink() {
        driver.findElement(By.linkText("Contact Us")).click();
    }
}
