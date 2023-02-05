@login @regression

Feature: WebDriver University - Login Page

  Background:
    Given User opens "LoginPage" page
    And User waits until "LoginPage" page will be loaded

  Scenario: Successful Login
    When User performs login with default credentials
    And User performs default click on the "loginButton" element on the "LoginPage" page
    Then User sees "validation succeeded" text in the alert window

  Scenario Outline: Unsuccessful Login
    When User types "<userName>" value to "userNameInput" element on the "LoginPage" page
    And User types "<userPassword>" value to "userPasswordInput" element on the "LoginPage" page
    And User performs default click on the "loginButton" element on the "LoginPage" page
    Then User sees "<loginMessage>" text in the alert window

    Examples:
      | userName     | userPassword        | loginMessage      |
      | testUserName | invalidUserPassword | validation failed |