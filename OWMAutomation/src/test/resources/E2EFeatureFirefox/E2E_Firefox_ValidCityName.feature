@End2End @Firefox @validCityName
Feature: E2E automated scenario for validating valid city name in firefox browser
As a user
I want to validate that results are displayed when I search valid city name
So that search result can be validated

Background:
Given openweathermap website is opened in a web browser and hompage is loaded successfully

Scenario: Verify valid city search results
When user enters city name as "Mumbai" in Your city name search box
And click on "Search" button
Then result should be displayed for the searched city













	

