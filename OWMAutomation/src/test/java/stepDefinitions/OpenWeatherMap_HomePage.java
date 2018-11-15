package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.owm.baseTest.TestBase;
import com.owm.pageObjects.HomePageObjects;
import com.owm.testUtil.TestUtil;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OpenWeatherMap_HomePage extends TestBase {
	HomePageObjects homePage;
	WebDriverWait wait;
	String window = "child";
	String cityName = null;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@Given("^openweathermap website is opened in a web browser and hompage is loaded successfully$")
	public void openweathermap_website_is_opened_in_a_web_browser_and_homepage_is_loaded_successfully() {
		homePage = PageFactory.initElements(driver, HomePageObjects.class);
		wait = new WebDriverWait(driver,30);
		Assert.assertEquals("Сurrent weather and forecast - OpenWeatherMap", driver.getTitle());
	}
	
/*----------------------------------------Scenario1 step definition starts here---------------------------------------------*/

	@When("^user clicks on \"([^\"]*)\" link$")
	public void user_clicks_on_support_center_link(String supportcenter) throws InterruptedException {
		homePage.SupportCenterTitleLink.click();	
		Thread.sleep(5000);
	}

	@Then("^\"([^\"]*)\" page should displayed in the new tab of the browser$")
	public void page_should_displayed_in_the_new_tab_of_the_browser(String arg1) throws IOException {
		TestUtil.switchToChildWindow();
		TestUtil.takeScreenshotAtEndOfTest();
		TestUtil.tearDown(window);
	}

	@Then("^user clicks on \"([^\"]*)\" link and enter city name \"([^\"]*)\" to search weather$")
	public void user_clicks_on_link_and_enter_city_name_to_search_weather(String weatherinurcity, String cityname){
		cityName = cityname;
		homePage.SearchBarTitleLink.click();
		homePage.WeatherSearchBarLink.sendKeys(cityname);
		homePage.WeatherSearchBarLink.sendKeys(Keys.ENTER);
	}

	@Then("^result should display weather of the searched city$")
	public void result_should_display_weather_of_the_searched_city() throws IOException {
		String searchResult = driver.findElement(By.xpath("//a[contains(text(),'" + cityName + "')]")).getText();
		Assert.assertTrue(searchResult.contains(cityName));
	}
	
	@Then("^user clicks on \"([^\"]*)\" link to sign in$")
	public void user_clicks_on_link_to_sign_in(String signin) {
	    homePage.SignInLink.click();
	}
	
	@Then("^Sign In page should be displayed for user to sign in to the account$")
	public void sign_In_page_should_be_displayed_for_user_to_sign_in_to_the_account() throws IOException {
		TestUtil.takeScreenshotAtEndOfTest();   
	}
	
	@Then("^user clicks on \"([^\"]*)\" link to sign up$")
	public void user_clicks_on_link_to_sign_up(String arg1) {
	    homePage.SingUpLink.click();
	}
	
	@Then("^Sign Up page should be displayed for user to create a new account$")
	public void sign_Up_page_should_be_displayed_for_user_to_create_a_new_account() throws IOException {
		TestUtil.takeScreenshotAtEndOfTest();  
	}
	
	@Then("^user clicks on Fahrenheit button$")
	public void user_clicks_on_Fahrenheit_button() throws InterruptedException {	
		homePage.logoLink.click();
		TestUtil.waitScriptLoad();
		Thread.sleep(5000);
		if(TestBase.browser.equals("chrome")) {
			homePage.degreeBtn.click();
			Thread.sleep(5000);
		}
		homePage.farenhitBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}
	
	@Then("^weather information on the home page should be displayed in Fahrenheit$")
	public void weather_information_on_the_home_page_should_be_displayed_in_Fahrenheit() throws Throwable {
		Assert.assertTrue(driver.findElement(By.className("weather-widget__temperature")).getText().contains("°F"));
	}
	
	@Then("^user clicks on Celsius button$")
	public void user_clicks_on_Celsius_button() throws InterruptedException {
/*		homePage.logoLink.click();
		Thread.sleep(5000);*/
		homePage.degreeBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}
	
	@Then("^weather information on the home page should be displayed in celsius$")
	public void weather_information_on_the_home_page_should_be_displayed_in_celsius() throws Throwable {
		Assert.assertTrue(driver.findElement(By.className("weather-widget__temperature")).getText().contains("°C"));
	}
	

/*----------------------------------------Scenario2 step definition starts here---------------------------------------------*/	
	
	@When("^user clicks on the company logo$")
	public void user_clicks_on_the_company_logo() throws Throwable {
		homePage.logoLink.click();
		TestUtil.waitScriptLoad();
	}

	@Then("^page should get refreshed$")
	public void page_should_get_refreshed() throws Throwable {
		if(TestBase.browser.equals("chrome")) {
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		}
		TestUtil.takeScreenshotAtEndOfTest();
	}

	@Then("^user clicks on \"([^\"]*)\" menu option to view weather$")
	public void user_clicks_on_menu_option_to_view_weather(String weather) throws Throwable {
		homePage.weathermenuLink.click();
		TestUtil.waitScriptLoad();
	}

	@Then("^Weather Forecast page should be displayed$")
	public void Weather_Forecast_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
	}

	@Then("^user clicks on \"([^\"]*)\" dropdown menu option to view dropdown options$")
	public void user_clicks_on_dropdown_menu_option_to_view_dropdown_options(String maps) throws Throwable {
		homePage.mapsmenuLink.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		TestUtil.waitScriptLoad();
	}

	@Then("^it should display below dropdown options$")
	public void it_should_display_below_dropdown_options(DataTable dropdownopt) throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
		List<String> list = dropdownopt.topCells();
		WebElement dropdown = driver.findElement(By.xpath("//ul[@class='dropdown-menu']"));
		List<WebElement> options = dropdown.findElements(By.tagName("li"));
		for (int i = 0; i < options.size(); i++) {
			//System.out.println(list.get(i));
			//System.out.println(options.get(i).getText());
			Assert.assertEquals(list.get(i), options.get(i).getText());
		}
	}

	@Then("^user clicks on \"([^\"]*)\" menu option to view weather API$")
	public void user_clicks_on_menu_option_to_view_weather_API(String API) throws Throwable {
		homePage.apimenuLink.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		TestUtil.waitScriptLoad();
	}

	@Then("^Weather API page should be displayed$")
	public void weather_API_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
	}
	
	@Then("^user clicks on \"([^\"]*)\" menu option to view pricing$")
	public void user_clicks_on_menu_option_to_view_pricing(String price) throws Throwable {
		homePage.princemenuLink.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		TestUtil.waitScriptLoad();
	}
	
	@Then("^Price page should be displayed$")
	public void price_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();   
	}
	
	@Then("^user clicks on \"([^\"]*)\" menu option to view partners$")
	public void user_clicks_on_menu_option_to_view_partners(String partner) throws Throwable {
		homePage.partnersmenuLink.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		TestUtil.waitScriptLoad();
	}
	
	@Then("^Partners and Solutions page should be displayed$")
	public void partners_and_Solutions_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
	}
	
	@Then("^user cliks on \"([^\"]*)\" menu option to view weather stations$")
	public void user_cliks_on_menu_option_to_view_weather_stations(String station) throws Throwable {
		homePage.stationsmenuLink.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		TestUtil.waitScriptLoad();
	}
	
	@Then("^Weather Stations page should be displayed$")
	public void weather_Stations_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
	}
	
	@Then("^user clicks on \"([^\"]*)\" menu option to weather widgets$")
	public void user_clicks_on_menu_option_to_weather_widgets(String widget) throws Throwable {
		homePage.widgetsmenuLink.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		TestUtil.waitScriptLoad();
	}
	
	@Then("^Widget Constructor page should be displayed$")
	public void widget_Constructor_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
	}
	
	@Then("^user cliks on \"([^\"]*)\" menu option to view blogs$")
	public void user_cliks_on_menu_option_to_view_blogs(String blogs) throws Throwable {
		homePage.blogmenuLink.click();
		Thread.sleep(5000);
	}
	
	@Then("^Blog page should be displayed of OpenWeather in the new tab of the browser$")
	public void blog_page_should_be_displayed_of_OpenWeather_in_the_new_tab_of_the_browser() throws Throwable {
		TestUtil.switchToChildWindow();
		TestUtil.takeScreenshotAtEndOfTest();
		TestUtil.tearDown(window);   
	}
	
