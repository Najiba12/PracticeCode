@PaymentMethods @regression
Feature: Verify Login functionality is working successfully


  @procurementWithCreditCardApproved
  Scenario Outline: Validate account creation process, validate call from credit card and validate procurement with credit card approved
    Given User visits the website "management" 
    # Given User visits the website "DevMp"
    When User inserts the Username "<cred>"
    And User inserts the password "<cred>"
    And User clicks on login button
    And User is taken to dashboard page
    When User clicks on customer tab
    Then User reaches on page "<pageTitle1>"
    Then User clicks on add account button
    Then User reaches on page "<page>"
    Then User clicks on default admin
    And User provide new email generated randomly "<AccountName>" 
    Then User clicks on contibue button
    And User provides "<organization>" "<AccountName>"
    And User provides details information "<address>" "<zipCode>" "<phone>"
    And User provides personal details "<teamEmail>"
    And User provides details of billing "<address>" "<zipCode>" "<phone>"
    Then User clicks on sales division access and select division
    Then User clicks on add of use and add address button
    And User provides details of add of use "<address>" "<zipCode>" "<phone>"
    Then User clicks on save button of add of use
    Then User clicks on resend email
    Then User reaches on page "<page1>"
    Then User clicks on row and resend
    Then User reaches on page "<page1>"
    Then User clicks on click here
    Then User reaches on page "<page2>"
    And User inserts the details "<Fname>" "<Lname>" "<job>" "<password>"
    Then User clicks on agreement
    And User inserts the password "loginCred1"
    And User clicks on login button
    When User inserts validation code "loginCred1"
    And User clicks on complete button
    Then Verify User is on home page
    When User clicks on payment method from account menu
    And User clicks on add payment button
    And User clicks on add a credit card button
    Then User provide all the credentials
    And User clicks on save button on payment page
    Then User provides "<address1>" and "<zipcode1>"
    Then User passes values to BA "<value2>" and clicks on save
    Then User closes current window
    Then User switches from current window to old window
    Then User clicks on account tab
    Then User reaches on page "<pageTitle1>"
    Then User switches from current window to old window
    Then User fetches account name
    Then User clicks on customer edit and get management edit customer
    Then User verifies presence of billing method and pass "<value3>"
    Then User clicks on customer edit save button
    And User pass "<value4>" to get account
    Then User clicks on customer edit save button
    Then User refreshes the page
    Then User clicks on request tab
    Then User reaches on page "<pageTitle>"
    Then User filters out the pending accounts
    #Then User filters out specific date and clicks on apply button
    Then User clicks on arrow and clicks on request approve
    Then User refreshes the page
    Examples:
      | mgmntUrl       | cred       | pageTitle1     | page              | page2                | organization | AccountName    | address  | zipCode | phone           | alert                  | page1              | password   | teamEmail              | Fname    | Lname | job | address1                         | zipcode1 | value2       | value3    | value4 | pagetitle      | tab1      | procurementpage   | value | env |
      | UserAccessUrls | management | Accounts - CCM | Add Account - CCM | Create Account - CCM | Arpatech     | Tester | New York | 77084   | +1-231-231-2312 | Successfully Validated | Resend Email - CCM | Password@1 | ccp.uat@connection.com | Muhammad | Jawad | IT  | 756 Concho Ln Houston, TX, 77084 | 77084    | 343.534.6346 | Net Terms | 12345  | Requests - CCM | Microsoft | Procurement - CCM | 5     | uat |

  @procurementWithNettermApproved
  Scenario Outline: Validate account creation process, validate call from net Terms and validate procurement with net terms approved
    Given User visits the website "management"
   # Given User visits the website "DevMp"
    When User inserts the Username "<cred>"
    And User inserts the password "<cred>"
    And User clicks on login button
    And User is taken to dashboard page
    When User clicks on customer tab
    Then User reaches on page "<pageTitle1>"
    Then User clicks on add account button
    Then User reaches on page "<page>"
    Then User clicks on default admin
    And User provide new email generated randomly "<AccountName>" 
    Then User clicks on contibue button
    And User provides "<organization>" "<AccountName>"
    And User provides details information "<address>" "<zipCode>" "<phone>"
    And User provides personal details "<teamEmail>"
    And User provides details of billing "<address>" "<zipCode>" "<phone>"
    Then User clicks on sales division access and select division
    Then User clicks on add of use and add address button
    And User provides details of add of use "<address>" "<zipCode>" "<phone>"
    Then User clicks on save button of add of use
    Then User clicks on resend email
    Then User reaches on page "<page1>"
    Then User clicks on row and resend
    Then User reaches on page "<page1>"
    Then User clicks on click here
    Then User reaches on page "<page2>"
    And User inserts the details "<Fname>" "<Lname>" "<job>" "<password>"
    Then User clicks on agreement
    And User inserts the password "loginCred1"
    And User clicks on login button
    When User inserts validation code "loginCred1"
    And User clicks on complete button
    Then Verify User is on home page
    When User clicks on payment method from account menu
    And User clicks on add payment button
    Then User clicks on request net terms and save button
    Then User closes current window
    Then User switches from current window to old window
    Then User clicks on account tab
    Then User reaches on page "<pageTitle1>"
    Then User switches from current window to old window
    Then User fetches account name
    Then User clicks on customer edit and get management edit customer
    Then User verifies presence of billing method and pass "<value3>"
    Then User clicks on customer edit save button
    And User pass "<value4>" to get account
    Then User clicks on customer edit save button
    Then User refreshes the page
    Then User clicks on request tab
    Then User reaches on page "<pageTitle>"
    Then User filters out the pending accounts
    #Then User filters out specific date and clicks on apply button
    Then User clicks on arrow and clicks on request approve
    Then User refreshes the page
    Examples:
      | mgmntUrl       | cred       | pageTitle1     | page              | page2                | organization | AccountName   | address  | zipCode | phone           | alert                  | page1              | password   | teamEmail              | Fname    | Lname | job | address1                         | zipcode1 | value2       | value3    | value4 | pagetitle      | tab1      | procurementpage   | value | env |
      | UserAccessUrls | management | Accounts - CCM | Add Account - CCM | Create Account - CCM | Arpatech     | Tester | New York | 77084   | +1-231-231-2312 | Successfully Validated | Resend Email - CCM | Password@1 | ccp.uat@connection.com | Muhammad | Jawad | IT  | 756 Concho Ln Houston, TX, 77084 | 77084    | 343.534.6346 | Net Terms | 12345  | Requests - CCM | Microsoft | Procurement - CCM | 5     | uat |



 @addaccount @Smoke @addAccount_smoke_001 
    Scenario Outline: Add an account for CP From account page.
    Given User visits the website "management"
    #Given User visits the website "DevMp"
    When User inserts the Username "<cred>"
		And User inserts the password "<cred>"
		And User clicks on login button
    And User is taken to dashboard page
    When User clicks on customer tab
    Then User reaches on page "<pageTitle1>"
    Then User clicks on add account button
    Then User reaches on page "<page>"
    Then User clicks on default admin
    And User provide new email generated randomly "<AccountName>" 
    #Then User clicks on contibue button
    And User provides "<organization>" "<AccountName>" 
    And User provides detail information "<address>" "<zipCode>" "<phone>"
    And User provides personal details "<teamEmail>"
    And User provides details of billing "<address>" "<zipCode>" "<phone>"
    Then User clicks on sales division access and select division
    Then User clicks on add of use and add address button
    And User provides details of add of use "<address>" "<zipCode>" "<phone>"
    Then User clicks on save button of add of use
    Then User clicks on resend email
    Then User reaches on page "<page1>"
    Then User clicks on row and resend
    Then User reaches on page "<page1>"
    Then User clicks on click here
    Then User reaches on page "<page2>"
    And User inserts the details "<Fname>" "<Lname>" "<job>" "<password>" 
    Then User clicks on agreement
    And User inserts the password "loginCred1"
    And User clicks on login button
    When User inserts validation code "loginCred1"
    And User clicks on complete button
    Then Verify User is on home page
     Examples:
  |mgmntUrl      |cred         |pageTitle1    |page             |page2               |organization|AccountName  |address |zipCode|phone           |alert                 |page1             |password  |teamEmail             |Fname     |Lname|job|address1                        |zipcode1|
  |UserAccessUrls|management1  |Accounts - CCM|Add Account - CCM|Create Account - CCM|Arpatech    |Tester       |New York|77084  |+1-231-231-2312 |Successfully Validated|Resend Email - CCM|Password@1|ccp.uat@connection.com|Tester    |Jawad|IT |756 Concho Ln Houston, TX, 77084|77084   |
 

 @ProcuringServices @Smoke @procurement_smoke_005 @procurement_smoke_006 @procurement_smoke_007 @e1Positioning_smoke_005
    Scenario Outline: Verify by procuring two to three SKUs of each provider successfully and also verifying the procurement process
    Given User visits the website "Customer"
    #Given User visits the website "DevCp"
    When User inserts the Username "<cred>"
    And User inserts the password "<cred>"
    And User clicks on login button
    When User inserts validation code "<cred>"
    And User clicks on complete button
    Then Verify User is on home page
    When User types on global search tab "<tab1>"
    And User clicks on microsoft provider
    Then User clicks on aref Get it now button
    And user fetches service name
    Then User clicks on aref Get it now button on page
    Then User reaches on page "<pageTitle1>"
    Then User passes domain name and tenant name generated randomly
    Then User checks the environment and provides all information
    And User clicks on continue
    Then User passes "<value>" to purchase order
    Then User clicks on continue , agree and submit order
    And User receives thank you message
    When User clicks on Manage tab 
    Then User reaches on page "<pageTitle>"
    Then User checks environment and pass to search bar of subscription page
    And User verifies the status of order
    When User types on global search tab "<tab2>"
    And User clicks on adobe provider
    Then User clicks on aref Get it now button
    Then User clicks on aref Get it now button on page
    Then User reaches on page "<pageTitle1>"
    Then User passes domain name and tenant name generated randomly
    Then User checks the environment and provides all information
    And User clicks on continue
    Then User passes "<value>" to purchase order
    Then User clicks on continue , agree and submit order
    And User receives thank you message
    Examples:
    | cred        |pageTitle1       | value|tab1     |tab2     |pageTitle|
    | loginCred4  |Procurement - CCM|5     |Microsoft|Acronis   |Subscriptions - CCM|
    
    
    
  @FullfilmentTab @Smoke @e1Positioning_smoke_004
   Scenario Outline: Validate the status of the order from fulfillment page
    Given User visits the website "management"
    #Given User visits the website "DevMp"
    When User inserts the Username "<cred>"
		And User inserts the password "<cred>"
		And User clicks on login button
    And User is taken to dashboard page
    When User clicks on fullfilment tab
    Then User reaches on page "<pageTitle>"
    When User clicks on select field button 
    Then User resets all
    Then User seacrhes the current order placed
    And verifies the state and status of the order
    Examples: 
    |pageTitle        |	mgmntUrl      | cred        |
    |Orders - CCM     | UserAccessUrls| management1 |


