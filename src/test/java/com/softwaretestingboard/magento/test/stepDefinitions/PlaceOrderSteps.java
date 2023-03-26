package com.softwaretestingboard.magento.test.stepDefinitions;

import com.softwaretestingboard.magento.main.pages.HomePage;
import com.softwaretestingboard.magento.main.pages.PlaceOrderPage;
import com.softwaretestingboard.magento.main.pages.RegistrationPage;
import com.softwaretestingboard.magento.test.driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class PlaceOrderSteps {

    private final WebDriver driver = DriverFactory.getDriver();
    private PlaceOrderPage placeOrderPage;

    private HomePage homePage;


    @Given("navigate to women's sections")
    public void navigateToWomenSSections() {
        placeOrderPage = new PlaceOrderPage(driver);
        placeOrderPage.navigateToWomenSSections();

    }
    @When("Select a product and add it to the cart")
    public void select_a_product_and_add_it_to_the_cart() {
        placeOrderPage.select_a_product_and_add_it_to_the_cart();

    }
    @And("Select product's XS size, Blue color, and {string} qty and then click add to cart")
    public void selectProductSSizeColorAndQtyAndThenClickAddToCart(String qty) {
        placeOrderPage.selectProductSSizeColorAndQtyAndThenClickAddToCart("2");
    }
    @Then("Click on shopping cart button and verify that the correct item was added to cart")
    public void click_on_shopping_cart_button_and_verify_that_the_correct_item_was_added_to_cart() throws InterruptedException {
        placeOrderPage.click_on_shopping_cart_button_and_verify_that_the_correct_item_was_added_to_cart();

    }
    @Given("Click on the Proceed to Checkout button to navigate to the checkout page")
    public void clickOnTheProceedToCheckoutButtonToNavigateToTheCheckoutPage() {
        placeOrderPage.clickOnTheProceedToCheckoutButtonToNavigateToTheCheckoutPage();
    }
    @Then("Verify that landed on check out page")
    public void verify_that_landed_on_check_out_page() {
        placeOrderPage.verify_that_landed_on_check_out_page();

    }
    @And("Fill out Shipping info that's provided on this page  and then click next btn.")
    public void fillOutShippingInfoThatSProvidedOnThisPageAndThenClickNextBtn() {
        placeOrderPage.fillOutShippingInfoThatSProvidedOnThisPageAndThenClickNextBtn();
    }
    @Then("Verify {string}  section and then click on {string} btn")
    public void verify_section_and_then_click_on_btn(String string, String string2) {

    }
    @Then("Verify {string} message")
    public void verify_message(String string) {

    }
    @Then("Verify that order number was provided")
    public void verify_that_order_number_was_provided() {

    }
    @Then("Verify email address shows as registered")
    public void verify_email_address_shows_as_registered() {

    }



}
