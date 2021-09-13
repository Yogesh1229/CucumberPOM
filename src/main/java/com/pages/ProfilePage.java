package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

	private WebDriver driver;

	private By profileHeader = By.xpath("//div[contains(text(), 'Profile')]");
	private By elementSections = By.cssSelector("div.accordion div.header-text");

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getProfilePageTitle() {
		return driver.getTitle();
	}

	public String getProfileHeader() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(profileHeader));
		return driver.findElement(profileHeader).getText();
	}

	public int getElementSectionCount() {
		return driver.findElements(elementSections).size();
	}

	public List<String> getElementSectionsList() {
		List<String> elementList = new ArrayList<>();
		List<WebElement> elementSectionList = driver.findElements(elementSections);
		for (WebElement e : elementSectionList) {
			String text = e.getText();
			System.out.println("Text is: " + text);
			elementList.add(text);
		}

		return elementList;
	}
}
