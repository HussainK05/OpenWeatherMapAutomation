package TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/E2EFeatureChrome",
		glue= {"stepDefinitions"},
		plugin= {"pretty","html:target/site/cucumber-html-reports","json:target/cucumber.json", "junit:target/cucumber.xml"},
		monochrome=true,
		dryRun=false,
		tags= {"@Chrome"}
		)

public class TestRunnerChrome extends AbstractTestNGCucumberTests {

	
}
