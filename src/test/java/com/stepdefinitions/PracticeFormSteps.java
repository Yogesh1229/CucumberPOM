package com.stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.pages.PracticeFormPage;
import com.qa.factory.DriverFactory;
import com.qa.utils.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PracticeFormSteps {

	private PracticeFormPage practiceFormPage = new PracticeFormPage(DriverFactory.getDriver());

	@Given("user is on registration page")
	public void user_is_on_registration_page() {
		DriverFactory.getDriver().get("https://demoqa.com/automation-practice-form");
	}

	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber)
			throws IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(
				"C:\\Users\\e5543386\\eclipse-workspace\\CucumberPOM\\TestData", "PracticeFormTestData.xlsx", sheetName,
				rowNumber);

		String firstname = testData.get(0).get("firstname");
		String lastname = testData.get(0).get("lastname");
		String email = testData.get(0).get("email");
		String number = testData.get(0).get("number");
		String subjects = testData.get(0).get("subjects");
		String address = testData.get(0).get("address");

		practiceFormPage.registerStudentInformation(firstname, lastname, email, number, subjects, address);
	}

	@Then("user registration should be successful")
	public void user_registration_should_be_successful() {
		practiceFormPage.clickSubmit();
	}
}
