@LoginModule @regression
Feature: Verify Login functionality is working successfully

	@Login
	Scenario Outline: Verify user is logged in successfully
		When User inserts the Username "<cred>"
		And User inserts the password "<cred>"
		And User clicks on login button
		When User inserts validation code "<cred>"
		And User clicks on complete button
		Then Verify User is on home page
		Examples:
			| cred      |
			| loginCred |

	@wrongCredLogin
	Scenario Outline: Verify user is logged in successfully
		When User inserts the Username "<cred>"
		And User inserts the password "<cred>"
		And User clicks on login button
		Then Verify User is on home page
		Examples:
			| cred           |
			| wrongLoginCred |

	@LoginManagement
	Scenario Outline: Verify user is logged in successfully
		#Given User visits Management portal site "<mgmntUrl>"
		When User inserts the Username "<cred>"
		And User inserts the password "<cred>"
		And User clicks on login button
		And User is taken to dashboard page
		Examples:
			|mgmntUrl      | cred        |
			|UserAccessUrls| management  |