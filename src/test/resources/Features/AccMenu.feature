@AccMenu @regression
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

  @accountSetting @Smoke @accSetting_smoke_002  @accSetting_smoke_003
  Scenario Outline: Verify all elements of the Account Settings Page. (buttons,links,fields,etc)
    When User clicks on account setting from account menu
    Then User reaches on page "<pageTitle>"
    And User verifies other elements on account setting page
    Examples:
      | pageTitle              |
      | Account Settings - CCM |


  @AccountSettingSmoke @Smoke  @accSetting_smoke_001
  Scenario Outline: Verify the redirection by clicking Account Settings (Account Management<Account Settings)
    When User clicks on account setting from account menu
    Then User reaches on page "<pageTitle>"
    Examples:
      | pageTitle              |
      | Account Settings - CCM |
      
      
   
  @UploadLogo @Smoke  @accSetting_smoke_003
  Scenario Outline: Validate Customer Admin can upload the company logo from the account settings screen
    When User clicks on account setting from account menu
    Then User reaches on page "<pageTitle>"
    Then User clicks on browse button
    When User selects image from local files
    Then User clicks on save
   #The alert message will be displayed when we upload photo as per criteria so for now it is commented
    And User receives successful alert message on account setting page
    Examples:
      | pageTitle              |
      | Account Settings - CCM |   
      

  @addOfUse
  Scenario Outline: Validate address of use option from account menu
    When User clicks on address of use from account menu
    Then User reaches on page "<pageTitle>"
    And  User clicks on edit and update button
    Examples:
      |pageTitle    |
      |Address of Use - CCM|

  @catalogRestriction
  Scenario Outline: Validate catalog restriction option from account menu
    When User clicks on catalog restriction from account menu
    Then User reaches on page "<pageTitle>"
    Then User verifies presence of other elements from catalog restriction page
    Then User logs out
    Examples:
      |pageTitle    |
      |Catalog Restrictions - CCM|

  	
   @changePassword 
    Scenario Outline: Case1: User tries to change password with invalid credentials and fails
    When User clicks on change password from account menu
    Then User reaches on page "<pageTitle>"
    And User clicks on save button
    Then User gets an alert message for password field is required
    When User provides incorrect current password "<current_password>"
    When User provides new password "<new_password>" 
    When User confirms password "<confirm_pass>"
    And User clicks on save button
    Then User gets an alert message for providing incorrect password
    And User clicks on cancel button
    Examples:
    | current_password   |new_password | confirm_pass |pageTitle|
    |Helloo@1            |Password@5   | Password@5   |Change Password - CCM|
    
    
    
  @changePasswordPage @Smoke @changePassword_smoke_002
    Scenario Outline: Verify all elements of the Change Password Page. (buttons,links,fields,etc)
    When User clicks on change password from account menu
    Then User reaches on page "<pageTitle>"
    And User verifies the presence of all elements on change password page
    Examples:
    |pageTitle|
    |Change Password - CCM|
    
    
   @changePassword3 @Smoke @changePassword_smoke_003
    Scenario Outline: Verify the following on Change Password Page: User can change his password from the Change Password screen under My Account
    When User clicks on change password from account menu
    Then User reaches on page "<pageTitle>"
    When User provides correct current password "<current_password>"
    When User provide less than 8 digit new password "<new_password>" 
    When User confirm less than 8 digit password "<confirm_pass>"
    #And User clicks on save button
    #Then User gets an alert message for successfully changing password
    Examples:
    |current_password   |new_password | confirm_pass    |pageTitle| 
    |Password@12         |Password@1  | Password@1      |Change Password - CCM|
   
   
 @ChangePassSmoke @Smoke @changePassword_smoke_001
  Scenario Outline: Verify the redirection by clicking Change Password (Account Management<Change Password )
    When User clicks on change password from account menu
    Then User reaches on page "<pageTitle>"
    Examples:
      | pageTitle        |
      | Change Password - CCM |
      

   @changePassword1 
    Scenario Outline: Case2: User tries to change password with invalid credentials and fails
    When User clicks on change password from account menu
    Then User reaches on page "<pageTitle>"
    When User provide correct current password "<current_password>"
    When User provide incorrect new password "<new_password>" 
    When User confirm incorrect confirm password "<confirm_pass>"
    And User clicks on save button
    Then User gets an alert message for not matching new password with confirm password
    And User clicks on cancel button
    Examples:
    | current_password   |new_password | confirm_pass |pageTitle| 
    |Password@1          | abcd1       | abcd         |Change Password - CCM|
  
  
  @changePassword2 
    Scenario Outline: Case3: User tries to change password with invalid credentials and fails
    When User clicks on change password from account menu
    Then User reaches on page "<pageTitle>"
    When User provides correct current password "<current_password>"
    When User provide less than 8 digit new password "<new_password>" 
    When User confirm less than 8 digit password "<confirm_pass>"
    And User clicks on save button
    Then User gets an alert message for not providing 8 digits password
    And User clicks on cancel button
    Examples:
    | current_password   |new_password | confirm_pass |pageTitle| 
    |Password@1          | test@12     | test@12      |Change Password - CCM|

      
  @MyProfileSmoke @Smoke @profile_smoke_001
  Scenario Outline: Verify the redirection by clicking User Profile (Account Management<User Profile)
    When User clicks on My Profile from account menu
    Then User reaches on page "<pageTitle>"
    Examples:
      | pageTitle        |
      | My Profile - CCM |    
      

  @myProfle @Smoke  @profile_smoke_003
  Scenario Outline: Verify the following on User Profile Page: The User can view the profile details that he has provided on the Create Account screen .The user can edit some details of his personal profile
    When User clicks on My Profile from account menu
    Then User reaches on page "<pageTitle>"
    And User fetches details
    And User clicks on edit button
    Then User passes phone "<phone>" and scrolls down
    And User clicks on save button my profile
    And User clicks on edit button
    And User passes new values for name "<FName>"
    And User passes new values for lastname "<LName>"
    And User clicks on save button my profile
    Examples:
      | pageTitle        | phone        | FName        | LName        |
      | My Profile - CCM | 921.749.8256 | Testerqa2023 | Testerqa2023 |
      
      
  @EditProfile @Smoke  @profile_smoke_002
  Scenario Outline: Verify all elements of the User Profile Page. (buttons,links,fields,etc)
    When User clicks on My Profile from account menu
    Then User reaches on page "<pageTitle>"
    And User fetches details
    And User clicks on edit button
    Then User reaches on page "<pageTitle1>"
    And User scrolls down
    And User clicks on save button my profile
    Examples:
      | pageTitle        | pageTitle1         |
      | My Profile - CCM | Edit Profile - CCM |    
      

  @NotificationManagement
  Scenario Outline: Validate notification management option from account menu
    When User clicks on Notifications Management from account menu
    Then User reaches on page "<pageTitle>"
    And User verifies edit check box by getting alert message
    And User click on element
    And User clicks on save button of notification management
    Then User clicks cancel button on notification page
    Then User scrolls up
    Then User logs out
    Examples:
      | pageTitle                     |
      | Notification Management - CCM |

  @paymentMethodPage
  Scenario Outline: Validate payment method from Account Menu and add credit card details
    When User clicks on payment method from account menu
    Then User reaches on page "<pageTitle>"
    And User clicks on change payment button
    And User clicks on add a credit card button
    Then User provide all the credentials
    And User clicks on save button on payment page
    Then User clicks on cancel button on payment page
    Then User logs out
    Examples:
      |pageTitle    |
      |Payment Method - CCM|

  @InvalidCred
  Scenario Outline: Validate specific case during login
    Then User logs out
    When User inserts the Username "<creds>"
    And User inserts the password "<creds>"
    And User clicks on login button
    Then User gets alert message of invalid credentials
    Examples:
      |creds       |
      |specificCase|
      
    
 
  
    