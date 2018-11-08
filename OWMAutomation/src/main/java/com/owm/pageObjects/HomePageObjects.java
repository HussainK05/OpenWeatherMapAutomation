package com.owm.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObjects {
	private WebDriver driver;
	WebDriverWait wait;
	
	public HomePageObjects(WebDriver driver) {
		//PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver,30);
	}
	
	@FindBy(xpath="//span[text()=\"Support Center\"]")
	public WebElement SupportCenterTitleLink;
	
	@FindBy(xpath="//h3[contains(text(),'Browse by Topic')]")
	public WebElement SupportCenterNewPage;
	
	@FindBy(id="nav-search")
	public WebElement SearchBarTitleLink;
	
	@FindBy(xpath="//div[@class='input-group']//input[@id='q']")
	public WebElement WeatherSearchBarLink;
	
	@FindBy(linkText="Sign In")
	public WebElement SignInLink;
	
	@FindBy(linkText="Sign Up")
	public WebElement SingUpLink;
	
	@FindBy(id="metric")
	public WebElement degreeBtn;
	
	@FindBy(id="imperial")
	public WebElement farenhitBtn;
	
	@FindBy(xpath="//img[contains(@src,\"logo_OpenWeatherMap_orange\")]")
	public WebElement logoLink;
	
	@FindBy(linkText="Weather")
	public WebElement weathermenuLink;
	
	@FindBy(partialLinkText="Maps")
	public WebElement mapsmenuLink;
	
	@FindBy(linkText="API")
	public WebElement apimenuLink;
	
	@FindBy(linkText="Price")
	public WebElement princemenuLink;
	
	@FindBy(linkText="Partners")
	public WebElement partnersmenuLink;
	
	@FindBy(linkText="Stations")
	public WebElement stationsmenuLink;
	
	@FindBy(linkText="Widgets")
	public WebElement widgetsmenuLink;
	
	@FindBy(partialLinkText="Blog")
	public WebElement blogmenuLink;
	
	@FindBy(xpath="//div[@class='jumbotron first']")
	WebElement mainSlideShow;
	
	@FindBy(id="q")
	WebElement searchTextbox;
	
	@FindBy(xpath="//form[@id='searchform']//button[@type='button']")
	WebElement searchBtn;
	
	@FindBy(xpath="//form[@id='searchform']//button[@type='submit']")
	WebElement currentlocBtn;
	
	@FindBy(id="weather-widget")
	WebElement weatherwidgetLink;
	
	@FindBy(className="widget__title")
	WebElement widgettileLink;
	
	@FindBy(className="widget__graphic")
	WebElement widgetgraphicLink;
	
	@FindBy(xpath="//h3[contains(text(),'Weather in your city')]")
	WebElement weatherinurctFooter;
	
	@FindBy(linkText="Find your city")
	WebElement findurctLink;
	
	@FindBy(linkText="Weather maps")
	WebElement wmapsLink;
	
	@FindBy(xpath="//h3[@class='text-color'][contains(text(),'Weather APIs')]")
	WebElement weatherapiFooter;
	
	@FindBy(linkText="How to start")
	WebElement howtostrtLink;
	
	@FindBy(linkText="Current weather")
	WebElement cweatherLink;
	
	@FindBy(linkText="5 day / 3 hour weather forecast")
	WebElement wforecast53Link;
	
	@FindBy(linkText="16 day / daily weather forecast")
	WebElement wforecast16Link;
	
	@FindBy(linkText="Hourly historical data")
	WebElement historicalLink;
	
	@FindBy(linkText="History bulk")
	WebElement historybulkLink;
	
	@FindBy(linkText="Examples of API use")
	WebElement apiuseLink;
	
	@FindBy(xpath="//h3[contains(text(),'Map layers')]")
	WebElement mapslayersFooter;
	
	@FindBy(partialLinkText="Examples of weather map layers")
	WebElement mpaslayerLink;
	
	@FindBy(partialLinkText="Map styles legend")
	WebElement stylelengenLink;
	
	@FindBy(partialLinkText="Libraries to connect weather layers")
	WebElement weatherlayerLink;
	
	@FindBy(xpath="//h3[contains(text(),'How to subscribe')]")
	WebElement subscribeFooter;
	
	@FindBy(linkText="Price-list")
	WebElement pricelistLink;
	
	@FindBy(linkText="Subscribe to APIs")
	WebElement subtoapiLink;
	
	@FindBy(xpath="//div[@class='content']//div[@class='alert alert-info']")
	WebElement alertFooter;
	
	@FindBy(xpath="//div[@class='content']//a[@class='alert-link'][contains(text(),'Support center')]")
	WebElement supportcenterFooter;
	
	@FindBy(xpath="//h3[contains(text(),'Weather station network')]")
	WebElement stationFooter;
	
	@FindBy(linkText="How to connect your weather station")
	WebElement stationLink;
	
	@FindBy(xpath="//h3[contains(text(),'About')]")
	WebElement aboutFooter;
	
	@FindBy(linkText="About company")
	WebElement aboutcmpLink;
	
	@FindBy(linkText="Team")
	WebElement teamLink;
	
	@FindBy(linkText="Weather model")
	WebElement modelLink;
	
	@FindBy(linkText="Terms and conditions of sale")
	WebElement tncsaleLink;
	
	@FindBy(linkText="Privacy policy")
	WebElement policyLink;
	
	@FindBy(linkText="Websites terms and conditions of use")
	WebElement tncuseLink;
	
	@FindBy(linkText="Our team")
	WebElement ourteamLink;
	
	@FindBy(xpath="//div[@class='col-sm-12']//p[2]")
	WebElement copyrightsFooter;
	
	@FindBy(className="stick-footer-panel__description")
	WebElement copyrightsdescFooter;
	
	@FindBy(partialLinkText="privacy policy")
	WebElement copyrightsppLink;
	
	public String getTextValue(WebElement textElement) {
		wait.until(ExpectedConditions.visibilityOf(textElement));
		return textElement.getText();
	}
	
	public boolean checkElementIsDisplayed (WebElement checkElement) {
		wait.until(ExpectedConditions.visibilityOf(checkElement));
		return checkElement.isDisplayed();
	}
	
	public void validateMiniNavBar(String navbarfieldName) throws InterruptedException {
		switch(navbarfieldName) {
		case "Support Center":
			wait.until(ExpectedConditions.visibilityOf(SupportCenterTitleLink));
			if (SupportCenterTitleLink.isDisplayed()) {
				SupportCenterTitleLink.click();
				Thread.sleep(5000);
			}
			break;
		case "Sign In":
			wait.until(ExpectedConditions.visibilityOf(SignInLink));
			if (SignInLink.isDisplayed()) {
				SignInLink.click();	
			}
			break;
		case "Sign Up":
			wait.until(ExpectedConditions.visibilityOf(SingUpLink));
			if (SingUpLink.isDisplayed()) {
				SingUpLink.click();	
			}
			break;
		}
			
	}
	
	public void validateMiniNavBar(String navbarfieldName, String searchName) throws InterruptedException {
		switch(navbarfieldName) {
		case "Weather in your city":
			wait.until(ExpectedConditions.visibilityOf(SearchBarTitleLink));
			if (SearchBarTitleLink.isDisplayed()) {
				SearchBarTitleLink.click();
				wait.until(ExpectedConditions.visibilityOf(WeatherSearchBarLink));
				WeatherSearchBarLink.sendKeys(searchName);
				WeatherSearchBarLink.sendKeys(Keys.ENTER);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+searchName+"')]")));
			}
			break;
		}
	}
	
	public void checkElementDisplayedAndClick(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		if (element.isDisplayed()) {
			element.click();
		}
	}

}
