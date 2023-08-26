@GlobalSearch @regression
Feature: Test Global search from customer portal

Background:
    Given User visits the website "Customer"
    #Given User visits the website "DevCp"
    When User inserts the Username "loginCred"
    And User inserts the password "loginCred"
    And User clicks on login button
    When User inserts validation code "loginCred"
    And User clicks on complete button
    Then Verify User is on home page
    
	@Global
	Scenario Outline: Validate global search tab by entering values into it
		When User types on global search tab "<tab1>"
		Then User is taken to no result found page
		When User types on global search tab "<tab>"
		Then User clicks on dropdown options of prices
		Then User clicks on dropdown options of sizes
		And User checks drop down option for prices
		And User checks drop down options for sizes
		Examples:
			| cred      | tab       | tab1 |
			| loginCred | Microsoft | abc  |

	@Estimate
	Scenario Outline: Validate golabl search and also validate PDP get estimate
		When User types on global search tab "<tab>"
		And User scrolls down
		Then User clicks on aref Get it now button
		Then User clicks on Get Refresh button and create Estimate
		Examples:
			| cred        | tab       |
			| loginCred   | CSP       | 
			
		