/*----------------------------------------Scenario3 step definition starts here---------------------------------------------*/	
	@When("^user clicks on Daily link$")
	public void user_clicks_on_Daily_link() throws Throwable {
		js.executeScript("window.scrollBy(0,200)");
	    homePage.widgetsDailyLink.click();
	}

	@Then("^it should display daily weather and forecast details$")
	public void it_should_display_daily_weather_and_forecast_details() throws Throwable {
		Assert.assertTrue(homePage.widgetGraphicHeader.getText().contains("Daily"));
		TestUtil.takeScreenshotAtEndOfTest();
	}

	@Then("^user clicks on Hourly link$")
	public void user_clicks_on_Hourly_link() throws Throwable {
		homePage.widgetsHourlyLink.click();
	}

	@Then("^it should display hourly weather and forecast details$")
	public void it_should_display_hourly_weather_and_forecast_details() throws Throwable {
		Assert.assertTrue(driver.findElement(By.className("weather-forecast-hourly-list__header")).getText().contains("Hourly"));
		TestUtil.takeScreenshotAtEndOfTest();
	}

	@Then("^user clicks on Chart link$")
	public void user_clicks_on_Chart_link() throws Throwable {
		homePage.widgetsChartLink.click();
	}

	@Then("^it should display chart weather and forecast detials$")
	public void it_should_display_chart_weather_and_forecast_detials() throws Throwable {
		Assert.assertTrue(driver.findElement(By.className("weather-forecast-chartval-graphic__header")).getText().contains("Chart"));
		TestUtil.takeScreenshotAtEndOfTest();
	}

	@Then("^user clicks on Map link$")
	public void user_clicks_on_Map_link() throws Throwable {
		homePage.widgetsMapLink.click();
	}

	@Then("^it should display map weather and forecast details$")
	public void it_should_display_map_weather_and_forecast_details() throws Throwable {
		Assert.assertTrue(driver.findElement(By.className("weather-map-layers__header")).getText().contains("Map"));
		TestUtil.takeScreenshotAtEndOfTest();
	}

	@Then("^user clicks on Main link$")
	public void user_clicks_on_Main_link() throws Throwable {
		homePage.widgetsMainLink.click();
	}

	@Then("^it should display current day weather and forecast details$")
	public void it_should_display_current_day_weather_and_forecast_details() throws Throwable {
		Assert.assertTrue(driver.findElement(By.className("weather-forecast-hourly-graphic__header")).getText().contains("Weather"));
		TestUtil.takeScreenshotAtEndOfTest();
	}
