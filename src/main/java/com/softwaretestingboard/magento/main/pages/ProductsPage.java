package com.softwaretestingboard.magento.main.pages;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.softwaretestingboard.magento.main.utils.ElementUtils;

public class ProductsPage extends BasePage {

    private Set<HashMap<String, String>> allAddedItems = new HashSet<HashMap<String, String>>();
    private HashMap<String, String> addedItem;
    ElementUtils utils = new ElementUtils(driver);

    @FindBy(xpath = "//div[contains(@class,'products-grid')]//ol[contains(@class,'product-items')]")
    private WebElement productsTable;

    @FindBy(xpath = "//div[contains(@class,'products-grid')]//ol[contains(@class,'product-items')]//li")
    private List<WebElement> productsItems;

    @FindBy(xpath = "//div[contains(@class,'products-grid')]//ol[contains(@class,'product-items')]//li//img")
    private List<WebElement> productsImgs;

    @FindBy(xpath = "//div[contains(@class,'products-grid')]//ol[contains(@class,'product-items')]//li//strong")
    private List<WebElement> productsNames;

    @FindBy(xpath = "//div[contains(@class,'products-grid')]//ol[contains(@class,'product-items')]//li//span[@class='price']")
    private List<WebElement> productsPrices;

    @FindBy(xpath = "//a[contains(@class,'tocompare')]")
    private List<WebElement> addToCompareBtns;

    @FindBy(xpath = "//div[contains(@class,'message-success')]")
    private WebElement addedToCompareMsg;

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getProductsTable() {
        return productsTable;
    }

    public WebElement getAddedToCompareMsg() {
        return addedToCompareMsg;
    }

    public HashMap<String, String> getAddedItem() {
        return addedItem;
    }

    public Set<HashMap<String, String>> getAllAddedItems() {
        return allAddedItems;
    }

    public void addRandomProductToCompare() {
        int index = ElementUtils.randomIntBetween(1, productsItems.size()) - 1;
        addedItem = new HashMap<>();
        utils.mouseHover(productsItems.get(index), 5);
        addedItem.put("image", productsImgs.get(index).getAttribute("src").substring(productsImgs.get(index).getAttribute("src").lastIndexOf("/")));
        addedItem.put("name", productsNames.get(index).getText());
        addedItem.put("price", productsPrices.get(index).getText());
        allAddedItems.add(addedItem);
        addToCompareBtns.get(index).click();
    }

}
