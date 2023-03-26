Feature: Place order functionality

  Scenario: Order Placement Functionality

    Given navigate to women's sections
    When Select a product and add it to the cart
    And Select product's XS size, Blue color, and "2" qty and then click add to cart
    Then Click on shopping cart button and verify that the correct item was added to cart
    Given Click on the Proceed to Checkout button to navigate to the checkout page
    Then Verify that landed on check out page
    And Fill out Shipping info that's provided on this page  and then click next btn.
    Then Verify "Ship to"  section and then click on "Place Order" btn
    Then Verify "Thank you for your purchase!" message
    Then Verify that order number was provided
    Then Verify email address shows as registered







