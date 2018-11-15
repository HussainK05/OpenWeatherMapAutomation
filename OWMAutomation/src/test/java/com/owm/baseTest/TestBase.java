package com.owm.baseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.owm.testUtil.TestUtil;

public class TestBase {
	
	public static String USERNAME = null;
	public static String ACCESS_KEY = null;
	public static String URL = null;
	public static String sessionId;
	public static WebDriver driver;
	public static Properties prop;
	public static String currentDir = System.getProperty("user.dir");
	public static String browser;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(currentDir + "/config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void Intialization(String browserName, String scenarioName) throws IOException {
		String baseUrl = prop.getProperty("url");
		browser = browserName;
		USERNAME = prop.getProperty("saucelabusername");
		ACCESS_KEY = prop.getProperty("saucelabaccesskey");
		URL= "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
		DesiredCapabilities caps = new DesiredCapabilities();
		

		/*if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",currentDir+"/drivers/chromedriver.exe");
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("firefox")){
			System.out.println(browserName);
			System.setProperty("webdriver.gecko.driver",currentDir+"/drivers/geckodriver.exe");	
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("geo.enabled", true);
			profile.setPreference("geo.provider.use_corelocation", true);
			profile.setPreference("geo.prompt.testing", true);
			profile.setPreference("geo.prompt.testing.allow", true);
		    FirefoxOptions firefoxOptions = new FirefoxOptions();
		    firefoxOptions.setProfile(profile);
			driver = new FirefoxDriver(firefoxOptions);
		}*/
		
		switch(browserName){
		case "chrome":
			caps.setCapability("name",scenarioName);
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("browserName", browserName);
			caps.setCapability("version", "latest");
			caps.setCapability("passed", "true");
			caps.setCapability("build", "OWMAutomation_Chrome_Final");
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			Map<String, Object> profileChrome = new HashMap<String, Object>();
			Map<String, Object> contentSettings = new HashMap<String, Object>();
			contentSettings.put("geolocation", 1);
			profileChrome.put("managed_default_content_settings", contentSettings);
			prefs.put("profile", profileChrome);
			options.setExperimentalOption("prefs", prefs);
			caps.setCapability(ChromeOptions.CAPABILITY, options);
			break;
		case "firefox":
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("geo.enabled", true);
			profile.setPreference("geo.provider.use_corelocation", true);
			profile.setPreference("geo.prompt.testing", true);
			profile.setPreference("geo.prompt.testing.allow", true);
			caps.setCapability("name",scenarioName);
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("browserName", browserName);
			caps.setCapability("version", "63.0");
			caps.setCapability("passed", "true");
			caps.setCapability("build", "OWMAutomation_FireFox_Final");
			caps.setCapability(FirefoxDriver.PROFILE, profile);
			break;
		}
		driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		
		sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		if(browserName.equals("chrome")) {
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		}
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
}
