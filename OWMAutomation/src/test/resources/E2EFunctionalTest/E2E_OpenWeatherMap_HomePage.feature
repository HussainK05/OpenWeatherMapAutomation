@End2End @ImpInfoHomepage
Feature: E2E automated scenarios for validating important information on homepage
As an automation tester
I want to verify all important information on the homepage
So that we can confirm testing of hompage

Background:
Given openweathermap website is opened in a web browser and hompage is loaded successfully

@Scenario1
Scenario: Verify mini navigation bar information of the homepage
When user clicks on "Support Center" link
Then "Support Center" page should displayed in the new tab of the browser
And user clicks on "Weather in your city" link and enter city name "Mumbai" to search weather
Then result should display weather of the searched city
And user clicks on "Sign In" link to sign in
Then Sign In page should be displayed for user to sign in to the account
And user clicks on "Sign Up" link to sign up
Then Sign Up page should be displayed for user to create a new account
And user clicks on Fahrenheit button
Then weather information on the home page should be displayed in Fahrenheit
And user clicks on Celsius button
Then weather information on the home page should be displayed in celsius

@Scenario2
Scenario: Verify company logo and menu options in the header
When user clicks on the company logo
Then page should get refreshed
And user clicks on "Weather" menu option to view weather
Then Weather Forecast page should be displayed
And user clicks on "Maps" dropdown menu option to view dropdown options
Then it should display below dropdown options
|Weather maps|Current satellite maps|Beautiful places| 
And user clicks on "API" menu option to view weather API
Then Weather API page should be displayed
And user clicks on "Price" menu option to view pricing
Then Price page should be displayed
And user clicks on "Partners" menu option to view partners
Then Partners and Solutions page should be displayed
And user cliks on "Stations" menu option to view weather stations
Then Weather Stations page should be displayed
And user clicks on "Widgets" menu option to weather widgets
Then Widget Constructor page should be displayed
And user cliks on "Blog" menu option to view blogs
Then Blog page should be displayed of OpenWeather in the new tab of the browser

@Scenario3
Scenario: Verify current weather and forecasts in your city widget
When user clicks on Daily link
Then it should display daily weather and forecast details
And user clicks on Hourly link
Then it should display hourly weather and forecast details
And user clicks on Chart link
Then it should display chart weather and forecast detials
And user clicks on Map link
Then it should display map weather and forecast details
And user clicks on Main link
Then it should display current day weather and forecast details

@Scenario4
Scenario: Validate "More weather in your city" button
When user clicks on "More weather in your city" button
Then "Weather Forecast" page should be displayed

@Scenario5
Scenario: Verify "Sentinel-2 via Openweather API" section
When user clicks on "Image" in this section
Then "How to start" page of "Agro API" website should be displayed in the new tab
And user clicks on  "www.agromonitoring.com" link
Then homepage of "Agro API" website should be displayed in the new tab
And user clicks on "blog" link
Then "Blog" page should be displayed of "OpenWeather" in the new tab of the browser
And user clicks on "How to start" button
Then "How to start" page of "Agro API" website should be displayed in the new tab

@Scenario6
Scenario: Verify "APIs for Agriculture on agromonitoring.com" section
When user clicks on "Image" in this section
Then homepage of "Agro API" website should be displayed in the new tab
And user clicks on "Move to agromonitoring.com"
Then homepage of "Agro API" website should be displayed in the new tab











	

