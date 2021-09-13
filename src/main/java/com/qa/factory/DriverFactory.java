package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	
	/**
	 * This method is used to return the thread local driver on the basis of given browser
	 * @param browser
	 * @return
	 */

	public WebDriver init_driver(String browser) {

		System.out.println("Browser value is: " + browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		} else if (browser.equals("IE")) {
			WebDriverManager.iedriver().setup();
			tldriver.set(new InternetExplorerDriver());
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
	}
	
	/**
	 * this is used to get the driver with local
	 * @return
	 */

	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
}
