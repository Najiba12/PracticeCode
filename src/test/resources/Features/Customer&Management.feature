@OldSmoke @regression
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

  @HomeSmoke
  Scenario Outline: Validate market place page and checks the presence of top links
    When User clicks on market place link after reaching home page
    Then User reaches on page "<pageTitle>"
    Then User checks if Manage link is available
    Then User checks if MarketPlace link is available
    Then User checks if Insight link is available
    And User verifies the presence of Discover link on home page
    And User verifies the presence of Application link on home page
    And User verifies the presence of Infrastructure link on home page
    And User verifies the presence of Platform link on home page
    Examples:
      | pageTitle         |
      | Marketplace - CCM |

  @ManageSmoke
  Scenario Outline: Validate manage tab along with sub tabs
    When User clicks on Manage tab
    Then User reaches on page "<pageTitle>"
    Then User verifies the presence of Subscription, Usage and Calender links
    Then User logs out
    Examples:
      | pageTitle        |
      | Subscriptions - CCM |

  @InsightSmoke
  Scenario Outline: Validate insight tab
    When User clicks on Insight link
    Then User reaches on page "<pageTitle>"
    Examples:
      | pageTitle        |
      | Spend Analysis - CCM |
      
      
	@ComaparativeAnalysis 
    Scenario Outline: Verify the redirection by clicking Insights tab (Insights<Comparative Analysis)
    When User clicks on Insight link 
    Then User reaches on page "<pageTitle>"
    Then User clicks on comparative analysis
    Then User reaches on page "<pageTitle1>"
    Then User logs out
   	Examples:
		|pageTitle1                  |pageTitle|
		|Comparative Analysis - CCM  |Spend Analysis - CCM|
		
		
	@ComaparativeAnalysisElements  
    Scenario Outline: Verify all elements of the Comparative Analysis Page. (buttons,links,fields,etc)
    When User clicks on Insight link 
    Then User reaches on page "<pageTitle>"
    Then User clicks on comparative analysis
    Then User reaches on page "<pageTitle1>"
    Then User verifies the print button
    And User verifies the presence of details written on page
    And User verifies all the buttons present on comparative analysis page
    Then User logs out
   	Examples:
		|pageTitle1                  |pageTitle|
		|Comparative Analysis - CCM  |Spend Analysis - CCM|
		
		
	@ComaparativeAnalysisGhraphs  
    Scenario Outline: Verify the presence industry type and employee graphs
    When User clicks on Insight link 
    Then User reaches on page "<pageTitle>"
    Then User clicks on comparative analysis
    Then User reaches on page "<pageTitle1>"
    Then User verifies the print button
    And User verifies the presence of industry type
    And User verifies the presence of employee size
    Then User logs out
   	Examples:
		|pageTitle1                  |pageTitle|
		|Comparative Analysis - CCM  |Spend Analysis - CCM|
		
		
  @NotiSmoke
  Scenario Outline: Validate notification button on home page
    When User clicks on notification link
    Then User reaches on page "<pageTitle>"
    Then User gets all notifications, headings and flag
    Then User logs out
    Examples:
      | pageTitle           |
      | Notifications - CCM |

  @LogoSmoke
  Scenario: Validate logo
    When User clicks on logo
    Then Verify User is on home page



  @EditSmoke
  Scenario Outline: Validate edit profile
    When User clicks on My Profile from account menu
    Then User reaches on page "<pageTitle>"
    And User fetches details
    And User clicks on edit button
    Then User verifies "<pageTitle1>"
    Examples:
      |pageTitle       | pageTitle1|
      |My Profile - CCM |Edit Profile - CCM|



  @CatalogSmoke
  Scenario Outline: Validate catalog restriction
    When User clicks on catalog restriction from account menu
    Then User reaches on page "<pageTitle>"
    Examples:
      | pageTitle                  |
      | Catalog Restrictions - CCM |

  @AccountSmoke
  Scenario Outline: Validate account domain
    Then User clicks on account domains from account menu
    Then User reaches on page "<pageTitle>"
    Then User logs out
    Examples:
      | pagetitle             |
      | Account Domains - CCM |

  @SetNotification
  Scenario Outline: Validate set notification page
    When User clicks on Notification Management option from account menu
    Then User reaches on page "<pageTitle>"
    Examples:
      | pageTitle                     |
      | Notification Management - CCM |

  @AddressSmoke
  Scenario Outline: Validate address of use page
    When User clicks on address of use from account menu
    Then User reaches on page "<pageTitle>"
    Examples:
      | pageTitle            |
      | Address of Use - CCM |

  @UserSmoke
  Scenario Outline: Validate user page
    When User clicks on User management from account menu
    Then User reaches on page "<pageTitle>"
    Examples:
      |pageTitle|
      |User Management - CCM|

  @RequestSmoke
  Scenario Outline: Validate request tab
    When User clicks on User management from account menu
    Then User reaches on page "<pageTitle>"
    When User clicks on request tab from User page
    Then User verifies whether req active is enabled or not
    Examples:
      |pageTitle|
      |User Management - CCM|

  @Invitesmoke
  Scenario Outline: Validate invite tab
    When User clicks on User management from account menu
    Then User reaches on page "<pageTitle>"
    Then User clicks on invite tab
    Examples:
      | pageTitle             |
      | User Management - CCM |

  @SearchSmoke
  Scenario Outline: Validate search tab and check record list
    When User types on global search tab "<tab1>"
    Then User verifies the presence of record list
    Examples:
      | tab1          |
      | Microsoft 365 |

  @LogoutSmoke
  Scenario Outline: Validate logout
    When User clicks on account menu link
    Then User clicks on logout option from account menu
    Then User reaches on page "<pageTitle>"
    Examples:
      | pageTitle   |
      | Login - CCM |


      
 