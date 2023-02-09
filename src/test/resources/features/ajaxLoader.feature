@regression
Feature: Selenium Test - Ajax loader

  Scenario: 01 | Click button after Ajax page is loaded
    Given User opens "AjaxLoaderPage" page
    And User waits until "AjaxLoaderPage" page will be loaded
    When User performs default click on the "clickMeButton" element on the "AjaxLoaderPage" page

    Then User sees "modalPopUp" popUp on the "AjaxLoaderPage" page
    And User sees "popUpHeader" element contains "Well Done For Waiting" text in the "modalPopUp" popUp on the "AjaxLoaderPage" page
    And User sees "popUpBody" element contains "The waiting game can be a tricky one" text in the "modalPopUp" popUp on the "AjaxLoaderPage" page
    And User performs default click on the "closePopUpButton" element in the "modalPopUp" popUp on the "AjaxLoaderPage" page
    Then User doesn't see "modalPopUp" popUp on the "AjaxLoaderPage" page