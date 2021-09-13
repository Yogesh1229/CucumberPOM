package com.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.LoginPage;
import com.pages.ProfilePage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ProfilePageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private ProfilePage profilePage;
	
	@Given("user has already logged in to application")
	public ProfilePage user_has_already_logged_in_to_application(DataTable credTable) {
		List<Map<String, String>> credList = credTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		
		DriverFactory.getDriver().get("https://demoqa.com/login");
		profilePage = loginPage.doLogin(userName, password);
		
		return profilePage;
	}

	@Given("user is on profile page")
	public void user_is_on_profile_page() {
		String title = profilePage.getProfilePageTitle();
		System.out.println("Profile page title is: " + title);
	}

	@Then("user gets element group section")
	public void user_gets_element_group_section(DataTable elementSectionTable) {
		List<String> expElementSectionList = elementSectionTable.asList();
		System.out.println("Expected element section list: " + expElementSectionList);
		
		List<String> actElementSectionList = profilePage.getElementSectionsList();
		System.out.println("Actual element section list: " + actElementSectionList);
		
		Assert.assertTrue(expElementSectionList.containsAll(actElementSectionList));
	}

	@Then("element section count should be {int}")
	public void element_section_count_should_be(Integer expElementSectionCount) {
		Assert.assertTrue(profilePage.getElementSectionCount() == expElementSectionCount);
	}


}
