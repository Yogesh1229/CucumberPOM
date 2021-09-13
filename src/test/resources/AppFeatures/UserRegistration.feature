Feature: User Registration 

Scenario Outline: User registration with different test data 
	Given user is on registration page 
	When user fills the form from given sheetname "<SheetName>" and rownumber <Rownumber> 
	Then user registration should be successful 
	
	Examples: 
		|SheetName|Rownumber|
		|registration|1|
		|registration|2|