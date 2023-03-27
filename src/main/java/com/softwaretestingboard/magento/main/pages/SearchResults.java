package com.softwaretestingboard.magento.main.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchResults {
    private WebDriver driver;

    private Select select;

    public JavascriptExecutor js;

    public SearchResults(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class='item search']/strong[contains(text(), 'Search results for:')]")
    private WebElement searchResultsStrongTxt;

    @FindBy(xpath = "//a[@class='product-item-link']")
    private List<WebElement> productItemLinks;

    @FindBy(xpath = "(//strong[contains(@class, 'product name')])[1]/a")
    private WebElement firstProductTxt;
    @FindBy(xpath = "(//strong[contains(@class, 'product name')])/a")
    private List<WebElement> productTitles;
    @FindBy(xpath = "(//label[text()='Sort By']/following-sibling::select[@id='sorter'])[1]")
    private WebElement sortByDropdown;
    @FindBy(xpath = "//span[@class='price']")
    private List<WebElement> productPricesSpan;
    @FindBy(xpath = "//dl/dt/following-sibling::dd")
    private List<WebElement> relatedItemsList;
    @FindBy(xpath = "//strong[contains(@class, 'product name')]/a")
    private List<WebElement> productNames;

    @FindBy(xpath = "//div[@class='message notice']/div[contains(text(), 'Your search returned no results.')]")
    private WebElement warningTextBox;

    public void scrollToTop() {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", sortByDropdown);
    }

    public boolean isSearchPageVisible() {
        return driver.getCurrentUrl().contains("catalogsearch/result/?q=");
    }

    public void verifyProductsAreRelatedToSearch(String productName) {
        js = (JavascriptExecutor) driver;
        for (int i = 0; i < productTitles.size(); i++) {
            js.executeScript("window.scrollBy(0,110)", "");
            assertTrue("correct products are not displayed",
                    productTitles.get(i).getText().contains(productName));
            js.executeScript("window.scrollBy(0,310)", "");
        }
    }

    public void isRelatedItemsValid(String productName) {
        for (int i = 0; i < relatedItemsList.size(); i++) {
            assertTrue("related items does not match the keyword",
                    relatedItemsList.get(i).getText().contains(productName.toLowerCase()));
        }
    }

    public void sortByPrice() {
        select = new Select(sortByDropdown);
        select.selectByValue("price");
    }

    public void verifyPrices() {
        js = (JavascriptExecutor) driver;
        for (int i = 0; i < productPricesSpan.size() - 1; i++) {
            js.executeScript("window.scrollBy(0,110)", "");
            String priceText = productPricesSpan.get(i).getText().substring(1);
            String nextPriceText = productPricesSpan.get(i + 1).getText().substring(1);
            assertTrue(Float.parseFloat(priceText) >= Float.parseFloat(nextPriceText));
            js.executeScript("window.scrollBy(0,310)", "");
        }
    }

    public void sortByName() {
        select = new Select(sortByDropdown);
        select.selectByValue("name");
    }

    public boolean isDescendingSorted() {
        js = (JavascriptExecutor) driver;
        for (int i = 1; i < productNames.size(); i++) {
            js.executeScript("window.scrollBy(0,110)", "");
            String prev = productNames.get(i - 1).getText().trim();
            String curr = productNames.get(i).getText().trim();
            if (prev.compareTo(curr) < 0) {
                return false;
            }
            js.executeScript("window.scrollBy(0,310)", "");
        }
        return true;
    }

    public boolean isWarningTextVisible() {
        String warningTxt = "Your search returned no results";
        System.out.println(warningTextBox.getText());
        return warningTextBox.getText().contains(warningTxt);
    }

}
