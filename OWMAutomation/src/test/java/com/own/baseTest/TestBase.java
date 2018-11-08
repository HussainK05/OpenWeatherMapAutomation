package com.own.baseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.owm.testUtil.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static String currentDir = System.getProperty("user.dir");
	
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
	
	public static void Intialization() {
		String browserName = prop.getProperty("browser");
		String baseUrl = prop.getProperty("url");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",currentDir+"/drivers/chromedriver.exe");
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver",currentDir+"/drivers/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
}
