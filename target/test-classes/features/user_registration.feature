Feature: User Registration

  Scenario: User Registration (Positive Test Case)
    Given the user is on the Magento homepage
    When the user clicks on the "Create an Account" link
    And the user fills in the required details and submits the form
    Then the user should be successfully registered and redirected to the My Account page