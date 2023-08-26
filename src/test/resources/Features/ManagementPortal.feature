@OldSmokeManagement @regression
Feature: Verify management portal  website

 Background:
     Given User visits the website "management"
    #Given User visits the website "DevMp"
    When User inserts the Username "management1"
		And User inserts the password "management1"
		And User clicks on login button
    And User is taken to dashboard page


 @LoginPageElements @Smoke @login_smoke_001  @login_smoke_002  @login_smoke_003  @login_smoke_004  @login_smoke_005  @login_smoke_006  @login_smoke_007
    Scenario Outline: To verify that user can navigate to the Management portal by using the correct url and also verifies the presence of elements on login page.
    Then User logs out
    Then User reaches on page "<pageTitle>"
    And User verifies the presence of all elements on login page
    Examples:
   |pageTitle      |ForgotpageTitle|email|
   |Login - CCM    |Forgot Password - CCM|ccptestmgmt2@arpatech.com|

  
  @forgotPasswordPageSmoke @Smoke @forgotPassword_smoke_003
    Scenario Outline: To verify that a password reset link has been emailed management user email account on file
    Then User logs out
    Then User reaches on page "<pageTitle>"
    When User clicks on forgot password link from login page
    Then User reaches on page "<ForgotpageTitle>"
    And User enters email address "<email>"
    Then User clicks on submit button
    And User verifies the presence of alert message
    Examples:
   |pageTitle      |ForgotpageTitle|email|
   |Login - CCM    |Forgot Password - CCM|ccptestmgmt2@arpatech.com|
   
   
   @forgotPasswordElementsSmoke @Smoke @forgotPassword_smoke_001 @forgotPassword_smoke_002
    Scenario Outline: To verify that user can see email field and to verify that user can see submit button at the bottom of email field
    Then User logs out
    Then User reaches on page "<pageTitle>"
    When User clicks on forgot password link from login page
    Then User reaches on page "<ForgotpageTitle>"
    And User verifies the presence of all elements on forgot password page
    Examples:
   |pageTitle      |ForgotpageTitle|email|
   |Login - CCM    |Forgot Password - CCM|ccptestmgmt2@arpatech.com|
   
  
  @ManagementPortal
    Scenario: Validate management login page  
    Then User checks presence of customer tab
    And  User checks presence of catalog tab
    And  User checks presence of fullfilment tab
    And  User checks presence of Reports tab
    And  User checks presence of User tab
    And  User checks presence of Account Menu
    And  User checks presence of Logout            
 
   
   
   @Setup 
    Scenario Outline: Validate management setUp tab
    When User clicks on User tab
    Then User reaches on page "<pageTitle>"
    And User checks presence of User, Setting and jobs
    Examples:
     |pageTitle|
     |Users - CCM|



  @UserTab @Smoke  @roles_smoke_001
   Scenario Outline: To verify the redirection by clicking Set Up tab (Set Up<Roles )
   When User clicks on User tab
   Then User reaches on page "<pageTitle>"
   When User hovers on User tab
   Then User checks the option appeared User tab
   And User clicks on role link
   Then User reaches on page "<UserRolepageTitle>"
   When User clicks on add new role button
   Then User reaches on page "<AddNewRolepageTitle>"
   Then User navigates back to page
   When User clicks on edit button of User page
   Then User reaches on page "<EditRolepageTitle>"
   When User clicks on User setup
   Then User reaches on page "<pageTitle>"
   Examples:
  |pageTitle  |UserRolepageTitle|AddNewRolepageTitle|EditRolepageTitle|
  |Users - CCM|Roles - CCM      |Add New Role - CCM |Edit Role - CCM  |
   
   
  @Customer
   Scenario Outline: Validate account page on management portal site
   When User clicks on customer tab
   Then User reaches on page "<pageTitle>"
   When User clicks on select field button 
   And User clicks on cancel button field
   When User clicks on export button
   Then User clicks on export cancel button
   When User clicks on select field button 
   Then User resets all
    Examples:
   |pageTitle|
   |Accounts - CCM|

   
  @AccountFilter
   Scenario Outline: To verify all columns of Account Page with their filters ( also check correct information appearing for all entries)
   When User clicks on customer tab
   Then User reaches on page "<pageTitle>"
   And User clicks on "<ColNum2>" filter
   Then User clicks the option and apply 2
   Then User verifies the information appeared on column 1
   And User clicks on clear or reset button
   And User clicks on "<ColNum3>" filter
   Then User clicks the option and apply 3
   Then User verifies the information appeared on column 2
   And User clicks on clear or reset button
   And User clicks on "<ColNum4>" filter
   Then User clicks the option and apply 4
   Then User verifies the information appeared on column 3
   And User clicks on clear or reset button
    Examples:
   |pageTitle     |ColNum3|ColNum2|ColNum1|ColNum4|ColNum5|
   |Accounts - CCM|Third  |Second |First  |Four   |Five   |
   
   
   
  @SubscriptionManamegent
   Scenario Outline: Validate subscriptions tab on management portal site
   When User clicks on customer tab
   Then User reaches on page "<pageTitle>"
   When User clicks on Subscription tab under customer tab
   Then User reaches on page "<pageTitle1>"
   When User clicks on select field button 
   And User clicks on cancel button field
   When User clicks on export button
   Then User clicks on export cancel button
   When User clicks on arrow 1 button and User clicks on edit subscription from drop down list
   And User clicks on edit cancel button
   When User clicks on select field button 
   Then User resets all
    Examples:
     |pageTitle     |pageTitle1|
     |Accounts - CCM|Subscriptions - CCM|
   
   
   
  @SubFilter 
   Scenario Outline: To verify all columns of subscription Page with their filters ( also check correct information appearing for all entries)
   When User clicks on customer tab
   Then User reaches on page "<pageTitle>"
   When User clicks on Subscription tab under customer tab
   Then User reaches on page "<pageTitle1>"
   And User clicks on "<ColNum1>" filter
   Then User clicks the option and apply 1
   Then User verifies the information appeared on column 1
   And User clicks on clear or reset button
   And User clicks on "<ColNum2>" filter
   Then User clicks the option and apply 2
   Then User verifies the information appeared on column 2
   And User clicks on clear or reset button
   And User clicks on "<ColNum3>" filter
   Then User clicks the option and apply 3
   Then User verifies the information appeared on column 3
   And User clicks on clear or reset button
    Examples:
   |pageTitle     |pageTitle1          |ColNum3|ColNum2|ColNum1|ColNum4|ColNum5|
   |Accounts - CCM|Subscriptions - CCM |Third  |Second |First  |Four   |Five   |
  
   
   
  @AssumeRole @Smoke @assume_Smoke_001
   Scenario Outline: To verify that User should be able to assume role for any customer portal account.
   When User clicks on customer tab
   Then User reaches on page "<pageTitle>"
   And User clicks on "<ColNum1>" filter
   Then User clicks the first option and apply 1
   When User clicks on arrow 1 button
   Then User clicks on Assume Role from drop down list
   Then User iterates to next window and come back
   When User clicks on subscription link from footer
   Then User navigates back to page
    Examples:
      |pageTitle| ColNum1|
      |Accounts - CCM|First  |
  
  
  @EditAccount
    Scenario Outline: Validate edit account on management portal
    When User clicks on customer tab
    Then User reaches on page "<pageTitle>"
    When User clicks on arrow 1 button
    Then User clicks on edit account
    Then User reaches on page "<EditAccountpageTitle>"
    Then User navigates back to page
    Then User reaches on page "<pageTitle>"
    When User clicks on footer logo
    And User is taken to dashboard page
    Examples:
   |pageTitle|EditAccountpageTitle|
   |Accounts - CCM|Edit Account - CCM|
  
  
 @CatalogCategory
    Scenario Outline: Validate catalog tab on manamegment portal site
    When User clicks on catalog tab
    Then User clicks on categories appeared under catalog tab
    Then User reaches on page "<pageTitle>"
    When User clicks on export button
    Then User downloads the file
    Then User clicks on export cancel button
    When User clicks on select field button 
    And User clicks on cancel button field
    When User clicks on arrow 1 button
    Then User clicks on edit category from drop down list
    And User clicks on apply button of page
    When User clicks on sync button
     Examples:
    |pageTitle|
    |Catalog Categories - CCM|


