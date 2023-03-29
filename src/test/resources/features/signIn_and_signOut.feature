Feature: User Sign in and Sign out

  Scenario: User Sign in and Sign out (Positive Test Case)
    Given user is on the Magento homepage
    When the user clicks on the Login in button
    Then user is on the Login page
    And user enters "roni_cost1@example.com" and "roni_cost1" and clicks on sign in button
    When user is on the Home page should be able to see his or her full name in the welcome message in the top right corner
    And user should be able to clicks on down arrows next to his or her name and click “My Account” option under his or her name.
    And user should be able to clicks on down arrows next to his or her name and sign out