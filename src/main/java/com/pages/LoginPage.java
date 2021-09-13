package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// 1. Page locators using By:
	private By userName = By.id("userName");
	private By passWord = By.id("password");
	private By loginBtn = By.id("login");
	private By loginHeader = By.className("main-header");

	// 2. Constructors
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. (All actions)
	// As all variables are private and we cannot use them out of this class
	// So we'll create getters
	// Concept of ENCAPSULATION (How to access private variables using public
	// variables)

	public void enterUserName(String username) {
		driver.findElement(userName).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passWord).sendKeys(password);
	}

	public void clickOnLoginButton() {
		driver.findElement(loginBtn).click();
	}

	public String getLoginHeader() {
		return driver.findElement(loginHeader).getText();
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public ProfilePage doLogin(String username, String password) {
		driver.findElement(userName).sendKeys(username);
		driver.findElement(passWord).sendKeys(password);
		driver.findElement(loginBtn).click();
		
		return new ProfilePage(driver);
	}
}
