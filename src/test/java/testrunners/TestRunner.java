package testrunners;

import org.testng.annotations.DataProvider;

//import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import cucumber.api.CucumberOptions;
//import cucumber.api.testng.CucumberFeatureWrapper;
//import cucumber.api.testng.TestNGCucumberRunner;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(CucumberOptions.class)
@CucumberOptions(
				 features = {"src/test/resources/AppFeatures"}, 
				 glue = { "com.stepdefinitions","AppHooks" }, 
				 monochrome = true,
				 plugin = { "pretty",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						 	"rerun:target/failedrerun.txt"
						  }
				)

public class TestRunner extends AbstractTestNGCucumberTests {
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
	
//	private TestNGCucumberRunner testNGCucumberRunner;
//	   
//	@BeforeClass(alwaysRun = true)
//	public void setUpClass() {
//		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//	}
//
//	@Test(groups = "cucumber", description = "Runs cucmber Features", dataProvider = "features")
//	public void feature(CucumberFeatureWrapper cucumberFeature) {
//		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
//	}
//
//	@DataProvider
//	public Object[][] features() {
//		return testNGCucumberRunner.provideFeatures();
//	}
//
//	@AfterClass(alwaysRun = true)
//	public void testDownClass() {
//		testNGCucumberRunner.finish();
//	}

}
