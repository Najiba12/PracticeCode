@AccountCreation @regression
Feature: Verify Login functionality is working successfully
  Background:
    Given User visits the website "Customer"
    #Given User visits the website "DevCp"
    When User inserts the Username "loginCred"
    And User inserts the password "loginCred"
    And User clicks on login button
    When User inserts validation code "loginCred"
    And User clicks on complete button
    Then Verify User is on home page


  @Headerfooter
  Scenario: Verify User is logged in successfully and visit home page and verify header and footer links
    And User scrolls down
    And User scrolls down
    And User scrolls down
    Then User clicks on footer link
    And User scrolls down
    And User scrolls down
    Then User clicks on footer links
    Then User clicks on account menu and clicks on logo
    And User verifies presence of global search and gets account initials text after checking environment
    Then User verifies the presence of account menu and bell icon
    When User checks if MarketPlace link is available
    Then User checks if Manage link is available
    Then User checks if MarketPlace link is available
    Then User checks if Insight link is available
    And User verifies the presence of Discover link on home page
    And User verifies the presence of Application link on home page
    And User verifies the presence of Infrastructure link on home page
    And User verifies the presence of Platform link on home page
    Then User verifies the presence of footer links
    Then User logs out

  @HomePage
  Scenario Outline: Verify User is logged in successfully and visit home page and verify header and footer links by clicking on them
    When User clicks on connect logo
    And User verifies presence of global search and gets account initials text after checking environment
    Then User verifies the presence of account menu and bell icon
    When User checks if MarketPlace link is available
    Then User checks if Manage link is available
    Then User checks if MarketPlace link is available
    Then User checks if Insight link is available
    And User verifies the presence of Discover link on home page
    And User verifies the presence of Application link on home page
    And User verifies the presence of Infrastructure link on home page
    And User verifies the presence of Platform link on home page
    Then User verifies the presence of footer links
    And User checks the presence of get now and manage button and social icon
    When User clicks on Discover link
    Then User reaches on page "<pageTitle>"
    And User scrolls down
    When User clicks on Application tab
    Then User reaches on page "<ApppageTitle>"
    When User clicks on infrastructure from home page
    Then User reaches on page "<pageTitle1>"
    When User clicks on Platform from home page
    Then User reaches on page "<pageTitle2>"
    When User clicks on Manage tab
    Then User reaches on page "<pageTitle3>"
    Then User clicks on usage
    Then User clicks on calendar
    Then User clicks on insight
    Then User clicks on spend analysis
    When User scrolls down to footer in home page
    And User scrolls down
    Then User clicks on orders link
    And User scrolls down
    Then User clicks on signed Agreement link
    And User scrolls down
    Then User clicks on bill lines link
    And User scrolls down
    Then User clicks on bills link
    Then User clicks on about connection link
    Then User clicks on contact us link
    And User scrolls down
    And User scrolls down
    Then User clicks on FAQ link
    When User clicks on term of use link
    Then User reaches on page "<pageTitle4>"
    When User clicks on privacy policy link
    Then User reaches on page "<pageTitle5>"
    When User clicks on Accessibility link
    Then User reaches on page "<pageTitle6>"
    Then User navigates back to old window
    When User clicks on help link
    Then User reaches on page "<HelppageTitle>"
    Examples:
      |pageTitle       |ApppageTitle      |pageTitle1          |pageTitle2      |pageTitle3         |pageTitle4        |pageTitle5          |pageTitle6                       |HelppageTitle|
      |Discover - CCM  |Applications - CCM|Infrastructure - CCM|Platforms - CCM |Subscriptions - CCM|Terms of Use - CCM|Privacy Policy - CCM|Accessibility Policy - Connection|Help - CCM|
     
     
     
 



    

		 
		 
	

    