@CatalogField
    Scenario Outline: To verify select filed button on category page.
    When User clicks on catalog tab
   Then User reaches on page "<pageTitle1>"
   Then User clicks on categories appeared under catalog tab
   Then User reaches on page "<pageTitle>"
   When User clicks on select field button 
   Then User resets all
     Examples:
    |pageTitle|pageTitle1|
    |Catalog Categories - CCM|Providers - CCM|


@CategoryFilter 
   Scenario Outline: To verify all columns of category Page with their filters ( also check correct information appearing for all entries)
   When User clicks on catalog tab
   Then User reaches on page "<pageTitle1>"
   Then User clicks on categories appeared under catalog tab
   Then User reaches on page "<pageTitle>"
   And User clicks on "<ColNum1>" filter
   Then User clicks the option and apply 1
   Then User verifies the information appeared on column 0
   And User clicks on clear or reset button
   And User clicks on "<ColNum2>" filter
   Then User clicks the option and apply 2
   Then User verifies the information appeared on column 1
   And User clicks on clear or reset button
   And User clicks on "<ColNum3>" filter
   Then User clicks the option and apply 3
   Then User verifies the information appeared on column 2
   And User clicks on clear or reset button
    Examples:
   |pageTitle1          |pageTitle               |ColNum3|ColNum2|ColNum1|ColNum4|ColNum5|
   |Providers - CCM     |Catalog Categories - CCM|Third  |Second |First  |Four   |Five|
    
    
  @DomainPage
    Scenario Outline: Validate domain page on management portal
    When User clicks on customer tab
    Then User clicks on domain link under customer tab
    Then User reaches on page "<pageTitle>"
    When User clicks on export button
    Then User clicks on export cancel button
    Then User clicks on Request link under customer tab
    Then User reaches on page "<ReqpageTitle>"
    Then User clicks on net terms
    When User clicks on export button
    Then User clicks on export cancel button
    When User clicks on select field button 
    Then User resets all
     Examples:
   |pageTitle|ReqpageTitle|
   |Domains - CCM|Requests - CCM|
 
 
 
  @DomainFilter
   Scenario Outline: To verify all columns of domain Page with their filters ( also check correct information appearing for all entries)
   When User clicks on customer tab
   Then User reaches on page "<pageTitle>"
   Then User clicks on domain link under customer tab
   Then User reaches on page "<pageTitle1>"
   And User clicks on "<ColNum1>" filter
   Then User clicks the first option and apply 1
   Then User verifies the information appeared on column 0
   And User clicks on clear or reset button
   And User clicks on "<ColNum4>" filter
   Then User clicks the first option and apply 4
   Then User verifies the information appeared on column 2
   And User clicks on clear or reset button
    Examples:
   |pageTitle     |pageTitle1          |ColNum3|ColNum2|ColNum1|ColNum4|ColNum5|
   |Accounts - CCM|Domains - CCM       |Third  |Second |First  |Four   |Five   |

 
 @NotificationManagment
    Scenario Outline: Validate notification page on management portal
    When User clicks on customer tab
    Then User reaches on page "<pageTitle>"
    Then User clicks on Notification link under customer tab
    Then User reaches on page "<pageTitle1>"
    When User clicks on export button
    Then User clicks on export cancel button
    Then User clicks on send notification link
    Then User clicks on Notification link under customer tab
    Then User reaches on page "<pageTitle1>"
    When User clicks on select field button 
    Then User resets all
    Examples:
   |pageTitle1|pageTitle|
   |Notifications - CCM|Accounts - CCM|
   
   
   
   @NotiFilter 
   Scenario Outline: To verify all columns of Notification Page with their filters ( also check correct information appearing for all entries)
   When User clicks on customer tab
   Then User reaches on page "<pageTitle>"
   Then User clicks on Notification link under customer tab
   Then User reaches on page "<pageTitle1>"
   And User clicks on "<ColNum1>" filter
   Then User clicks the option and apply 1
   Then User verifies the information appeared on column 0
   And User clicks on clear or reset button
   And User clicks on "<ColNum2>" filter
   Then User clicks the option and apply 2
   Then User verifies the information appeared on column 1
   And User clicks on clear or reset button
   And User clicks on "<ColNum3>" filter
   Then User clicks the option and apply 3
   Then User verifies the information appeared on column 2
   And User clicks on clear or reset button
   And User clicks on "<ColNum4>" filter
   Then User filters out current date and clicks on apply
   Then User verifies the current date appeared on column 3
   And User clicks on clear or reset button 
  
    Examples:
   |pageTitle     |pageTitle1          |ColNum3|ColNum2|ColNum1|ColNum4|ColNum5|ColNum6|
   |Accounts - CCM|Notifications - CCM |Third  |Second |First  |Four   |Five   |Six|




