package stepDefinitions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.owm.baseTest.TestBase;
import com.saucelabs.saucerest.SauceREST;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	TestBase testbase = new TestBase();
	public static final Logger log = Logger.getLogger(Hooks.class);
	
	@Before("@Chrome")
	public void intializeChromeTest(Scenario scenario) throws IOException {
		TestBase.Intialization("chrome",scenario.getName());
		log.info("Execution of "+ scenario.getName() +" started");
	}
	
	@Before("@Firefox")
	public void intializeFireFoxTest(Scenario scenario) throws IOException {
		log.info("Firefox browser invoked");
		TestBase.Intialization("firefox",scenario.getName());
		log.info("Execution of "+ scenario.getName() +" started");
	}
	
	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {

			try {
				log.info("Execution of " + scenario.getName() + " is Failed");
				final byte[] screenshot = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png"); // ... and embed it in
				SauceREST client = new SauceREST(TestBase.USERNAME,TestBase.ACCESS_KEY);
				Map<String, Object> updates = new HashMap<>();
				updates.put("failed", scenario.isFailed());
				client.updateJobInfo(TestBase.sessionId, updates);
			} catch (WebDriverException e) {
				e.printStackTrace();
			}

		} else {
			try {
				log.info("Execution of " + scenario.getName() + " is pass");
				scenario.embed(((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES), "image/png");
				SauceREST client = new SauceREST(TestBase.USERNAME,TestBase.ACCESS_KEY);
				Map<String, Object> updates = new HashMap<>();
				updates.put("passed", !scenario.isFailed());
				client.updateJobInfo(TestBase.sessionId, updates);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		TestBase.driver.quit();
	}


}