@ValidateProcurementElements @Smoke @procurement_smoke_003 
    Scenario Outline: Verify all elements of the Procurement Page. (buttons,links,fields,etc)
    Given User visits the website "Customer"
    #Given User visits the website "DevCp"
    When User inserts the Username "<cred>"
    And User inserts the password "<cred>"
    And User clicks on login button
    When User inserts validation code "<cred>"
    And User clicks on complete button
    Then Verify User is on home page
    When User types on global search tab "<tab1>"
    And User clicks on microsoft provider
    Then User clicks on aref Get it now button
    And user fetches service name
    Then User clicks on aref Get it now button on page
    Then User reaches on page "<pageTitle1>"
    Then User verifies the presence of all elements on procuremnt page
    Examples:
    | cred        |pageTitle1       |tab1 |
    | loginCred3  |Procurement - CCM|Microsoft|


  @ProcurementGetitNow @Smoke @procurement_smoke_001 
  Scenario Outline: Verify the Procurement process starts with the user clicking the Get it Now button any SKU
    Given User visits the website "Customer"
   # Given User visits the website "DevCp"
    When User inserts the Username "<cred>"
    And User inserts the password "<cred>"
    And User clicks on login button
    When User inserts validation code "<cred>"
    And User clicks on complete button
    Then Verify User is on home page
    When User clicks on infrastructure from home page
    Then User reaches on page "<pageTitle1>"
    Then User clears icon of procurement
    Then User checks get it now string
    Then User clicks on given button
    Then User checks the current url
    Examples:
      | cred         |pageTitle1|
      | loginCred5   |Infrastructure - CCM|



  @ProcurementRedirection @Smoke @procurement_smoke_002 
  Scenario Outline: Verify the redirection by clicking (Get it Now) to Procurement 
    Given User visits the website "Customer"
   # Given User visits the website "DevCp"
    When User inserts the Username "<cred>"
    And User inserts the password "<cred>"
    And User clicks on login button
    When User inserts validation code "<cred>"
    And User clicks on complete button
    Then Verify User is on home page
    When User clicks on infrastructure from home page
    Then User reaches on page "<pageTitle1>"
    Then User clears icon of procurement
    Then User checks get it now string
    Then User clicks on given button
    Then User checks the current url and validate procuremt "<page>"
    
    Examples:
      | cred          |page             |pageTitle1|
      | loginCred5    |Procurement - CCM|Infrastructure - CCM|


  @ValidateProcurment @Smoke @procurement_smoke_004
  Scenario Outline: Verify A single checkout/procurement process includes only One service (the Add-ons and Consulting of that service can also be included)
    Given User visits the website "Customer"
   # Given User visits the website "DevCp"
    When User inserts the Username "<cred>"
    And User inserts the password "<cred>"
    And User clicks on login button
    When User inserts validation code "<cred>"
    And User clicks on complete button
    Then Verify User is on home page
    When User clicks on infrastructure from home page
    Then User reaches on page "<pageTitle>"
    Then User clicks on aref Get it now button
    Then User clicks on aref Get it now button on page
    And User verifies procurement page "<page>"
    Then User passes domain name and tenant name generated randomly
    Then User checks the environment and provides all information
    And User clicks on continue
    Then User passes "<value>" to purchase order
    Then User clicks on continue , agree and submit order
    When User clicks on address of use from account menu
    Then User reaches on page "<page_title>"
    Then User clicks on related tenants
    And User clicks on cancel
    Then User clicks on related tenants
    And User clicks on show related subscription
    Then User reaches on page "<SubpageTitle>"
    Then User navigates back
    Then User clicks on add of use
    Then User passes "<value1>" and clicks on save
    Then User logs out
    Examples:
      |cred        | tab |value               |value1|page             |page_title          |SubpageTitle       |pageTitle|
      | loginCred6 | CSP |purchase order no : |35345 |Procurement - CCM|Address of Use - CCM|Subscriptions - CCM|Infrastructure - CCM|

    
    
    

  