package com.stepdefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.pages.ProfilePage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private String title;
	private String header;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private ProfilePage profilePage = new ProfilePage(DriverFactory.getDriver());
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://demoqa.com/login");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("LoginPageTitle is: " + title);
	}
	
	@When("user gets the title of the profile page")
	public void user_gets_the_title_of_the_profile_page() {
		title = profilePage.getProfilePageTitle();
		System.out.println("Profile page title is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		Assert.assertTrue(title.contains(expectedTitle));
	}

	@When("user gets the header of the page")
	public void user_gets_the_header_of_the_page() {
		header = loginPage.getLoginHeader();
		System.out.println("Login Page Header is: " + header);
	}

	@Then("user gets the header of the profile page")
	public void user_gets_the_header_of_the_profile_page() {
		header = profilePage.getProfileHeader();
		System.out.println("Profile Page Header is: " + header);
	}

	@Then("page header should be {string}")
	public void page_header_should_be(String pageHeader) {
		Assert.assertTrue(header.contains(pageHeader));
	}

	@When("user enter username {string}")
	public void user_enter_username(String username) {
		loginPage.enterUserName(username);
	}

	@When("user enter password {string}")
	public void user_enter_password(String pwd) {
		loginPage.enterPassword(pwd);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLoginButton();
	}
}
