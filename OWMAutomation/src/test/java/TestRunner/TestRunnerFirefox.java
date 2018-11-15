package TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/E2EFeatureFirefox",
		glue= {"stepDefinitions"},
		plugin= {"pretty","html:target/site/cucumber-html-reports","json:target/cucumber1.json", "junit:target/cucumber.xml"},
		monochrome=true,
		dryRun=false,
		tags= {"@Firefox"}
		)

public class TestRunnerFirefox extends AbstractTestNGCucumberTests {

	
}
