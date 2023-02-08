@text-effects @regression
Feature: Selenium Test - Text Effects. Appear and disappear

  Scenario: 01 | Verify accordion titles
    Given User opens "TextEffectsPage" page
    When User waits until "TextEffectsPage" page will be loaded

    Then User sees "manualTestingAccordionMenuButton" element with a "Manual Testing" text on the "TextEffectsPage" page
    And User sees "cucumberBddAccordionMenuButton" element with a "Cucumber BDD" text on the "TextEffectsPage" page
    And User sees "automationTestingAccordionMenuButton" element with a "Automation Testing" text on the "TextEffectsPage" page
    And User sees "keepClickingAccordionMenuButton" element with a "Keep Clicking! - Text will Appear After 5 Seconds!" text on the "TextEffectsPage" page

  Scenario Outline: 02 | Verify accordion descriptions
    Given User opens "TextEffectsPage" page
    And User waits until "TextEffectsPage" page will be loaded

    When User performs default click on the "manualTestingAccordionMenuButton" element on the "TextEffectsPage" page
    And User performs default click on the "cucumberBddAccordionMenuButton" element on the "TextEffectsPage" page
    And User performs default click on the "automationTestingAccordionMenuButton" element on the "TextEffectsPage" page
    And User performs default click on the "keepClickingAccordionMenuButton" element on the "TextEffectsPage" page

    Then User sees "manualTestingAccordionMenuDescription" element contains "<manualTestingDescription>" text on the "TextEffectsPage" page
    And User sees "cucumberBddAccordionMenuDescription" element contains "<cucumberBddDescription>" text on the "TextEffectsPage" page
    And User sees "automationTestingAccordionMenuDescription" element contains "<automationTestingDescription>" text on the "TextEffectsPage" page
    And User sees "keepClickingAccordionMenuDescription" element contains "<keepClickingDescription>" text on the "TextEffectsPage" page

    Examples:
      | manualTestingDescription                                                 | cucumberBddDescription                                       | automationTestingDescription                                                                                                                  | keepClickingDescription                 |
      | Manual testing has for some time been the most popular way to test code. | Cucumber (BDD) simplifies the requirement capturing process. | Automation testing has been steadily grown in popularity these past few years thanks to the time/ cost savings and efficiency that it offers. | This text has appeared after 5 seconds! |
