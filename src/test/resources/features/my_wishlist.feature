Feature: My Wishlist functionality

  Background:
    Given the user is on the Magento homepage

  Scenario Outline: Adding products to a wishlist as a new user
    When the user clicks on the "Create an Account" link
    And the user fills in the required details and submits the form
    Then the user should be successfully registered and redirected to the My Account page
    When user selects <menu button> and <products category> and <products subcategory>
    Then user is navigated to product page
    When user adds any product from the products list to a Wishlist
    Then the added product to wishlist message appears
    And user can share their wishlist with emails
    Then user moves the product to the shopping cart


    Examples:
      | menu button | products category | products subcategory |
      | Women       | Tops              | Jackets              |


