@End2End @Chrome @invalidCityName
Feature: E2E automated scenario for validating invalid city name in chrome browser
As a user
I want to validate that no results are displayed when I search invalid city name
So that error message can be validated

Background:
Given openweathermap website is opened in a web browser and hompage is loaded successfully

Scenario: Verify "Not Found" error message
When user enters city name as "ABCD" in Your city name search box
And click on "Search" button
Then result should be displayed as "Not found"













	

