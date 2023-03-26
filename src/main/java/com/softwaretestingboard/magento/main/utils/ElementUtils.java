package com.softwaretestingboard.magento.main.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtils {

    private final WebDriver driver;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
    }

    // Click on an element after waiting for it to be clickable
    public void clickOnElement(WebElement element, long durationInSeconds) {
        WebElement webElement = waitForElement(element, durationInSeconds);
        webElement.click();
    }

    // Type text into an element after waiting for it to be clickable
    public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSeconds) {
        WebElement webElement = waitForElement(element, durationInSeconds);
        webElement.click();
        webElement.clear();
        webElement.sendKeys(textToBeTyped);
    }

    // Wait for an element to be clickable and return the element
    public WebElement waitForElement(WebElement element, long durationInSeconds) {
        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return webElement;
    }

    // Select an option from a dropdown element after waiting for it to be clickable
    public void selectOptionInDropdown(WebElement element, String dropDownOption, long durationInSeconds) {
        WebElement webElement = waitForElement(element, durationInSeconds);
        Select select = new Select(webElement);
        select.selectByVisibleText(dropDownOption);
    }

    // Accept an alert after waiting for it to be present
    public void acceptAlert(long durationInSeconds) {
        Alert alert = waitForAlert(durationInSeconds);
        alert.accept();
    }

    // Dismiss an alert after waiting for it to be present
    public void dismissAlert(long durationInSeconds) {
        Alert alert = waitForAlert(durationInSeconds);
        alert.dismiss();
    }

    // Wait for an alert to be present and return the alert
    public Alert waitForAlert(long durationInSeconds) {
        Alert alert = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            alert = wait.until(ExpectedConditions.alertIsPresent());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return alert;
    }

    // Mouse hover over an element and click it after waiting for it to be visible
    public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
        WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().build().perform();
    }

    // Wait for an element to be visible and return the element
    public  WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return webElement;
    }

    // Click on an element using JavaScript after waiting for it to be visible
    public void javaScriptClick(WebElement element, long durationInSeconds) {
        WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].click();", webElement);
    }

    // Type text into an element using JavaScript after waiting for it to be visible
    public void javaScriptType(WebElement element, long durationInSeconds, String textToBeTyped) {
        WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].value='" + textToBeTyped + "'", webElement);
    }

    // Get the text from an element after waiting for it to be clickable
    public String getTextFromElement(WebElement element, long durationInSeconds) {
        WebElement webElement = waitForElement(element, durationInSeconds);
        return webElement.getText();
    }

    // Check if an element is displayed after waiting for it to be visible
    public boolean displayStatusOfElement(WebElement element, long durationInSeconds) {
        try {
            WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
            return webElement.isDisplayed();
        } catch (Throwable e) {
            return false;
        }
    }
}
