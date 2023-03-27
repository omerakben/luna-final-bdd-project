Feature: Contact us
  Background:
    Given User is on the Luma Home Page
    When User click on the Contact Us link
    Then User should be redirected to the Contact Us page
    And User is on the contact us form

  Scenario: Access to the Luma contact Us  page from the home page
    When User fill out the contact us form
    And User  submit the form
    Then User should see a successful message

  Scenario Outline: User submits Contact Us form with invalid email address
    When User fill out the form with invalid email address "<name>","<invalid_email>" ,"<comment>"
    And User submit the Contact Us form
    Then User should see an error message "<expected_error_message>"

    Examples:
      |name | invalid_email      |comment  | expected_error_message                                           |
      |Kevin| invalidemail.com   |Hi       | Please enter a valid email address (Ex: johndoe@domain.com).     |
      |Mike | invalid@           |Hello!   | Please enter a valid email address (Ex: johndoe@domain.com).     |
      |Joe  | @invalidemail.com  |Thank You| Please enter a valid email address (Ex: johndoe@domain.com).     |