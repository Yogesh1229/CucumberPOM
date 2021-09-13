package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				 features = {"@target/failedrerun.txt"},
				 glue = { "com.stepdefinitions","AppHooks" }, 
				 monochrome = true,
				 plugin = { "pretty",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						 	"rerun:target/failedrerun.txt"
						  }
				)
public class FailedTestCasesRunner {

}
