@contact-us @regression
Feature: WebDriver University - Contact Us Page

  Background:
    Given I open the ContactUs page

  Scenario: Validate Successful Submission - Unique Data
    When I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click on the submit button
    Then I should be presented with a successful contact us submission message

  Scenario Outline: Validate Successful Submission - Specific Data
    When I enter a specific first name "<firstName>"
    And I enter a specific last name "<lastName>"
    And I enter a specific email address "<email>"
    And I enter a specific comment "<comment>"
    And I click on the submit button
    Then I should be presented with a successful contact us submission message

    Examples:
      | firstName | lastName | email               | comment      |
      | Ivan      | Kul      | test_email@mail.com | How are you? |