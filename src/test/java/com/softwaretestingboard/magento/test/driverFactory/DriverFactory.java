package com.softwaretestingboard.magento.test.driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {

    private static WebDriver driver;

    public WebDriver initializeBrowser(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        } else {
            System.out.println("BROWSER NOT SUPPORTED");
        }
        return driver;
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

    public static WebDriver getDriver() {
        return driver;
    }
}
