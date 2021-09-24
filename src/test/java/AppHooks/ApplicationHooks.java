package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	private Properties prop;
	
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}
	
	@Before(order = 1)
	public void launchTheBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		System.out.println("Application hooks - Before");
	}
	
	@After(order = 0)
	public void quitTheBrowser() {
		driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(Scenario se) {
		System.out.println("Application hooks - after");
		if(se.isFailed()) {
			String screenShotName = se.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			se.attach(sourcePath, "image/png", screenShotName);
		}
	}
}
