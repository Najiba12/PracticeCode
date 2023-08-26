@ValidatePdp @regression
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

  @ValidateSubscriptionSuite7
  Scenario Outline: Validate management subscription by updating the subscription of service
    Given User checks environment and fetches id from database and visit estimate page
    Then User verifies the page contains 404
    And User clicks on no access button
    When User clicks on Manage tab
    Then User reaches on page "<pageTitle>"
    Then User passes "<value>" to search bar of subscription page and User clicks on active and verifies the presence of element
    And User clicks on manage subscription button
    And User verifies the presence of the other elements on the page
    Then User clicks on tool tip image and fetches the text
    Then User checks the presence of elements
    And User verifies presence of contact us
    Then User clears the textbox of CTA product
    Then User fetches id from database and fetches seats from database and send it to CTA product
    And User scrolls down
    Then User clicks on update
    Then User clicks on continue update
    Then User logs out
    Examples:
      | pageTitle           | value                            |
      | Subscriptions - CCM | Corp. VIP-CMP XD for teams Level |

  @ValidateSubscriptionPartc
  Scenario Outline: Validate subscriptions by visiting the subscription page and also pass values to subcriptions search bar and fetching current seats from database
    When User clicks on Manage tab
    Then User reaches on page "<pageTitle>"
    Then User passes "<value>" to search bar of subscription page and User clicks on active and verifies the presence of element
    And User clicks on manage subscription button
    Then User checks environment and fetches current seats and pass it to CTA product quantity
    Then User clicks on update
    Then User clicks on continue update
    Then User navigates back
    Examples:
      | pageTitle           | value                                    |
      | Subscriptions - CCM | Corp. VIP-CMP XD for teams Level 1 1 - 9 |
      
      
   @ValidateCancelSubscription 
   Scenario Outline: Validate management subscription by cancelling the subscription
    When User clicks on Manage tab 
    Then User reaches on page "<pageTitle>"
    Then User passes "<value>" to search bar of subscription page and User clicks on active and verifies the presence of element
    And User clicks on manage subscription of an active service
    And User scrolls down
    Then User clicks on cancel subscriptiohn button
    #And User verifies if service is cancelled
    When User clicks on Manage tab 
    Then User reaches on page "<pageTitle>"
    Then User passes "<value>" to search bar of subscription page and User clicks on active and verifies the presence of element
    And User clicks on cancelled subscription 
    #Then User clicks on aref Get it now button on page
    Then User clicks on Get Refresh button and create Estimate
    And User clicks on get it now
    Then User reaches on page "<pageTitle1>"
    And User clicks on continue
    Then User passes "<value1>" to purchase order
    Then User clicks on continue , agree and submit order
    And User receives thank you message
    Examples:
      |pageTitle          |value                                                                                 |value1|pageTitle1|
      |Subscriptions - CCM|Corp. VIP-CMP Acrobat Sign for Enterprise Microsoft Azure Tier 6 50,000 to 99,999 Transactions|5     |Procurement - CCM|
    