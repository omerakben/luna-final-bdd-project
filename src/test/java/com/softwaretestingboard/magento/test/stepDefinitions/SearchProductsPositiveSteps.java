package com.softwaretestingboard.magento.test.stepDefinitions;

import com.softwaretestingboard.magento.main.pages.HomePage;
import com.softwaretestingboard.magento.main.pages.SearchResults;
import com.softwaretestingboard.magento.test.driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class SearchProductsPositiveSteps {
    private final static WebDriver driver = DriverFactory.getDriver();
    private HomePage homePage;
    private SearchResults searchResults;

    @Given("the user is on the Magento Luna homepage")
    public void the_user_is_on_the_magento_luna_homepage() {
        homePage = new HomePage(driver);
    }
    @When("user clicks on the search bar in the top right corner and search for {string}")
    public void user_clicks_on_the_search_bar_in_the_top_right_corner_and_search_for(String string) {
        homePage.searchForAProduct("tee");
    }

    @Then("user should be navigated to search results page")
    public void user_should_be_navigated_to_search_results_page() {
        searchResults = new SearchResults(driver);
        assertTrue(searchResults.isSearchPageVisible());

    }

    @Then("user should verify related search terms links and products listed by relevance")
    public void user_should_verify_related_search_terms_links_and_products_listed_by_relevance() {
        searchResults.isRelatedItemsValid("Tee");
        searchResults.verifyProductsAreRelatedToSearch("Tee");
    }
    @Then("user should be able to sort the products by price")
    public void user_should_be_able_to_sort_the_products_by_price() {
        searchResults.scrollToTop();
        searchResults.sortByPrice();
        searchResults.verifyPrices();
    }

    @Then("user should be able to sort the products by product name")
    public void user_should_be_able_to_sort_the_products_by_product_name() {
        searchResults.scrollToTop();
        searchResults.sortByName();
        assertTrue("products are not listed in descending order",searchResults.isDescendingSorted());
    }
}
