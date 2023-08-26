
@TopLinks @regression
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
    
    
  @DiscoverPage  @discover_smoke_001
  Scenario Outline: Verify the redirection by clicking Discover tab
    When User clicks on Discover link
    Then User reaches on page "<pageTitle>"
    And User gets text from first and second textbox
    Then User passes "<value>" and press continue button
    Examples:
      | value | pageTitle      |
      | 2     | Discover - CCM |
    
    

  @Discover1   @discover_smoke_002  @discover_smoke_003
  Scenario Outline: Verify the following on Discover Page:Discover comes under the Marketplace tab. The user will be able to discover the appropriate services according to his requirements by using the Discover feature. The feature has multiple steps where the user's need is identified through a series of questions.
    When User clicks on Discover link
    Then User reaches on page "<pageTitle>"
    Then User verifes the page elements
    Then User passes "<value>" and press continue button
    And User selects two checboxes and press continue
    And User again selects two checkboxes and press continue
    And User clicks on edit and clicks on continue
    And User selects "<option>" and clicks on save button
    Then User clicks on request button
    And User passes "<value1>" & clicks on request pruposal
    Then User scrolls up
    Then User logs out
    Examples:
      |value |option  |value1 |pageTitle|
      | 100  |Monthly |adasf  |Discover -CCM|


  @Discover2 
  Scenario Outline: Validate discover case two by providing details
    When User clicks on Discover link
    Then User reaches on page "<pageTitle>"
    Then User passes "<value>" and press continue button
    And User selects first two checboxes and press continue
    Then User passes "<value1>" & "<value2>" & "<value3>"
    And User scrolls down
    Then User clicks on Showers
    Then User scrolls up
    Then User logs out
    Examples:
      |value|value1           |value2  |value3|pageTitle|
      | 100 |Reserved Instance|2 Years |2     |Discover -CCM|


  @App
  Scenario Outline: Validate application tab
    When User clicks on Application tab
    Then User reaches on page "<pageTitle>"
    Then User verifies the page elements of app
    Then User counts the number of manage and getnow and print them
    Examples:
      |pageTitle    |
      |Applications - CCM|


  @AppSidelinks
  Scenario Outline: Validate application page side links along with application selected
    When User clicks on Application tab
    Then User reaches on page "<pageTitle>"
    Then User clicks on analytic check
    Then User logs out
    Examples:
      |pageTitle    |
      |Applications - CCM|


  @AppSelected
  Scenario Outline: Validate application when selected
    When User clicks on Application tab
    Then User reaches on page "<pageTitle>"
    Then User clicks on analytic check
    Then User checks application is found
    Then User logs out
    Examples:
      |pageTitle    |
      |Applications - CCM|


  @Infrastructure
  Scenario Outline: Validate catalog infrastructure
    When User clicks on infrastructure from home page
    Then User reaches on page "<pageTitle>"
    Then User verifies the elements of page
    Then User counts the number of manage and getnow and print them
    Examples:
      |pageTitle    |
      |Infrastructure - CCM|


  @InfrastructureSidelinks
  Scenario Outline: Validate catalog infrastructure side links
    When User clicks on infrastructure from home page
    Then User reaches on page "<pageTitle>"
    Then User clears icon
    Then User clicks on IaaS
    Examples:
      |pageTitle    |
      |Infrastructure - CCM|


  @InfrastructureSelected
  Scenario Outline: Validate catalog infrastructure when selected
    When User clicks on infrastructure from home page
    Then User reaches on page "<pageTitle>"
    Then User clears icon
    Then User clicks on industry type business
    Then User checks application is found
    Examples:
      |pageTitle    |
      |Infrastructure - CCM|


  @CatalogPltaform
  Scenario Outline: Validate catalog platform tab
    When User clicks on Platform from home page
    Then User reaches on page "<pageTitle>"
    Then User verifies the elements of page
    Then User counts the number of manage and getnow and print them
    And User scrolls down
    Examples:
      |pageTitle    |
      |Platforms - CCM|


  @Subscription
  Scenario Outline: Validate product management page
    When User clicks on Manage tab
    Then User reaches on page "<pageTitle>"
    Then User clicks on subscription link
    Then User passes "<value1>" to search bar of subscription page and User clicks on active and verifies the presence of element
    And User clicks on manage subscription button
    And User checks the presence of estimate
    Then User sends "<value>" to product quality
    Then User clicks on Create Estimate and cancels
    Then User visits provider portal page
    Then User checks if subscription history is present
    Then User logs out
    Examples:
      |value|value1|pageTitle|
      | 3   |Corp. VIP-CMP XD for teams Level 4 100|Subscriptions - CCM|


  @CatalogpltaformSelected
  Scenario Outline: Validate catalog platform side navigation links
    When User clicks on Platform from home page
    Then User reaches on page "<pageTitle>"
    Then User verifies category and clears icon
    Then User logs out
    Examples:
      |pageTitle    |
      |Platforms - CCM|



  @Managetab
  Scenario Outline: Validate manage tab
    When User clicks on Manage tab
    Then User reaches on page "<pageTitle>"
    Then User verifies the presence of Subscription, Usage and Calender links
    Then User logs out
    Examples:
      |pageTitle    |
      |Subscriptions - CCM|


  @Provider
  Scenario Outline: Validate spend provider by selecting provider id and name fields
    When User clicks on Insight link
    Then User reaches on page "<pageTitle>"
    Then User clicks on Invoices from report link
    And User scrolls down
    Then User clicks on first column
    And User passes "<value>" and clicks on filter icon & reset all
    And User clicks on selectfield and passes "<value1>" and apply condition
    Then User clicks on unselect all select provider ID and provider name
    And User selects provider ID and Provider Name and save
    Then User verifies the presence of selected field
    Then User clicks on reset all
    Then User logs out
    Examples:
      |value |value1 |pageTitle|
      | Microsoft CSP |Provider|Spend Analysis - CCM|


  @SpendService
  Scenario Outline: Validate spend services by selecting provider id and service name fields
    When User clicks on Insight link
    Then User reaches on page "<pageTitle>"
    Then User clicks on Invoice Details from report link
    And User scrolls down
    Then User clicks on first column
    And User passes "<value>" and clicks on filter icon & reset all
    And User clicks on selectfield and passes "<value1>" and apply condition
    Then User clicks on unselect all select provider ID and service name
    And User selects service name and Provider Name and save
    Then User verifies the presence of provider name and service name
    Then User clicks on reset all
    Then User logs out
    Examples:
      |value          |value1 |pageTitle|
      | Microsoft CSP |Provider|Spend Analysis - CCM|


  @SpendType
  Scenario Outline: Validate spend type by selecting provider name field
    When User clicks on Insight link
    Then User reaches on page "<pageTitle>"
    Then User clicks on Invoices from report link
    And User scrolls down
    Then User clicks on first column
    Then User clicks on tenent row
    And User passes "<value>" and clicks on filter icon & reset all
    And User clicks on selectfield and passes "<value1>" and apply condition
    Then User clicks on unselect all select provider name
    And User selects Provider Name and save
    Then User verifies the presence provider name
    Then User clicks on reset all
    Then User logs out
    Examples:
      |value |value1 |pageTitle|
      | Microsoft CSP |Provider|Spend Analysis - CCM|


  @SpendCategory
  Scenario Outline: Validate spend category by selecting provider name field
    When User clicks on Insight link
    Then User reaches on page "<pageTitle>"
    Then User clicks on Invoices from report link
    And User scrolls down
    Then User clicks on first column
    Then User clicks on tenent row
    And User passes "<value>" and clicks on filter icon & reset all
    And User clicks on selectfield and passes "<value1>" and apply condition
    Then User clicks on unselect all select provider name
    And User selects Provider Name and save
    Then User verifies the presence provider name
    Then User clicks on reset all
    Then User logs out
    Examples:
      |value |value1 |pageTitle|
      | Microsoft CSP |Provider| Spend Analysis - CCM|


  @Calendar
  Scenario Outline: Validate calender page
    When User clicks on Manage tab
    Then User reaches on page "<pageTitle>"
    Then User clicks on calender link
    Then User reaches on page "<pageTitle1>"
    Then User clicks on subribecal
    And User scrolls down
    And User checks environment "<envValue>" and clicks on April Month
    Then User logs out
    Examples:
      |envValue|pageTitle          |pageTitle1|
      | env    |Subscriptions - CCM|Calendar Monthly View - CCM|

  @InsightLink
  Scenario Outline: Validate insight link and also validate the dropdown options on insight page
    When User clicks on Insight link
    Then User reaches on page "<pageTitle>"
    Then User clicks on expand and collapse button
    And User selects the option from dropdown of Spend provider
    And User selects the option from dropdown of Spend category
    And User selects the option from dropdown of Spend type
    And User selects the option from dropdown of Spend services
    Then User scrolls up
    Then User logs out
    Examples:
      | pageTitle            |
      | Spend Analysis - CCM |

  @SpendProvider
  Scenario Outline: Validate spend analysis page
    When User clicks on Insight link
    Then User reaches on page "<pageTitle>"
    Then User logs out
    Examples:
      | pageTitle            |
      | Spend Analysis - CCM |

  @Auditlog
  Scenario Outline: Validate reports audit log by downloading log file and sending email
    When User clicks on Insight link
    Then User reaches on page "<pageTitle>"
    Then User clicks on audit log from report link
    Then User reaches on page "<pageTitle1>"
    Then User checks reports options are verified
    Then User clicks on export and email button
    And User scrolls down
    And User clicks on first column on page
    Then User selects today as time period
    And User selects date from today to today
    And User clicks on apply and reset all button
    Then User scrolls up
    Then User logs out
    Examples:
      | pageTitle           | pageTitle1      |
      | Subscriptions - CCM | Audit Log - CCM |

  @SignedAgrrement
  Scenario Outline: Validate reports signed agreement by downloading signed agrrement file and sending emails and also select fields
    When User clicks on Insight link
    Then User reaches on page "<pageTitle>"
    Then User clicks on Signed Agreement from report link
    Then User clicks on export and email button
    And User scrolls down
    And User clicks on first column to choose services
    Then User selects cloud service agreement and clicks on save button
    And User scrolls down
    And User clicks on select field and type "<value>"
    Then User clicks on unselect all and clicks on SKU & apply
    Then User clicks resetall
    Then User logs out
    Examples:
      | value | pageTitle            |
      | SKU   | Spend Analysis - CCM |

  @ReportsSubscription
  Scenario Outline: Validate reports Subscription by downloading subscriptions file and sending emails and also select fields
    When User clicks on Insight link
    Then User reaches on page "<pageTitle>"
    Then User clicks on Subscription from report link
    Then User clicks on export and email button
    And User scrolls down
    And User clicks on first column to choose services
    Then User clicks on apply button
    And User clicks on select field and type "<value>"
    Then User clicks on unselect all and clicks on SKU & apply
    Then User clicks on reset all
    Then User scrolls up
    Then User logs out
    Examples:
      | value | pageTitle            |
      | SKU   | Spend Analysis - CCM |

  @InvoiceDetails
  Scenario Outline: Validate reports bill line by downloading invoice details file and sending emails and also select fields
    When User clicks on Insight link
    Then User reaches on page "<pageTitle>"
    Then User clicks on Invoice Details from report link
    Then User clicks on export and email button
    And User scrolls down
    And User clicks on first column to choose services
    Then User clicks on apply button
    And User clicks on select field and type subscription "<value>"
    Then User clicks on unselect all and clicks on subscription name & apply
    Then User clicks on reset all
    Then User scrolls up
    Then User logs out
    Examples:
      | value             | pageTitle            |
      | Subscription Name | Spend Analysis - CCM |

  @Invoices
  Scenario Outline: Validate reports bills by downloading invoices file and sending emails and also select fields
    When User clicks on Insight link
    Then User reaches on page "<pageTitle>"
    Then User clicks on Invoices from report link
    Then User clicks on export and email button
    And User scrolls down
    And User clicks on first column to choose services
    Then User clicks on apply button
    And User clicks on select field and type "<value>"
    Then User clicks on unselect all and clicks on billing month & apply
    Then User clicks on reset all
    Then User scrolls up
    Then User logs out
    Examples:
      | value         | pageTitle            |
      | billing Month | Spend Analysis - CCM |

  @Orders
  Scenario Outline: Validate reports orders by downloading order file and sending emails and also select fields
    When User clicks on Insight link
    Then User reaches on page "<pageTitle>"
    Then User clicks on Orders from report link
    Then User clicks on export and email button
    And User clicks on first column from order page
    Then User clicks on apply bill button
    And User clicks on select field and type "<value>"
    Then User clicks on unselect all and clicks purchase order & apply
    Then User clicks on reset all
    Then User scrolls up
    Then User logs out
    Examples:
      |value           |pageTitle|
      |purchase Order  |Spend Analysis - CCM|