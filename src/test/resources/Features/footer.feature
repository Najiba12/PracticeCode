@Footer @regression
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
    Then asdas a s

  @Footer
  Scenario: Verify User is logged in successfully and verify footer links
    When User checks if MarketPlace link is available
    Then User checks if Manage link is available
    Then User checks if MarketPlace link is available
    Then User checks if Insight link is available
    Then User checks if About CCM link is available
    Then User checks if About Connection link is available
    Then User checks if Contact us link is available
    Then User checks if Term of use link is available
    Then User checks if Privacy policy link is available
    Then User checks if Accessibility link is available
    Then User checks if Help link is available

  @AboutCCM
  Scenario Outline: Validate About link on footer by clicking on it
    When User scrolls down to footer in home page
    Then User clicks on about CCM
    Then User reaches on page "<pageTitle>"
    Then User checks if footer links are available
    Examples:
      |pageTitle|
      |About - CCM|

  @Connection
  Scenario Outline: Validate About_Connection link on footer by clicking on it
    When User scrolls down to footer in home page
    Then User clicks on about connection link
    Then User reaches on page "<pageTitle>"
    And  User verifies the presence of learn more button & total number of images that are displayed are fetched
    Then User checks if footer links are available
    Examples:
      |pageTitle|
      |About Connection - CCM|

  @ContactUslink
  Scenario Outline: Validate contact us link on footer by clicking on it
    When User scrolls down to footer in home page
    When User scrolls down to footer in home page
    When User clicks on contact us link
    Then User reaches on page "<ContactpageTitle>"
    Then User checks if footer links are available
    Then User checks if contact us details are present
    Then User clicks on submit button on contact page
    And User gets an alert message
    Examples:
      | ContactpageTitle |
      | Contact Us - CCM |

  @TermOfUse
  Scenario Outline: Validate term of use link by clicking on it
    When User scrolls down to footer in home page
    When User scrolls down to footer in home page
    When User clicks on terms condition link
    Then User reaches on page "<pageTitle>"
    Then User checks if footer links are available on page
    Examples:
      | pageTitle          |
      | Terms of Use - CCM |

  @PrivacyPolicy
  Scenario Outline: Validate privacy policy link by clicking on it from Term of use page
    When User scrolls down to footer in home page
    And User scrolls down
    And User scrolls down
    And User scrolls down
    When User clicks on privacy policy link on page
    Then User reaches on page "<pageTitle>"
    Then User checks if footer links are available on page
    Examples:
      |pageTitle|
      |Privacy Policy - CCM|

  @Accessibility
  Scenario Outline: Validate accessibility link by clicking on it from privacy policy page
    When User scrolls down to footer in home page
    When User clicks on Accessibility link
    Then User reaches on page "<pageTitle>"
    Then User navigates back to old window
    Examples:
      | pageTitle                         |
      | Accessibility Policy - Connection |

  @Help
  Scenario Outline: Validate help link by clicking on it
    When User scrolls down to footer in home page
    And User scrolls down
    And User scrolls down
    When User clicks on help link
    Then User reaches on page "<pageTitle0>"
    Then User clicks on marketplace present on help page if it exists
    Then User reaches on page "<pageTitle>"
    Then User clicks on Spend Analysis if it exists
    Then User reaches on page "<page_title1>"
    Then User clicks on Subscription if it exists
    Then User reaches on page "<page_title2>"
    Then User clicks on My Profile if it exists
    Then User reaches on page "<page_title3>"
    Then User clicks on Account Settings if it exists
    Then User reaches on page "<page_title4>"
    Examples:
      | page_title        | page_title1          | page_title2         | page_title3      | page_title4           |pageTitle0|
      | Marketplace - CCM | Spend Analysis - CCM | Subscriptions - CCM | My Profile - CCM | Account Settings - CCM |Help - CCM|

  @Notification
  Scenario Outline: Validate notification button on home page
    When User clicks on notification link
    Then User reaches on page "<pageTitle>"
    Then User gets all notifications, headings and flag
    Then User logs out
    Examples:
      | pageTitle           |
      | Notifications - CCM |

  @UserRole
  Scenario Outline: Validate user role
    Given User navigates to "<account_domain_url>"
    Then User navigates back
    Then User logs out
    Examples:
      | account_domain_url |
      | UserAccessUrls     |

  @404Page
  Scenario Outline: Validate 404Page by visiting it and coming back to home page
    Given User navigates to 404 page "<marketPlace_url>"
    And User clicks on no access button
    Then User reaches to home page
    Then User logs out
    Examples:
      | marketPlace_url |
      | UserAccessUrls  |

  @AccDomain
  Scenario Outline: Validate account domains from account menu
    Then User clicks on account domains from account menu
    Then User reaches on page "<pageTitle>"
    And User verifies the presence of options of account menu from account domain page
    Then User logs out
    Examples:
      | pageTitle |
      | Account Domains - CCM  |

  @AccInformation
  Scenario Outline: Validate account information from account menu
    Then User clicks on account information from account menu
    Then User reaches on page "<pageTitle>"
    And User verifies the presence of options of account menu
    Then User logs out
    Examples:
      | pageTitle |
      | Account Information - CCM  |
    
 
		           
		           