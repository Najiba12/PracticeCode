 @CreateNewUser
Feature: Verify register link by creating a new account for customer portal


@RegisterNewAccount @Smoke  @registerNewUser_smoke_001  @registerNewUser_smoke_002  @registerNewUser_smoke_003  @registerNewUser_smoke_004  @registerNewUser_smoke_005  @registerNewUser_smoke_006  @registerNewUser_snoke_007  @registerNewUser_smoke_008  @registerNewUser_smoke_009  @registerNewUser_smoke_010  @registerNewUser_smoke_011  @registerNewUser_smoke_012  @e1Positioning_smoke_001  @e1Positioning_smoke_002  @e1Positioning_smoke_003
    Scenario Outline: Verify by creating new users. (Through register new account)
    Given User navigates to create account portal "RegisterNewAccount"
    #Given User visits the website "DevMp"
    Then User reaches on page "<page2>"
    And User provide email generated randomly "<AccountName>" 
    Then User clicks on save and contibue button
    And User provides details of organization "<organization>" "<AccountName>" 
    And User provides details "<address>" "<zipCode>" "<phone>"
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
    Given User visits the website "management"
    #Given User visits the website "DevMp"
    When User inserts the Username "<cred>"
		And User inserts the password "<cred>"
		And User clicks on login button
    And User is taken to dashboard page
    When User clicks on customer tab
    Then User reaches on page "<pageTitle1>"
    Then User verifies the new account on management portal
    Then User clicks on request tab
    Then User reaches on page "<pageTitle>"
    Then User filters out the new account created
    Then User clicks on arrow and clicks on request approve and enters "<AB>" number
    Then User reaches on page "<pageTitle>"
    
  Examples:
     | cred          |AB      |page2               |organization|AccountName  |address |zipCode|phone           |alert                  |page1             |password  |Fname   |Lname|job|pageTitle1          |pageTitle     |
     |management1    |1790074 |Create Account - CCM|Arpatech    |MohdJawad    |New York|77084  |+1-231-231-2312 |Successfully Validated |Resend Email - CCM|Password@1|Mohd    |Jawad|IT |Accounts - CCM      |Requests - CCM|
 
 
 
 @ImportNewAccount
    Scenario Outline: To verify that Import feature is working fine.
    And User writes in excel sheet
    Given User visits the website "management"
    #Given User visits the website "DevMp"
    When User inserts the Username "<cred>"
		And User inserts the password "<cred>"
		And User clicks on login button
    And User is taken to dashboard page
    When User clicks on customer tab
    Then User reaches on page "<pageTitle1>"
    And User clicks on import button
    Then User selects vendors
    Then User selects file to import
    And User clicks on import file
    Then User confirms the creation of new account
  Examples:
     | cred        |pageTitle1          |
     |management1  | Accounts - CCM     |
 
 

 