Feature: Profile Page Feature

  Background: 
    Given user has already logged in to application
      | username | password  |
      | test1234 | #T123est? |

  Scenario: Profile page header
    Given user is on profile page
    When user gets the header of the profile page
    Then page header should be "Profile"

  Scenario: Profile page title
    Given user is on profile page
    When user gets the title of the profile page
    Then page title should be "ToolsQA"

  Scenario: Profile element group section count
    Given user is on profile page
    Then user gets element group section
      | Elements                |
      | Forms                   |
      | Alerts, Frame & Windows |
      | Widgets                 |
      | Interactions            |
      | Book Store Application  |
    And element section count should be 6
