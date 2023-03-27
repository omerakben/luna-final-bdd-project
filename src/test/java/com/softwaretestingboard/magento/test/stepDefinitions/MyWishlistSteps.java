package com.softwaretestingboard.magento.test.stepDefinitions;

import com.softwaretestingboard.magento.main.pages.*;
import com.softwaretestingboard.magento.main.utils.ElementUtils;
import com.softwaretestingboard.magento.test.driverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class MyWishlistSteps {
    private final WebDriver driver = DriverFactory.getDriver();

    ProductsPage productsPage;
    ElementUtils elementUtils;
    MyWishListPage myWishListPage;


    @When("user adds any product from the products list to a Wishlist")
    public void userAddsAnyProductFromTheProductsListToAWishlist() {
        myWishListPage = new MyWishListPage(driver);
        myWishListPage.addRandomProductToWishlist();
    }

    @Then("the added product to wishlist message appears")
    public void theAddedProductToWishlistMessageAppears() {
        elementUtils = new ElementUtils(driver);
        productsPage = new ProductsPage(driver);
        elementUtils.waitForVisibilityOfElement(myWishListPage.showAddedToWishlistmsg(), 5);
        assertTrue(myWishListPage.showAddedToWishlistmsg().getText().contains(myWishListPage.getAddedItem().get("name")));
    }
}