/*----------------------------------------Scenario4 step definition starts here---------------------------------------------*/
	@When("^user clicks on \"([^\"]*)\" button$")
	public void user_clicks_on_button(String arg1) throws Throwable {
		js.executeScript("arguments[0].scrollIntoView();", homePage.moreWeatherBtn);
		js.executeScript("arguments[0].click();", homePage.moreWeatherBtn);
	}

	@Then("^\"([^\"]*)\" page should be displayed$")
	public void page_should_be_displayed(String moreWeather) throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-forecast-list__header")));
		js.executeScript("window.scrollBy(0,800)");
		Assert.assertEquals(driver.findElement(By.className("breadcrumb-title")).getText(), moreWeather);		
		TestUtil.takeScreenshotAtEndOfTest();
	}
	
/*----------------------------------------Scenario5 step definition starts here---------------------------------------------*/	
	@When("^user clicks on \"([^\"]*)\" in this section$")
	public void user_clicks_on_in_this_section(String arg1) throws Throwable {
		js.executeScript("window.scrollBy(0,1000)");
		js.executeScript("arguments[0].click();", homePage.agroImage);
		Thread.sleep(5000);
	}

	@Then("^\"([^\"]*)\" page of \"([^\"]*)\" website should be displayed in the new tab$")
	public void page_of_website_should_be_displayed_in_the_new_tab(String arg1, String arg2) throws Throwable {
		TestUtil.switchToChildWindow();
		TestUtil.takeScreenshotAtEndOfTest();
		TestUtil.tearDown(window);
	}

	@Then("^user clicks on  \"([^\"]*)\" website link$")
	public void user_clicks_on_website_link(String arg1) throws Throwable {
		js.executeScript("arguments[0].click();", homePage.agroWebLink);
		Thread.sleep(5000);
	}

	@Then("^homepage of \"([^\"]*)\" website should be displayed in the new tab$")
	public void homepage_of_website_should_be_displayed_in_the_new_tab(String arg1) throws Throwable {
		TestUtil.switchToChildWindow();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("agro-mainpage-banner__title")));
		TestUtil.takeScreenshotAtEndOfTest();
		TestUtil.tearDown(window);
	}
		
	@Then("^user clicks on \"([^\"]*)\" link via Openweather API section$")
	public void user_clicks_on_link_via_Openweather_API_section(String arg1) throws Throwable {
		js.executeScript("arguments[0].click();", homePage.agroBlogLink);
		Thread.sleep(5000);
	}

	@Then("^\"([^\"]*)\" page should be displayed of \"([^\"]*)\" in the new tab of the browser$")
	public void page_should_be_displayed_of_in_the_new_tab_of_the_browser(String arg1, String arg2) throws Throwable {
		TestUtil.switchToChildWindow();
		TestUtil.takeScreenshotAtEndOfTest();
		TestUtil.tearDown(window);
	}
	
	@When("^user clicks on \"([^\"]*)\" button via Openweather API section$")
	public void user_clicks_on_button_via_Openweather_API_section(String arg1) throws Throwable {
		js.executeScript("arguments[0].click();", homePage.agroHowToStart);
	}
