@OldRegression @regression
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


  @Home
  Scenario Outline: Validate home page and checks the presence of tabs
    When User clicks on market place link after reaching home page
    Then User reaches on page "<pageTitle>"
    Then User checks if Manage link is available
    Then User checks if MarketPlace link is available
    Then User checks if Insight link is available
    And User verifies the presence of Discover link on home page
    And User verifies the presence of Application link on home page
    And User verifies the presence of Infrastructure link on home page
    And User verifies the presence of Platform link on home page
    And User verifies the presence of DFD Banner on home page
    Examples:
      | pageTitle        |
      | Marketplace - CCM |

  @NotificationPage
  Scenario Outline: Validate notification page by clicking on it
    When User clicks on notification link
    Then User reaches on page "<pageTitle>"
    Examples:
      |pageTitle|
      |Notifications - CCM|

  @InviteUserManagement
  Scenario Outline: Validate invite email from User management page
    When User clicks on User management from account menu
    Then User reaches on page "<pageTitle>"
    Then User clicks on invite tab
    And User generate random email and pass it to email textbox
    And User clicks on invite button
    Then User clears email textbox
    And User pass another randomly generated email and clicks on invite
    Then User clears email textbox
    And User pass another randomly generated email again and clicks on invite button
    Then User prints alert message
    And User scrolls down
    Then User cancel invite and clicks on resend button
    Examples:
      |pageTitle|
      |User Management - CCM|

  @SearchUser
  Scenario Outline: Validate search user on user management page
    When User clicks on User management from account menu
    Then User reaches on page "<pageTitle>"
    Then User clicks on user tab
    And User passes "<value>" to search bar
    Examples:
      | pageTitle           |value  |
      |User Management - CCM|CCM    |

  @AccountDomain
  Scenario Outline: Validate manage domain by clicking on it
    Then User clicks on account domains from account menu
    Then User reaches on page "<pageTitle>"
    Examples:
      | pageTitle |
      | Account Domains - CCM  |



  @AddressOFUse
  Scenario Outline: Validate address of use by providing details
    When User clicks on address of use from account menu
    Then User reaches on page "<pageTitle>"
    Then User clicks on req address button
    And User sends "<textbox>" to address textbox
    And User sends "<address>" to address field
    And User sends "<zipcode>" to zipcode field
    And User sends "<phone>" to phone textbox
    Then User clicks on submit button on addofUse page
    And User checks if validate message is displayed
    When User refreshes the page
    Then User clicks on req address button
    And User sends "<textbox>" to address textbox
    And User sends "<address>" to address field
    And User sends "<zipcode>" to zipcode field
    And User sends "<phone>" to phone textbox
    Then User clicks on submit button on addofUse page
    And User checks if validate message is displayed
    Examples:
      | pageTitle            | textbox | address       | zipcode | phone      |
      | Address of Use - CCM | Houston | 756 Concho Ln | 77084   | 7138370311 |

  @CatalogRestrictions
  Scenario Outline: Validate catalog restriction from account menu
    When User clicks on catalog restriction from account menu
    Then User reaches on page "<pageTitle>"
    When User checks Restricted button is displayed
    Then User clicks on unrestricted button
    And User clicks on checkbox
    When User clicks on restrict button
    Then User checks successful alert message
    Then User sends "<value>" on search box
    And User checks if checkbox is displayed
    When User clicks on restricted button
    And User selects all
    Then User clicks on unrestrict button
    Then User verifies successful alert message is displayed
    Examples:
      | pageTitle                  | value |
      | Catalog Restrictions - CCM | corp  |

  @ChangePassword 
  Scenario Outline: User tries to change password with invalid credentials and fails
    When User clicks on change password from account menu
    Then User reaches on page "<pageTitle>"
    When User provides correct current password "<current_password>"
    When User provide less than 8 digit new password "<new_password>"
    When User confirm less than 8 digit password "<confirm_pass>"
    And User clicks on save button
    Then User gets an alert message for not providing 8 digits password
    And User clicks on cancel button
    Examples:
      | current_password | new_password | confirm_pass | pageTitle             |
      | Password@1       | abcd         | abcd         | Change Password - CCM |

  @PaymentMethod
  Scenario Outline: Validate payment method by clicking on it
    When User clicks on payment method from account menu
    Then User reaches on page "<pageTitle>"
    Examples:
      | pageTitle            |
      | Payment Method - CCM |

 
  @ApplicationLink
  Scenario Outline: Validate application link by clicking on it
    When User clicks on Application tab
    Then User reaches on page "<pageTitle>"
    Examples:
      | pageTitle          |
      | Applications - CCM |

  @InfrastructureLink
  Scenario Outline: Validate Infrastructure link
    When User clicks on infrastructure from home page
    Then User reaches on page "<pageTitle>"
    Examples:
      | pageTitle            |
      | Infrastructure - CCM |

  @PlatformPage
  Scenario Outline: Validate Platform link
    When User clicks on Platform from home page
    Then User reaches on page "<pageTitle>"
    Examples:
      | pageTitle       |
      | Platforms - CCM |

  @SearchTab
  Scenario Outline: Validate Search tab and checks product size
    When User types on global search tab "<tab1>"
    Then User gets product size
    Examples:
      | tab1      |
      | Microsoft |

  @LogOut
  Scenario Outline: Validate logout
    When User clicks on account menu link
    Then User clicks on logout option from account menu
    Then User reaches on page "<pageTitle>"
    Examples:
      | pageTitle   |
      | Login - CCM |

  @LockedUser
  Scenario Outline: Validate locked User
    Then User logs out
    Then User reaches on page "<pageTitle>"
    When User inserts the Username "<cred>"
    And User inserts the password "<cred>"
    And User clicks on login button
    Then User clears email text box
    When User inserts the Username "<cred>"
    And User inserts the password "<cred>"
    And User clicks on login button
    Then User clears email text box
    When User inserts the Username "<cred>"
    And User inserts the password "<cred>"
    And User clicks on login button
    Examples:
      | cred       | pageTitle   |
      | LockedUser | Login - CCM |


 
 