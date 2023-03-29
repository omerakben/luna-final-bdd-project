package com.softwaretestingboard.magento.test.stepDefinitions;

import com.softwaretestingboard.magento.main.pages.*;
import com.softwaretestingboard.magento.main.utils.ElementUtils;
import com.softwaretestingboard.magento.test.driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class MyWishlistSteps {
    private final WebDriver driver = DriverFactory.getDriver();

    ProductsPage productsPage;
    ElementUtils elementUtils;
    MyWishListPage myWishListPage;

    PlaceOrderPage placeOrderPage;


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

    @And("user can share their wishlist with emails")
    public void userCanShareTheirWishlistWithEmails() {
    myWishListPage.shareWishlist();
    }

    @Then("user moves the product to the shopping cart")
    public void userMovesTheProductToTheShoppingCart()  {
        placeOrderPage=new PlaceOrderPage(driver);
        placeOrderPage.select_a_product_and_add_it_to_the_cart();
        myWishListPage.selectProductDetails();
    }
}
