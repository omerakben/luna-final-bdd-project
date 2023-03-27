package com.softwaretestingboard.magento.test.stepDefinitions;

import com.softwaretestingboard.magento.main.pages.HomePage;
import com.softwaretestingboard.magento.main.pages.SearchResults;
import com.softwaretestingboard.magento.test.driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class SearchProductsNegativeSteps {
    private final static WebDriver driver = DriverFactory.getDriver();

    private HomePage homePage;

    private SearchResults searchResults;

    @Given("user clicks on the search bar in the top right corner and searches for {string}")
    public void user_clicks_on_the_search_bar_in_the_top_right_corner_and_searches_for(String string) {
        homePage = new HomePage(driver);
        homePage.searchForAProduct("fishing rod");
    }

    @Then("user should be navigated to search results page for irrelevant item")
    public void user_should_be_navigated_to_search_results_page_for_irrelevant_item() {
        searchResults = new SearchResults(driver);
        assertTrue(searchResults.isSearchPageVisible());
    }

    @Then("user should be able to see warning text")
    public void user_should_be_able_to_see_warning_text() {
        assertTrue(searchResults.isWarningTextVisible());
    }

}
