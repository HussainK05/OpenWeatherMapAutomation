package stepDefinitions;

import org.junit.Assert;
import stepDefinitions.OpenWeatherMap_HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.owm.baseTest.TestBase;
import com.owm.pageObjects.HomePageObjects;
import com.owm.testUtil.TestUtil;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class E2E_Invalid_Valid_CitySearch extends TestBase {
	HomePageObjects homePage;
	String cityName = null;
	
	@When("^user enters city name as \"([^\"]*)\" in Your city name search box$")
	public void user_enters_city_name_as_in_Your_city_name_search_box(String cityname) {
		homePage = PageFactory.initElements(driver, HomePageObjects.class);
		homePage.searchTextbox.click();
		homePage.searchTextbox.sendKeys(cityname);
		cityName = cityname;
	}

	@Then("^click on \"([^\"]*)\" button$")
	public void click_on_button(String arg1) throws Throwable {
	    homePage.searchBtn.click();
	}

	@Then("^result should be displayed as \"([^\"]*)\"$")
	public void result_should_be_displayed_as(String expResult) throws Throwable {
	    Assert.assertTrue(driver.findElement(By.xpath("//*[@class='alert alert-warning']")).getText().contains(expResult));
	    TestUtil.takeScreenshotAtEndOfTest();
	}
	
	@Then("^result should be displayed for the searched city$")
	public void result_should_be_displayed_for_the_searched_city() throws Throwable {
		String searchResult = driver.findElement(By.xpath("//a[contains(text(),'" + cityName + "')]")).getText();
		Assert.assertTrue(searchResult.contains(cityName));
	}

}
