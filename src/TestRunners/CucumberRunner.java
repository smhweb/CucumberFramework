package TestRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features",
		glue = "Tests",
		monochrome = true,
		plugin = {"pretty", "junit: juni.xml/cucumber.xml"},
		dryRun = false
		)
public class CucumberRunner {

}
