 @Catalog 
Feature: Verify catalog tab on management portal  website

 Background:
     Given User visits the website "management"
    #Given User visits the website "DevMp"
    When User inserts the Username "management1"
		And User inserts the password "management1"
		And User clicks on login button
    And User is taken to dashboard page
    
 
 
 @ResendEmail
    Scenario Outline: Validate Resend email tab on management portal
    When User clicks on customer tab
    Then User reaches on page "<pageTitle1>"
    Then User clicks on resend email
    Then User reaches on page "<page1>"
    Examples:
      |pageTitle1|page1|
      |Accounts - CCM|Resend Email - CCM|
      
      
  @ResendEmailList
    Scenario Outline: Verify the presence of lists of notifications on management portal
    When User clicks on customer tab
    Then User reaches on page "<pageTitle1>"
    Then User clicks on resend email
    Then User reaches on page "<page1>"
    And User verifies the list of notifications are present
    Examples:
      |pageTitle1|page1|
      |Accounts - CCM|Resend Email - CCM|
      
      
   @ResendEmailExport
    Scenario Outline: Validate export button by downloading the file
    When User clicks on customer tab
    Then User reaches on page "<pageTitle1>"
    Then User clicks on resend email
    Then User reaches on page "<page1>"
    When User clicks on select field button 
    And User clicks on cancel button field
    When User clicks on export button
    Then User downloads the file
    Then User clicks on export cancel button
    Then User clicks on row and resend
    Then User reaches on page "<page1>"
    Then User logs out
    Examples:
      |pageTitle1    |page1|
      |Accounts - CCM|Resend Email - CCM|
      
      
      
  @ResendFilter
   Scenario Outline: To verify all columns of resend Page with their filters ( also check correct information appearing for all entries)
   When User clicks on customer tab
   Then User reaches on page "<pageTitle>"
   Then User clicks on resend email
   Then User reaches on page "<pageTitle1>"
   And User clicks on "<ColNum1>" filter
   Then User clicks the option and apply 1
   Then User verifies the information appeared on column 0
   And User clicks on clear or reset button
   And User clicks on "<ColNum3>" filter
   Then User filters out current date and presses on apply button
   Then User verifies the current date appeared on column 2
   And User clicks on clear or reset button
   And User clicks on "<ColNum2>" filter
   Then User clicks the option and apply 2
   Then User verifies the information appeared on column 1
   And User clicks on clear or reset button
    Examples:
   |pageTitle     |pageTitle1          |ColNum3|ColNum2|ColNum1|
   |Accounts - CCM|Resend Email - CCM  |Third  |Second |First  |   
      
      
      
   @SendEmailtab 
    Scenario Outline: Validate send email tab on management portal
    When User clicks on customer tab
    Then User reaches on page "<pageTitle1>"
    Then User clicks on send email
    Then User reaches on page "<page1>"
    Examples:
      |pageTitle1|page1|
      |Accounts - CCM|Send Emails - CCM|
      
      
  @SendEmailElements
    Scenario Outline: Verify all elements of the Send Emails Page. (buttons,links,fields,etc)
    When User clicks on customer tab
    Then User reaches on page "<pageTitle1>"
    Then User clicks on send email
    Then User reaches on page "<page1>"
    And User verifies all the elements
    Then User logs out
    Examples:
      |pageTitle1|page1|
      |Accounts - CCM|Send Emails - CCM|
      
   
  @MailEmail 
    Scenario Outline: To verify to Send Email by filling all the requisites successfully
    When User clicks on customer tab
    Then User reaches on page "<pageTitle1>"
    Then User clicks on send email
    Then User reaches on page "<page1>"
    And User fills out all the requisites
    Then User successfully sends email
    Then User logs out
    Examples:
      |pageTitle1|page1|
      |Accounts - CCM|Send Emails - CCM|
      
      
  @SendBulkEmail
    Scenario Outline: To verify all elements of the Send Bulk Welcome Emails Page. (buttons,links,fields,etc)
    When User clicks on customer tab
    Then User reaches on page "<pageTitle1>"
    Then User clicks on send email
    Then User reaches on page "<page1>"
    Then User hovers on send emails and clicks on send bulk emails
    And User Verifies the presence of elements on send bulk emails
    Examples:
      |pageTitle1|page1|
      |Accounts - CCM|Send Emails - CCM|
      
      
  @ProviderTab
    Scenario Outline: Validate provider tab on management portal
    When User clicks on catalog tab
    Then User reaches on page "<pageTitle1>"
    Then User logs out
    Examples:
      |pageTitle1|
      |Providers - CCM|
   
      
      
  @ProviderFilter
   Scenario Outline: To verify all columns of provider Page with their filters ( also check correct information appearing for all entries)
   When User clicks on catalog tab
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
   Then User clicks the option and apply 4
   Then User verifies the information appeared on column 3
   And User clicks on clear or reset button
    Examples:
   |pageTitle1          |ColNum3|ColNum2|ColNum1|ColNum4|
   |Providers - CCM     |Third  |Second |First  |Four   |
      
      
   @ServiceTab
    Scenario Outline: Validate service tab on management portal
    When User clicks on catalog tab
    Then User reaches on page "<pageTitle1>"
    When User clicks on service under catalog tab
    Then User reaches on page "<pageTitle>"
    When User clicks on sync button on service page
    When User clicks on export button
    Then User downloads the file
    Then User clicks on export cancel button
    When User clicks on select field button 
    And User clicks on cancel button field
    Then User logs out
    Examples:
      |pageTitle1     |pageTitle|
      |Providers - CCM|Catalog Services - CCM|
      
      
  @ServiceFilter
   Scenario Outline: To verify all columns of service Page with their filters ( also check correct information appearing for all entries)
   When User clicks on catalog tab
   Then User reaches on page "<pageTitle1>"
   When User clicks on service under catalog tab
   Then User reaches on page "<pageTitle>"
   And User clicks on "<ColNum1>" filter
   Then User clicks the option and apply 1
   Then User verifies the information appeared on column 0
   And User clicks on clear or reset button
    Examples:
   |pageTitle1          |pageTitle              |ColNum1|
   |Providers - CCM     |Catalog Services - CCM |First  |
      
      
  @FailToSyncTab
    Scenario Outline: To verify each option of failed to sync services menu (check their individual functionality) Select fields and Export
    When User clicks on catalog tab
    Then User reaches on page "<pageTitle1>"
    When User clicks on fail to sync tab
    Then User reaches on page "<pageTitle>"
    When User clicks on export button
    Then User downloads the file
    Then User clicks on export cancel button
    When User clicks on select field button 
    And User clicks on cancel button field
    Then User logs out
    Examples:
      |pageTitle1|pageTitle|
      |Providers - CCM|Failed to Sync Services - CCM|
      
      
   @FailToSyncField 
    Scenario Outline: To verify select field button on fail to sync page
    When User clicks on catalog tab
    Then User reaches on page "<pageTitle1>"
    When User clicks on fail to sync tab
    Then User reaches on page "<pageTitle>"
    When User clicks on select field button 
    And User unselects all the fields and choose fields to display on fail to sync page
    And User verifies the presence of selected field on fail to sync page
    When User clicks on select field button 
    Then User resets all
    
    Examples:
      |pageTitle1|pageTitle|
      |Providers - CCM|Failed to Sync Services - CCM|    
      
  
  @FailToSyncElements   
    Scenario Outline: To verify all elements of the Send Bulk Welcome Emails Page. (buttons,links,fields,etc)
    When User clicks on catalog tab
    Then User reaches on page "<pageTitle1>"
    When User clicks on fail to sync tab
    Then User reaches on page "<pageTitle>"
    And User verifies the presence of buttons
    
    Examples:
      |pageTitle1     |pageTitle|
      |Providers - CCM|Failed to Sync Services - CCM - CCM|
   
     
  @FailToSyncFilter  
   Scenario Outline: To verify all columns of fail to sync Page with their filters ( also check correct information appearing for all entries)
   When User clicks on catalog tab
   Then User reaches on page "<pageTitle1>"
   When User clicks on fail to sync tab
   Then User reaches on page "<pageTitle>"
   And User clicks on "<ColNum1>" filter
   Then User clicks the first option and apply 2
   Then User verifies the information appeared on column 1
   And User clicks on clear or reset button
   And User clicks on "<ColNum2>" filter
   Then User clicks the first option and apply 3
   Then User verifies the information appeared on column 2
   And User clicks on clear or reset button
    Examples:
   |pageTitle1          |pageTitle                     |ColNum2|ColNum1|
   |Providers - CCM     |Failed to Sync Services - CCM |Second |First  |
     
      
   
  @AddonsElements
    Scenario Outline: Validate addons tab on management portal
    When User clicks on catalog tab
    Then User reaches on page "<pageTitle1>"
    When User clicks on addons tab
    Then User reaches on page "<pageTitle>"
    And User verifies the presence of addons elements
    
    Examples:
      |pageTitle1|pageTitle|
      |Providers - CCM|Catalog Addons - CCM|
      
      
  @AddonsTab
    Scenario Outline: To verify each option of Addon menu (check their individual functionality) Select fields, Export and Sync to Addons
    When User clicks on catalog tab
    Then User reaches on page "<pageTitle1>"
    When User clicks on addons tab
    Then User reaches on page "<pageTitle>"
    When User clicks on export button
    Then User downloads the file
    Then User clicks on export cancel button
    When User clicks on select field button 
    And User clicks on cancel button field
    When User clicks on sync button
    Examples:
      |pageTitle1|pageTitle|
      |Providers - CCM|Catalog Addons - CCM|
      
      
   
   @AddonsField
    Scenario Outline: To verify select filed button on addons page.
    When User clicks on catalog tab
    Then User reaches on page "<pageTitle1>"
    When User clicks on addons tab
    Then User reaches on page "<pageTitle>"
    When User clicks on select field button 
    And User unselects all the fields and choose fields to display
    And User verifies the presence of selected field on addons page
    When User clicks on select field button 
    Then User resets all
    
    Examples:
      |pageTitle1|pageTitle|
      |Providers - CCM|Catalog Addons - CCM|
      
   
   @AddonFilter
   Scenario Outline: To verify all columns of addons Page with their filters ( also check correct information appearing for all entries)
   When User clicks on catalog tab
   Then User reaches on page "<pageTitle>"
   When User clicks on addons tab
   Then User reaches on page "<pageTitle1>"
   And User clicks on "<ColNum1>" filter
   Then User clicks the first option and apply 1
   Then User verifies the information appeared on column 0
   And User clicks on clear or reset button
    Examples:
   |pageTitle      |pageTitle1           |ColNum1|
   |Providers - CCM|Catalog Addons - CCM |First  |
      
      
  

 