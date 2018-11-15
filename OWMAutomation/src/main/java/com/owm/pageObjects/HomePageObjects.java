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
	
	@FindBy(xpath="//*[@placeholder='Your city name']")
	public WebElement searchTextbox;
	
	@FindBy(xpath="//*[@id='searchform']/button")
	public WebElement searchBtn;
	
	@FindBy(xpath="//form[@id='searchform']//button[@type='submit']")
	public WebElement currentlocBtn;
	
	@FindBy(id="//h2[@class='weather-widget__city-name']")
	public WebElement weatherwidgetLink;
	
	@FindBy(className="widget__title")
	public WebElement widgettileLink;
	
	@FindBy(className="widget__graphic")
	public WebElement widgetgraphicLink;
	
	@FindBy(linkText="Main")
	public WebElement widgetsMainLink;
	
	@FindBy(linkText="Hourly")
	public WebElement widgetsHourlyLink;
	
	@FindBy(partialLinkText="Chart")
	public WebElement widgetsChartLink;
	
	@FindBy(id="tab-map")
	public WebElement widgetsMapLink;
	
	@FindBy(className="weather-forecast-graphic__header")
	public WebElement widgetGraphicHeader;
	
	@FindBy(linkText="Daily")
	public WebElement widgetsDailyLink;
	
	@FindBy(xpath="//a[contains(text(),'More weather in your city')]")
	public WebElement moreWeatherBtn;
	
	@FindBy(xpath="//*[@class='owm-agro__card']//a[contains(@href,'agromonitoring')]")
	public WebElement agroWebLink;
	
	@FindBy(xpath="//a[contains(text(),'blog')]")
	public WebElement agroBlogLink;
	
	@FindBy(xpath="//img[contains(@src,\"mainpage_banner_s2\")]")
	public WebElement agroImage;
	
	@FindBy(xpath="//a[@class='btn btn-orange owm-agro__btn'][contains(text(),'How to start')]")
	public WebElement agroHowToStart;
	
	@FindBy(xpath="//img[contains(@src,\"img-agro-banner\")]")
	public WebElement agroImageAPI;
	
	@FindBy(xpath="//a[contains(text(),'Move to agromonitoring.com')]")
	public WebElement moveToAgroBtn;
	
	@FindBy(xpath="//h3[contains(text(),'Weather in your city')]")
	public WebElement weatherinurctFooter;
	
	@FindBy(linkText="Find your city")
	public WebElement findurctLink;
	
	@FindBy(linkText="Weather maps")
	public WebElement wmapsLink;
	
	@FindBy(xpath="//h3[@class='text-color'][contains(text(),'Weather APIs')]")
	public WebElement weatherapiFooter;
	
	@FindBy(xpath="//a[@href='../appid']")
	public WebElement howtostrtLink;
	
	@FindBy(linkText="Current weather")
	public WebElement cweatherLink;
	
	@FindBy(linkText="Weather APIs for developers")
	public WebElement weatherAPILink;
	
	@FindBy(linkText="5 day / 3 hour weather forecast")
	public WebElement wforecast53Link;
	
	@FindBy(linkText="16 day / daily weather forecast")
	public WebElement wforecast16Link;
	
	@FindBy(linkText="Hourly historical data")
	public WebElement historicalLink;
	
	@FindBy(linkText="History bulk")
	public WebElement historybulkLink;
	
	@FindBy(linkText="Examples of API use")
	public WebElement apiuseLink;
	
	@FindBy(xpath="//h3[contains(text(),'Map layers')]")
	public WebElement mapslayersFooter;
	
	@FindBy(partialLinkText="Examples of weather map layers")
	public WebElement mapslayerLink;
	
	@FindBy(partialLinkText="Map styles legend")
	public WebElement stylelengenLink;
	
	@FindBy(partialLinkText="Libraries to connect weather layers")
	public WebElement weatherlayerLink;
	
	@FindBy(xpath="//h3[contains(text(),'How to subscribe')]")
	public WebElement subscribeFooter;
	
	@FindBy(linkText="Price-list")
	public WebElement pricelistLink;
	
	@FindBy(linkText="Subscribe to APIs")
	public WebElement subtoapiLink;
	
	@FindBy(xpath="//div[@class='content']//div[@class='alert alert-info']")
	public WebElement alertFooter;
	
	@FindBy(xpath="//div[@class='content']//a[@class='alert-link'][contains(text(),'Support center')]")
	public WebElement supportcenterFooter;
	
	@FindBy(xpath="//h3[contains(text(),'Weather station network')]")
	public WebElement stationFooter;
	
	@FindBy(linkText="How to connect your weather station")
	public WebElement stationLink;
	
	@FindBy(xpath="//h3[contains(text(),'About')]")
	public WebElement aboutFooter;
	
	@FindBy(linkText="About company")
	public WebElement aboutcmpLink;
	
	@FindBy(linkText="Team")
	public WebElement teamLink;
	
	@FindBy(linkText="Weather model")
	public WebElement modelLink;
	
	@FindBy(linkText="Terms and conditions of sale")
	public WebElement tncsaleLink;
	
	@FindBy(linkText="Privacy policy")
	public WebElement policyLink;
	
	@FindBy(linkText="Websites terms and conditions of use")
	public WebElement tncuseLink;
	
	@FindBy(linkText="Our team")
	public WebElement ourteamLink;
	
	@FindBy(xpath="//div[@class='col-sm-12']//p[2]")
	public WebElement copyrightsFooter;
	
	@FindBy(className="stick-footer-panel__description")
	public WebElement copyrightsdescFooter;
	
	@FindBy(partialLinkText="privacy policy")
	public WebElement copyrightsppLink;

}
