Feature: Search product

  Background:
    Given the user is on the Magento Luna homepage

  Scenario: Search for a product (Positive Case)
    Given user clicks on the search bar in the top right corner and search for "tee"
    Then user should be navigated to search results page
    And user should verify related search terms links and products listed by relevance
    Then user should be able to sort the products by price
    And user should be able to sort the products by product name

  Scenario: Search for a product(Negative Case)
    Given user clicks on the search bar in the top right corner and searches for "fishing rod"
    Then user should be navigated to search results page for irrelevant item
    And user should be able to see warning text