/*----------------------------------------Scenario6 step definition starts here---------------------------------------------*/	
	@When("^user clicks on \"([^\"]*)\" in API for agriculture section$")
	public void user_clicks_on_in_API_for_agriculture_section(String arg1) throws Throwable {
		js.executeScript("window.scrollBy(0,1400)");
		js.executeScript("arguments[0].click();", homePage.agroImageAPI);
		Thread.sleep(5000);
	}

	@Then("^user clicks on \"([^\"]*)\" link in API for agriculture section$")
	public void user_clicks_on_link_in_API_for_agriculture_section(String arg1) throws Throwable {
		js.executeScript("arguments[0].click();", homePage.moveToAgroBtn);
		Thread.sleep(5000);
	}
/*----------------------------------------Scenario7 step definition starts here---------------------------------------------*/	
	@When("^user clicks on Find your city link$")
	public void user_clicks_on_Find_your_city_link() throws Throwable {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    if(homePage.weatherinurctFooter.isDisplayed()) {
	    	homePage.findurctLink.click();
	    }
	}

	@Then("^Weather in your city page should be displayed$")
	public void weather_in_your_city_page_should_be_displayed() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_str")));
		TestUtil.takeScreenshotAtEndOfTest();
		homePage.logoLink.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}

	@Then("^user clicks on Weather maps$")
	public void user_clicks_on_Weather_maps() throws Throwable {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    homePage.wmapsLink.click();
	}

	@Then("^interactive maps page should be displayed$")
	public void interactive_maps_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
		homePage.logoLink.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}

	@Then("^user clicks on How to start link$")
	public void user_clicks_on_How_to_start_link() throws Throwable {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		homePage.howtostrtLink.click();
	}

	@Then("^How to start page should be displayed$")
	public void how_to_start_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
		homePage.logoLink.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}

	@Then("^user clicks on Weather APIs for developers$")
	public void user_clicks_on_Weather_APIs_for_developers() throws Throwable {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		homePage.weatherAPILink.click();
	}

	@Then("^Weather APIs page should be displayed$")
	public void weather_APIs_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
		homePage.logoLink.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}

	@Then("^user clicks on Current weather link$")
	public void user_clicks_on_Current_weather_link() throws Throwable {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		homePage.cweatherLink.click();
	}

	@Then("^Current weather data page should be displayed$")
	public void current_weather_data_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
		homePage.logoLink.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}

	@Then("^user clicks on (\\d+) day/(\\d+) hour weather forecast$")
	public void user_clicks_on_day_hour_weather_forecast(int arg1, int arg2) throws Throwable {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		homePage.wforecast53Link.click();
	}

	@Then("^(\\d+) day weather forecast page should be displayed$")
	public void day_weather_forecast_page_should_be_displayed(int arg1) throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
		homePage.logoLink.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}

	@Then("^user clicks on (\\d+) day/ daily weather forecase$")
	public void user_clicks_on_day_daily_weather_forecase(int arg1) throws Throwable {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    homePage.wforecast16Link.click();
	}

	@Then("^user clicks on Hourly historical data link$")
	public void user_clicks_on_Hourly_historical_data_link() throws Throwable {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}

	@Then("^Historical data page should be displayed$")
	public void historical_data_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
		homePage.logoLink.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}

	@Then("^user clicks on History bulk link$")
	public void user_clicks_on_History_bulk_link() throws Throwable {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		homePage.historybulkLink.click();
	}

	@Then("^History bulk page should be displayed$")
	public void history_bulk_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
		homePage.logoLink.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}

	@Then("^user cliks on Examples of API use$")
	public void user_cliks_on_Examples_of_API_use() throws Throwable {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		homePage.apiuseLink.click();
	}

	@Then("^Partner and solutions page should be displayed$")
	public void partner_and_solutions_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
		homePage.logoLink.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}

	@Then("^user clicks on Example of weather map layers link$")
	public void user_clicks_on_Example_of_weather_map_layers_link() throws Throwable {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		homePage.mapslayerLink.click();
	}

	@Then("^Example of weather map layers page should be displayed$")
	public void example_of_weather_map_layers_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
		homePage.logoLink.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}

	@Then("^user clicks on Map styles legend$")
	public void user_clicks_on_Map_styles_legend() throws Throwable {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		homePage.stylelengenLink.click();
	}

	@Then("^Map style legends page should be displayed$")
	public void map_style_legends_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
		homePage.logoLink.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}

	@Then("^user clicks on Libraries to connect weather layers$")
	public void user_clicks_on_Libraries_to_connect_weather_layers() throws Throwable {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    homePage.weatherlayerLink.click();
	}

	@Then("^Libraries to connect weather layers page should be displayed$")
	public void libraries_to_connect_weather_layers_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
		homePage.logoLink.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}

	@Then("^user clicks on Price-list link$")
	public void user_clicks_on_Price_list_link() throws Throwable {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		homePage.pricelistLink.click();
	}

	@Then("^Price list page should be displayed$")
	public void price_list_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
		homePage.logoLink.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}

	@Then("^user clicks on Subscribe to APIs link$")
	public void user_clicks_on_Subscribe_to_APIs_link() throws Throwable {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		homePage.subtoapiLink.click();
	}

	@Then("^Subscription page should be displayed$")
	public void subscription_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
		homePage.logoLink.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}

	@Then("^user clicks on How to connect your weather station$")
	public void user_clicks_on_How_to_connect_your_weather_station() throws Throwable {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		homePage.stationLink.click();
	}

	@Then("^Weather stations page should be displayed$")
	public void weather_stations_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
		homePage.logoLink.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}

	@Then("^user clicks on About company link$")
	public void user_clicks_on_About_company_link() throws Throwable {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    homePage.aboutcmpLink.click();
	}

	@Then("^About company page should be displayed$")
	public void about_company_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}

	@Then("^user clicks on Team link$")
	public void user_clicks_on_Team_link() throws Throwable {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    homePage.teamLink.click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}

	@Then("^Team page should be displayed$")
	public void team_page_should_be_displayed() throws Throwable {
		TestUtil.switchToChildWindow();
		TestUtil.takeScreenshotAtEndOfTest();
		TestUtil.tearDown(window);
	}

	@Then("^user clicks on Weather model link$")
	public void user_clicks_on_Weather_model_link() throws Throwable {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		homePage.modelLink.click();
	}

	@Then("^Weather model page should be displayed$")
	public void weather_model_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
		homePage.logoLink.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("weather-widget__city-name")));
	}
}
