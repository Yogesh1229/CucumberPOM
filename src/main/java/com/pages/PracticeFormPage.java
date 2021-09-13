package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticeFormPage {

	private WebDriver driver;

	private By firstName = By.id("firstName");
	private By lastName = By.id("lastName");
	private By userEmail = By.id("userEmail");
	// private By gender = By.id("gender-radio-1");
	private By userNumber = By.id("userNumber");
	private By subjectsInput = By.id("subjectsInput");
	// private By hobbies = By.id("hobbies-checkbox-1");
	private By currentAddress = By.id("currentAddress");
	private By submitBtn = By.id("submit");

	public PracticeFormPage(WebDriver driver) {
		this.driver = driver;
	}

	public void registerStudentInformation(String firstname, String lastname, String email, String number,
			String subjects, String address) {
		driver.findElement(firstName).sendKeys(firstname);
		driver.findElement(lastName).sendKeys(lastname);
		driver.findElement(userEmail).sendKeys(email);
		driver.findElement(userNumber).sendKeys(number);
		driver.findElement(subjectsInput).sendKeys(subjects);
		driver.findElement(currentAddress).sendKeys(address);
	}

	public void clickSubmit() {
		driver.findElement(submitBtn).click();
	}

}
