package com.softwaretestingboard.magento.test.stepDefinitions;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.softwaretestingboard.magento.main.pages.BasePage;
import com.softwaretestingboard.magento.main.pages.CompareProductsPage;
import com.softwaretestingboard.magento.main.pages.ProductsPage;
import com.softwaretestingboard.magento.main.pages.RegistrationPage;
import com.softwaretestingboard.magento.main.pages.SignInPage;
import com.softwaretestingboard.magento.main.utils.ElementUtils;
import com.softwaretestingboard.magento.test.driverFactory.DriverFactory;

import io.cucumber.java.en.*;

public class CompareProductsSteps {

    private final WebDriver driver = DriverFactory.getDriver();
    BasePage basePage;
    ProductsPage productsPage;
    ElementUtils elementUtils;
    CompareProductsPage compareProductsPage;
    RegistrationPage registrationPage;
    SignInPage signInPage;

    @When("^user selects (.*) and (.*) and (.*)$")
    public void user_selects_menu_button_and_products_category_and_products_subcategory(String menuBtn, String productsCategory, String productsSubcategory) {
        basePage = new BasePage(driver);
        elementUtils = new ElementUtils(driver);
        elementUtils.mouseHover(driver.findElement(By.xpath(basePage.getHeaderMenuBtn(menuBtn))), 0);
        elementUtils.mouseHover(driver.findElement(By.xpath(basePage.getHeaderMenuBtn(menuBtn, productsCategory))), 0);
        elementUtils.mouseHoverAndClick(driver.findElement(By.xpath(basePage.getHeaderMenuBtn(menuBtn, productsCategory, productsSubcategory))), 0);
    }

    @Then("user is navigated to product page")
    public void user_is_navigated_to_product_page() {
        productsPage = new ProductsPage(driver);
        elementUtils.waitForVisibilityOfElement(productsPage.getProductsTable(), 5);
    }

    @When("user adds any product from the products list to compare")
    public void user_adds_any_product_from_the_products_list_to_compare() {
        productsPage.addRandomProductToCompare();
    }

    @Then("the added product to compare message is appears")
    public void the_added_product_to_compare_message_is_appears() {
        elementUtils.waitForVisibilityOfElement(productsPage.getAddedToCompareMsg(), 5);
        assertTrue(productsPage.getAddedToCompareMsg().getText().contains(productsPage.getAddedItem().get("name")));
    }

    @Then("the compare products link at the header is appears and quantity is match with added items")
    public void the_compare_products_link_at_the_header_is_appears_and_quantity_is_match_with_added_items() {
        elementUtils.waitForVisibilityOfElement(productsPage.getCompareProductsLnk(), 5);
        String num = Integer.toString(productsPage.getAllAddedItems().size());
        assertTrue(productsPage.getCompareProductsLnk().getText().contains(num));
    }

    @When("user clicks compare products link at the header")
    public void user_clicks_compare_products_link_at_the_header() {
        productsPage.getCompareProductsLnk().click();
    }

    @Then("user is navigated to the compare products page")
    public void user_is_navigated_to_the_compare_products_page() {
        compareProductsPage = new CompareProductsPage(driver);
        elementUtils.waitForVisibilityOfElement(compareProductsPage.getPrintThisPage(), 5);
        assertTrue(compareProductsPage.getPrintThisPage().isEnabled());
    }

    @Then("the compare products page contains all the added products")
    public void the_compare_products_page_contains_all_the_added_products() {
        assertTrue(compareProductsPage.checkCompareProducts(productsPage.getAllAddedItems(), compareProductsPage.getComparingItems()));
    }

    @When("user enters {string} and {string} and clicks sign in button")
    public void user_enters_and_and_clicks_sign_in_button(String string, String string2) {
        signInPage = new SignInPage(driver);
        signInPage.signIn(string, string2);
    }

    @Then("the user should be successfully redirected to the My Account page")
    public void the_user_should_be_successfully_redirected_to_the_my_account_page() {
        basePage = new BasePage(driver);
        elementUtils = new ElementUtils(driver);
        basePage.getUserDropdownMenu().click();
        elementUtils.waitForVisibilityOfElement(basePage.getSignOutBtn(), 5);
        assertTrue(basePage.getSignOutBtn().isEnabled());
    }

    @And("user delete all comparing items")
    public void user_delete_all_comparing_items() {
        try {
            while (compareProductsPage.getDeleteItemBtns().size() > 0) {
                compareProductsPage.getDeleteItemBtns().get(0).click();
                elementUtils.waitForVisibilityOfElement(driver.findElement(By.xpath("//span[contains(text(),'OK')]")), 5);
                driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
                Thread.sleep(2500);
                if (driver.getPageSource().contains("You have no items to compare."))
                    break;
            }
        } catch (Exception e) {
        }
    }
}
