package com.softwaretestingboard.magento.main.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompareProductsPage extends BasePage {

    private HashMap<String, String> item;

    @FindBy(linkText = "Print This Page")
    private WebElement printThisPage;

    @FindBy(xpath = "//a[contains(@class,'delete')]")
    private List<WebElement> deleteItemBtns;

    @FindBy(xpath = "(//tbody)[1]//img")
    private List<WebElement> productsImgs;

    @FindBy(xpath = "(//tbody)[1]//strong")
    private List<WebElement> productsNames;

    @FindBy(xpath = "(//tbody)[1]//span[contains(@id,'price')]")
    private List<WebElement> productsPrices;

    @FindBy(xpath = "(//tbody)[2]//p[not(contains(text(),'•'))]")
    private List<WebElement> descriptions;

    @FindBy(xpath = "//div[contains(text(),'You have no items to compare.')]")
    private WebElement noItemsMsg;

    public CompareProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getPrintThisPage() {
        return printThisPage;
    }

    public WebElement getNoItemsMsg() {
        return noItemsMsg;
    }

    public List<WebElement> getDeleteItemBtns() {
        return deleteItemBtns;
    }

    public boolean checkCompareProducts(Set<HashMap<String, String>> allAddedItems, List<HashMap<String, String>> comparingItems) {
        return allAddedItems.equals(new HashSet<>(comparingItems));
    }

    public List<HashMap<String, String>> getComparingItems() {
        List<HashMap<String, String>> comparingItems = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < productsNames.size(); i++) {
            item = new HashMap<String, String>();
            item.put("image", productsImgs.get(i).getAttribute("src").substring(productsImgs.get(i).getAttribute("src").lastIndexOf("/")));
            item.put("name", productsNames.get(i).getText());
            item.put("price", productsPrices.get(i).getText());
            comparingItems.add(item);
        }
        return comparingItems;
    }

}
