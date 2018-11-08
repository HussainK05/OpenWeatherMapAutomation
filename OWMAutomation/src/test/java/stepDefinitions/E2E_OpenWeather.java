/*package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import com.owm.pageObjects.HomePageObjects;
import com.owm.testUtil.TestUtil;
import com.own.baseTest.TestBase;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class E2E_OpenWeather extends TestBase {
	
	HomePageObjects homePage;
	
	public E2E_OpenWeather() {
		super();
	}
	@Before
	public void setUp() {
		Intialization();
	}

	@Given("^openweathermap website is opened in a web browser$")
	public void openweathermap_website_is_opened_in_a_web_browser() {
		Assert.assertEquals("Сurrent weather and forecast - OpenWeatherMap", driver.getTitle());
	}

	@When("^hompage is loaded successfully$")
	public void hompage_is_loaded_successfully() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("HomePage Is loaded.");
			return;
		}
	}

	@Then("^verify below important information link is displayed correctly and is accessible$")
	public void verify_below_important_information_link_is_displayed_correctly_and_is_accessible(
			DataTable dt) {
		List<String> list = dt.topCells();
		homePage = new HomePageObjects(driver);
		for (int i = 0; i < list.size(); i++) {
			homePage.validateHomePageInformation(list.get(0));
			break;
		}
			
	}

}
*/