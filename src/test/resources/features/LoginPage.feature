@login @regression

Feature: WebDriver University - Login Page

  Background:
    Given I open login page

  Scenario: Successful Login
    When I enter default user name
    And I enter default user password
    And I click login button
    Then I see the login message: "validation succeeded"

  Scenario Outline: Unsuccessful Login
    When I enter user name: "<userName>"
    And I enter user password: "<userPassword>"
    And I click login button
    Then I see the login message: "validation failed"

    Examples:
      | userName     | userPassword        |
      | testUserName | invalidUserPassword |