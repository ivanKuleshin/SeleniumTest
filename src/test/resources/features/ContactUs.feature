@contact-us @regression
Feature: WebDriver University - Contact Us Page

  Background:
    Given User opens "ContactUsPage" page
    And User waits until "ContactUsPage" page will be loaded

  Scenario: Validate Successful Submission - Unique Data
    When User types "Ivan" value to "firstNameInput" element on the "ContactUsPage" page
    And User types "Ivanovich" value to "lastNameInput" element on the "ContactUsPage" page
    And User types "ivan.test@gmail.com" value to "emailInput" element on the "ContactUsPage" page
    And User types "My unique comment" value to "commentInput" element on the "ContactUsPage" page
    And User performs default click on the "submitButton" element on the "ContactUsPage" page
    Then User sees "submissionMessage" element with a "Thank You for your Message!" text on the "ContactUsPage" page

  Scenario Outline: Validate Successful Submission - Specific Data
    When User types "<firstName>" value to "firstNameInput" element on the "ContactUsPage" page
    And User types "<lastName>" value to "lastNameInput" element on the "ContactUsPage" page
    And User types "<email>" value to "emailInput" element on the "ContactUsPage" page
    And User types "<comment>" value to "commentInput" element on the "ContactUsPage" page
    And User performs default click on the "submitButton" element on the "ContactUsPage" page
    Then User sees "submissionMessage" element with a "<message>" text on the "ContactUsPage" page

    Examples:
      | firstName | lastName | email               | comment      | message                     |
      | Ivan      | Kul      | test_email@mail.com | How are you? | Thank You for your Message! |
