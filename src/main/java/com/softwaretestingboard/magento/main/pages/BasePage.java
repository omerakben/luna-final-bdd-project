package com.softwaretestingboard.magento.main.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.softwaretestingboard.magento.main.utils.ElementUtils;

public class BasePage {

    protected WebDriver driver;
    protected String xpath;
    protected ElementUtils utils;

    @FindBy(xpath = "//div[contains(@class,'header')]//img")
    protected WebElement logoImg;

    @FindBy(xpath = "//li[contains(@class,'customer-welcome')]//button")
    protected WebElement userDropdownMenu;

    @FindBy(linkText = "Sign Out")
    protected WebElement signOutBtn;

    @FindBy(xpath = "//div[contains(@class,'header')]//a[contains(@class,'compare')]")
    protected WebElement compareProductsLnk;

    @FindBy(xpath = "//div[contains(@class,'header')]//input[@id='search']")
    protected WebElement searchInp;

    @FindBy(xpath = "//button[contains(@class,'search')]")
    protected WebElement searchBtn;

    @FindBy(xpath = "//div[contains(@class,'header')]//a[contains(@class,'cart')]")
    protected WebElement cartBtn;

    @FindBy(id = "ui-id-1")
    protected WebElement miniCartMenu;

    @FindBy(id = "btn-minicart-close")
    protected WebElement miniCartMenuCloseBtn;

    @FindBy(id = "top-cart-btn-checkout")
    protected WebElement miniCartProceedToCheckoutBtn;

    @FindBy(xpath = "//ol[@id='mini-cart']//li")
    protected List<WebElement> miniCartItems;

    @FindBy(xpath = "//ol[@id='mini-cart']//a[contains(@class,'edit')]")
    protected List<WebElement> miniCartItemEditBtns;

    @FindBy(xpath = "//ol[@id='mini-cart']//a[contains(@class,'delete')]")
    protected List<WebElement> miniCartItemDeleteBtns;

    @FindBy(xpath = "//a[contains(@class,'viewcart')]")
    protected List<WebElement> miniCartViewItemsBtn;

    @FindBy(xpath = "//ul[@id='ui-id-2']//li")
    protected List<WebElement> headerMenuBtns;

    @FindBy(xpath = "//div[contains(@class,'footer content')]//li")
    protected List<WebElement> footerMenuBtns;

    @FindBy(id = "newsletter")
    protected WebElement subscribeInp;

    @FindBy(xpath = "//button[contains(@class,'subscribe')]")
    protected WebElement subscribeBtn;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getUserDropdownMenu() {
        return userDropdownMenu;
    }

    public WebElement getSignOutBtn() {
        return signOutBtn;
    }

    public WebElement getCompareProductsLnk() {
        return compareProductsLnk;
    }

    public String getHeaderMenuBtn(String nameBtn, String productsCat, String productsSubcat) {
        return xpath = "//ul[@id='ui-id-2']//li[contains(.,'" + nameBtn + "')]//ul[contains(.,'" + productsCat + "')]//a[contains(.,'" + productsSubcat + "')]";
    }

    public String getHeaderMenuBtn(String nameBtn, String productsCat) {
        return xpath = "//ul[@id='ui-id-2']//li[contains(.,'" + nameBtn + "')]//a[contains(.,'" + productsCat + "')]";
    }

    public String getHeaderMenuBtn(String nameBtn) {
        return xpath = "//ul[@id='ui-id-2']//a[contains(.,'" + nameBtn + "')]";
    }

    public String getFooterMenuBtn(String nameBtn) {
        return xpath = "//div[contains(@class,'footer content')]//a[contains(text(),'" + nameBtn + "')]";
    }

}