@ManagementProvider
   Scenario Outline: Validate provider page elements on management portal
   When User clicks on catalog tab
   Then User reaches on page "<pageTitle>"
   When User clicks on export button
   Then User clicks on export cancel button
   When User clicks on arrow 1 button
   Then User clicks on edit provider from drop down list
   And User clicks on cancel button of provider page
   Then User navigates back to page
   When User clicks on add provider button
   Then User reaches on page "<AddProviderpageTitle>"
    Examples:
   |pageTitle               |AddProviderpageTitle|
   |Catalog Categories - CCM|Add a Provider - CCM|
   
   
 @ServiceTab1
   Scenario Outline: Validate service page on management portal
   When User clicks on catalog tab
   Then User reaches on page "<pageTitle>"
   When User clicks on service under catalog tab
   Then User reaches on page "<ServicepageTitle>"
   When User clicks on sync button on service page
   When User clicks on export button
   Then User clicks on export cancel button
   When User clicks on arrow 1 button
   Then User clicks on edit service from drop down list
   Then User reaches on page "<EditServicepageTitle>"
   Examples:
   |pageTitle               |EditServicepageTitle|ServicepageTitle|
   |Catalog Categories - CCM|Edit Services - CCM |Catalog Services - CCM|
   
  
  @RequesTab
    Scenario Outline: Validate Request tab on management portal
    When User clicks on customer tab
    Then User reaches on page "<pageTitle1>"
    Then User clicks on request tab
    Then User reaches on page "<page1>"
    Examples:
      |pageTitle1|page1|
      |Accounts - CCM|Requests - CCM|
      
      
  @RequestElements
    Scenario Outline: Verify the presence of lists of request on management portal
    When User clicks on customer tab
    Then User reaches on page "<pageTitle1>"
    Then User clicks on request tab
    Then User reaches on page "<page1>"
    And User verifies the presence of request elements
    Examples:
      |pageTitle1|page1|
      |Accounts - CCM|Requests - CCM|
      
      
  @RequestExport
    Scenario Outline: Validate export button by downloading the file
    When User clicks on customer tab
    Then User reaches on page "<pageTitle1>"
    Then User clicks on request tab
    Then User reaches on page "<page1>"
    When User clicks on export button
    Then User downloads the file
    Then User clicks on export cancel button
    When User clicks on select field button 
    Then User resets all
    Examples:
      |pageTitle1    |page1|
      |Accounts - CCM|Requests - CCM|
      
      
   @RequestMenu
    Scenario Outline: Validate expot button by downloading the file
    When User clicks on customer tab
    Then User reaches on page "<pageTitle1>"
    Then User clicks on request tab
    Then User reaches on page "<page1>"
    Then User clicks on manage notes
    When User clicks on arrow 1 button
    Then User clicks on view accounts option
    Then User reaches on page "<pageTitle1>"
    Then User clicks on request tab
    Then User reaches on page "<page1>"
    When User clicks on arrow 1 button
    Then User clicks on "<tab>" 
    Then User reaches on page "<pageSub>"
    Then User clicks on request tab
    Then User reaches on page "<page1>"
    When User clicks on arrow 1 button
    Then User clicks on "<tab1>" 
    Then User reaches on page "<pageNoti>"
    Then User clicks on request tab
    Then User reaches on page "<page1>"
    When User clicks on arrow 1 button
    Then User clicks on "<tab2>" 
    And User cancels the reject option
    Then User logs out
    Examples:
      |pageTitle1    |page1         |pageSub            |tab               |tab1              |    pageNoti|   tab2| 
      |Accounts - CCM|Requests - CCM|Subscriptions - CCM|View Subscriptions|Send Notification|Send Notification - CCM| Reject|   
      
      
  @RequestFilter
   Scenario Outline: To verify all columns of request Page with their filters ( also check correct information appearing for all entries)
   When User clicks on customer tab
   Then User reaches on page "<pageTitle>"
   Then User clicks on request tab
   Then User reaches on page "<pageTitle1>"
   And User clicks on "<ColNum1>" filter
   Then User clicks the first option and apply 1
   Then User verifies the information appeared on column 1
   And User clicks on clear or reset button
   And User clicks on "<ColNum2>" filter
   Then User filters out current date and clicks on apply button
   Then User verifies the current date appeared on column 2
   And User clicks on clear or reset button
   And User clicks on "<ColNum3>" filter
   Then User selects current date and apply
   Then User verifies the current date appeared on column 3
   And User clicks on clear or reset button
   And User clicks on "<ColNum4>" filter
   Then User clicks the option and apply 2
   Then User verifies the information appeared on column 4
   And User clicks on clear or reset button
    Examples:
   |pageTitle     |pageTitle1          |ColNum3|ColNum2|ColNum1|ColNum4|
   |Accounts - CCM|Requests - CCM      |Third  |Second |First  |Four   | 
      