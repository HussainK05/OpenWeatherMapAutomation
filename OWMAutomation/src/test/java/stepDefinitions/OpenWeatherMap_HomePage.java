package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.owm.pageObjects.HomePageObjects;
import com.owm.testUtil.TestUtil;
import com.own.baseTest.TestBase;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OpenWeatherMap_HomePage extends TestBase {
	HomePageObjects homePage;
	WebDriverWait wait;
	String window = "child";
	String cityName = null;

	@Given("^openweathermap website is opened in a web browser and hompage is loaded successfully$")
	public void openweathermap_website_is_opened_in_a_web_browser_and_homepage_is_loaded_successfully() {
		homePage = PageFactory.initElements(driver, HomePageObjects.class);
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
		System.out.println(searchResult);
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
	public void user_clicks_on_Fahrenheit_button() {
		homePage.logoLink.click();
		homePage.farenhitBtn.click();
	}
	
	@Then("^weather information on the home page should be displayed in Fahrenheit$")
	public void weather_information_on_the_home_page_should_be_displayed_in_Fahrenheit() throws Throwable {
		Assert.assertTrue(driver.findElement(By.className("weather-widget__temperature")).getText().contains("°F"));
	}
	
	@Then("^user clicks on Celsius button$")
	public void user_clicks_on_Celsius_button() {
		homePage.degreeBtn.click();
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
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
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
		TestUtil.waitScriptLoad();
	}

	@Then("^it should display below dropdown options$")
	public void it_should_display_below_dropdown_options(DataTable dropdownopt) throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
		List<String> list = dropdownopt.topCells();
		WebElement dropdown = driver.findElement(By.xpath("//ul[@class='dropdown-menu']"));
		List<WebElement> options = dropdown.findElements(By.tagName("li"));
		for (int i = 0; i < options.size(); i++) {
			System.out.println(list.get(i));
			System.out.println(options.get(i).getText());
			Assert.assertEquals(list.get(i), options.get(i).getText());
		}
	}

	@Then("^user clicks on \"([^\"]*)\" menu option to view weather API$")
	public void user_clicks_on_menu_option_to_view_weather_API(String API) throws Throwable {
		homePage.apimenuLink.click();
		TestUtil.waitScriptLoad();
	}

	@Then("^Weather API page should be displayed$")
	public void weather_API_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
	}
	
	@Then("^user clicks on \"([^\"]*)\" menu option to view pricing$")
	public void user_clicks_on_menu_option_to_view_pricing(String price) throws Throwable {
		homePage.princemenuLink.click();
		TestUtil.waitScriptLoad();
	}
	
	@Then("^Price page should be displayed$")
	public void price_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();   
	}
	
	@Then("^user clicks on \"([^\"]*)\" menu option to view partners$")
	public void user_clicks_on_menu_option_to_view_partners(String partner) throws Throwable {
		homePage.partnersmenuLink.click();
		TestUtil.waitScriptLoad();
	}
	
	@Then("^Partners and Solutions page should be displayed$")
	public void partners_and_Solutions_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
	}
	
	@Then("^user cliks on \"([^\"]*)\" menu option to view weather stations$")
	public void user_cliks_on_menu_option_to_view_weather_stations(String station) throws Throwable {
		homePage.stationsmenuLink.click();
		TestUtil.waitScriptLoad();
	}
	
	@Then("^Weather Stations page should be displayed$")
	public void weather_Stations_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
	}
	
	@Then("^user clicks on \"([^\"]*)\" menu option to weather widgets$")
	public void user_clicks_on_menu_option_to_weather_widgets(String widget) throws Throwable {
		homePage.widgetsmenuLink.click();
		TestUtil.waitScriptLoad();
	}
	
	@Then("^Widget Constructor page should be displayed$")
	public void widget_Constructor_page_should_be_displayed() throws Throwable {
		TestUtil.takeScreenshotAtEndOfTest();
	}
	
	@Then("^user cliks on \"([^\"]*)\" menu option to view blogs$")
	public void user_cliks_on_menu_option_to_view_blogs(String blogs) throws Throwable {
		homePage.blogmenuLink.click();
	}
	
	@Then("^Blog page should be displayed of OpenWeather in the new tab of the browser$")
	public void blog_page_should_be_displayed_of_OpenWeather_in_the_new_tab_of_the_browser() throws Throwable {
		TestUtil.switchToChildWindow();
		TestUtil.takeScreenshotAtEndOfTest();
		TestUtil.tearDown(window);   
	}
	
/*----------------------------------------Scenario3 step definition starts here---------------------------------------------*/
/*	@When("^user clicks on Daily link$")
	public void user_clicks_on_Daily_link() throws Throwable {
	    
	}

	@Then("^it should display daily weather and forecast details$")
	public void it_should_display_daily_weather_and_forecast_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^user clicks on Hourly link$")
	public void user_clicks_on_Hourly_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^it should display hourly weather and forecast details$")
	public void it_should_display_hourly_weather_and_forecast_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^user clicks on Chart link$")
	public void user_clicks_on_Chart_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^it should display chart weather and forecast detials$")
	public void it_should_display_chart_weather_and_forecast_detials() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^user clicks on Map link$")
	public void user_clicks_on_Map_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^it should display map weather and forecast details$")
	public void it_should_display_map_weather_and_forecast_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^user clicks on Main link$")
	public void user_clicks_on_Main_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^it should display current day weather and forecast details$")
	public void it_should_display_current_day_weather_and_forecast_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
*/}
