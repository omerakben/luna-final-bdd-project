Feature: Compare products

  Background:
    Given the user is on the Magento homepage

  Scenario Outline: Compare products from the same category in comparison list as a new user
    When the user clicks on the "Create an Account" link
    And the user fills in the required details and submits the form
    Then the user should be successfully registered and redirected to the My Account page
    When user selects <menu button> and <products category> and <products subcategory>
    Then user is navigated to product page
    When user adds any product from the products list to compare
    Then the added product to compare message is appears
    And the compare products link at the header is appears and quantity is match with added items
    When user adds any product from the products list to compare
    Then the added product to compare message is appears
    And the compare products link at the header is appears and quantity is match with added items
    When user adds any product from the products list to compare
    Then the added product to compare message is appears
    And the compare products link at the header is appears and quantity is match with added items
    When user clicks compare products link at the header
    Then user is navigated to the compare products page
    And the compare products page contains all the added products

    Examples:
      | menu button | products category | products subcategory |
      | Women       | Tops              | Jackets              |

  Scenario Outline: Compare products from the same category in comparison list as a visitor
    When user selects <menu button> and <products category> and <products subcategory>
    Then user is navigated to product page
    When user adds any product from the products list to compare
    Then the added product to compare message is appears
    And the compare products link at the header is appears and quantity is match with added items
    When user adds any product from the products list to compare
    Then the added product to compare message is appears
    And the compare products link at the header is appears and quantity is match with added items
    When user adds any product from the products list to compare
    Then the added product to compare message is appears
    And the compare products link at the header is appears and quantity is match with added items
    When user clicks compare products link at the header
    Then user is navigated to the compare products page
    And the compare products page contains all the added products

    Examples:
      | menu button | products category | products subcategory |
      | Women       | Bottoms           | Pants                |

  Scenario Outline: Compare products from the same category in comparison list as an existing user
    When the user clicks on the "Sign In" link
    And user enters "someemailfor@test.com" and "Somepassword123!" and clicks sign in button
    Then the user should be successfully redirected to the My Account page
    When user selects <menu button> and <products category> and <products subcategory>
    Then user is navigated to product page
    When user adds any product from the products list to compare
    Then the added product to compare message is appears
    And the compare products link at the header is appears and quantity is match with added items
    When user adds any product from the products list to compare
    Then the added product to compare message is appears
    And the compare products link at the header is appears and quantity is match with added items
    When user adds any product from the products list to compare
    Then the added product to compare message is appears
    And the compare products link at the header is appears and quantity is match with added items
    When user clicks compare products link at the header
    Then user is navigated to the compare products page
    And the compare products page contains all the added products
    And user delete all comparing items

    Examples:
      | menu button | products category | products subcategory |
      | Men         | Bottoms           | Pants                |

  Scenario Outline: Add products from the same category to the comparison list as a visitor and then compare it as a new user
    When user selects <menu button> and <products category> and <products subcategory>
    Then user is navigated to product page
    When user adds any product from the products list to compare
    Then the added product to compare message is appears
    And the compare products link at the header is appears and quantity is match with added items
    When user adds any product from the products list to compare
    Then the added product to compare message is appears
    And the compare products link at the header is appears and quantity is match with added items
    When user adds any product from the products list to compare
    Then the added product to compare message is appears
    And the compare products link at the header is appears and quantity is match with added items
    When the user clicks on the "Create an Account" link
    And the user fills in the required details and submits the form
    Then the user should be successfully registered and redirected to the My Account page
    When user clicks compare products link at the header
    Then user is navigated to the compare products page
    And the compare products page contains all the added products

    Examples:
      | menu button | products category | products subcategory |
      | Women       | Tops              | Jackets              |

  Scenario Outline: Add products from the same category to the comparison list as a visitor and then compare it after signing in
    When user selects <menu button> and <products category> and <products subcategory>
    Then user is navigated to product page
    When user adds any product from the products list to compare
    Then the added product to compare message is appears
    And the compare products link at the header is appears and quantity is match with added items
    When user adds any product from the products list to compare
    Then the added product to compare message is appears
    And the compare products link at the header is appears and quantity is match with added items
    When user adds any product from the products list to compare
    Then the added product to compare message is appears
    And the compare products link at the header is appears and quantity is match with added items
    When the user clicks on the "Sign In" link
    And user enters "someemailfor@test.com" and "Somepassword123!" and clicks sign in button
    Then the user should be successfully redirected to the My Account page
    When user clicks compare products link at the header
    Then user is navigated to the compare products page
    And the compare products page contains all the added products
    And user delete all comparing items

    Examples:
      | menu button | products category | products subcategory |
      | Women       | Tops              | Jackets              |
