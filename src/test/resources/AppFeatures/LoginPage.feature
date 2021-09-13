Feature: Login page feature

  Scenario: Login Page Title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "ToolsQA"

  Scenario: Login Page Header
    Given user is on login page
    When user gets the header of the page
    Then page header should be "Login"

  Scenario: Login with correct credentials
    Given user is on login page
    When user enter username "test1234"
    And user enter password "#T123est?"
    And user clicks on login button
    Then user gets the header of the profile page
    And page header should be "Profile"
