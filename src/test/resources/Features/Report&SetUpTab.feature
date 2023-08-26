 @Reports @regression
Feature: Verify report and Setup tabs on management portal  website

 Background:
    Given User visits the website "management"
    #Given User visits the website "DevMp"
    When User inserts the Username "management1"
		And User inserts the password "management1"
		And User clicks on login button
    And User is taken to dashboard page
 

  
   @E1Errortab @Smoke  @e1errors_smoke_001
    Scenario Outline: To verify all elements of the E1 Error log Page. (buttons,links,fields,etc)
    When User clicks on report tab
    Then User reaches on page "<pageTitle>"
    When User clicks on E1 Error log tab
    Then User reaches on page "<pageTitleE1Error>"
    Then User verifies the presence of buttons and links and E1 Error log text
    Examples: 
    |pageTitle              |pageTitleE1Error|
    |Billing Report - CCM   |E1 Errors/Holds Log - CCM|
    
    
    
   @EexecutionLogtab @Smoke @executionLogs_smoke_001
    Scenario Outline: To verify all elements of the execution log Page. (buttons,links,fields,etc)
    When User clicks on report tab
    Then User reaches on page "<pageTitle>"
    When User clicks on execution log tab
    Then User reaches on page "<pageTitleEexecution>"
    Then User verifies the presence of buttons and links and execution log text
    Examples: 
    |pageTitle              |pageTitleEexecution|
    |Billing Report - CCM   |Execution Logs - CCM|
    
    
   
  @CreateUserTab @Smoke  @createUser_smoke_003  @createUser_smoke_004
    Scenario Outline: To verify to Create new user successfully by entering all required details on this page
    When User clicks on User tab
    Then User reaches on page "<pageTitle>"
    When User clicks on create user
    Then User reaches on page "<pageTitleCreate>"
    And User fills out the form "<Fname>" "<LastName>" "<Role>"
    Then user gets the alert message of a new user has been created
    Examples:
     |pageTitle  |pageTitleCreate     |Fname   |LastName|Role|
     |Users - CCM|Create User - CCM   |Muhammad|Jawad   |Admin mgmnt|
     
     
  @CreateUserElements @Smoke @createUser_smoke_001 @createUser_smoke_002
    Scenario Outline: To verify all elements of create user Page. (buttons,links,fields,etc)
    When User clicks on User tab
    Then User reaches on page "<pageTitle>"
    Then User verifies all elements of user Page
    Examples:
     |pageTitle  |
     |Users - CCM|
     
     
  @CreateRolepage @Smoke @roles_smoke_002
    Scenario Outline: To verify all elements of role Page. (buttons,links,fields,etc)
   When User clicks on User tab
   Then User reaches on page "<pageTitle>"
   When User hovers on User tab
   Then User checks the option appeared User tab
   And User clicks on role link
   Then User reaches on page "<UserRolepageTitle>"
   Then User verifies all elements of role Page
    Examples:
     |pageTitle  |UserRolepageTitle|AddNewRolepageTitle|
     |Users - CCM|Roles - CCM      |Add New Role - CCM |
     
     
      
  @EditRole @Smoke
    Scenario Outline: To edit the current role
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
   Then User changes role name
   Then User clicks on save button
   Then User verifies the role being edited
    Examples:
     |pageTitle  |UserRolepageTitle|AddNewRolepageTitle|EditRolepageTitle|
     |Users - CCM|Roles - CCM      |Add New Role - CCM |Edit Role - CCM  |
     
  
  @CreateRole @Smoke 
    Scenario Outline: To edit the current role
   When User clicks on User tab
   Then User reaches on page "<pageTitle>"
   When User hovers on User tab
   Then User checks the option appeared User tab
   And User clicks on role link
   Then User reaches on page "<UserRolepageTitle>"
   When User clicks on add new role button
   Then User reaches on page "<AddNewRolepageTitle>"
   Then User enters role name
   Then User clicks on save button
   Then User gets alert message on creating new role
    Examples:
     |pageTitle  |UserRolepageTitle|AddNewRolepageTitle|EditRolepageTitle|
     |Users - CCM|Roles - CCM      |Add New Role - CCM |Edit Role - CCM  |
   
                    
  
  @changePasswordElements @Smoke @changePass_smoke_001 @changePass_smoke_002
    Scenario Outline: To verify all elements of the Change Password Page. (buttons,links,fields,etc)
    When User clicks on change password from account menu
    Then User reaches on page "<pageTitle>"
    Then User verifies the presence of all elements

    Examples:
      |pageTitle            |
     |Change Password - CCM|
    
    
    
    
 @changePasswordManagement @Smoke @changePass_smoke_003
    Scenario Outline: To change the existing password for the currently logged in user
    When User clicks on change password from account menu
    Then User reaches on page "<pageTitle>"
    When User provides incorrect current password "<current_password>"
    When User provides new password "<new_password>" 
    When User confirms password "<confirm_pass>"
    #And User clicks on save button
    #Then User gets an alert message of successfully changing password
    #Then User reaches on page "<pageTitleLogin>"

    Examples:
    |current_password    |new_password     | confirm_pass     |pageTitle            |pageTitleLogin|
    |Password@12         |Connection@123   | Connection@123   |Change Password - CCM|Login - CCM|




