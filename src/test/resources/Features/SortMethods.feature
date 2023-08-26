@SortMethods @regression7
Feature: Verify sorting method on any column of each tabs.
 Background:
    Given User visits the website "management"
    #Given User visits the website "DevMp"
    When User inserts the Username "management1"
		And User inserts the password "management1"
		And User clicks on login button
    And User is taken to dashboard page


@AccountSort 
   Scenario Outline: To verify that if user clicks on the column name, records are sorted on account page.
   When User clicks on customer tab
   Then User reaches on page "<pageTitle>"
   And User fetches the column data 2 by simple method 
   And User clicks on column "<name1>"
   Then User verifies whether column 2 is sorted or not by simple method 
   And User fetches the column data 3
   And User clicks on column "<name>"
   Then User verifies whether column 3 is sorted or not
    Examples:
   |pageTitle     |name      |pageTitle1   |name1   |
   |Accounts - CCM|Created By|Domains - CCM|Account ID|
   
   
   
  @SubSort
   Scenario Outline: To verify that if user clicks on the column name, records are sorted on Subscription page.
   When User clicks on customer tab
   Then User reaches on page "<pageTitle>"
   When User clicks on Subscription tab under customer tab
   Then User reaches on page "<pageTitle1>"
   And User fetches the column data 2 by simple method 
   And User clicks on column "<name1>"
   Then User verifies whether column 2 is sorted or not by simple method 
   And User fetches the column data 3
   And User clicks on column "<name>"
   And User clicks on column "<name>"
   Then User verifies whether column 3 is sorted or not
    Examples:
   |pageTitle     |name    |pageTitle1         |name1    |
   |Accounts - CCM|Provider|Subscriptions - CCM|Account ID|
   
   
   
   
   
  @DomainSort
   Scenario Outline: To verify that if user clicks on the column name, records are sorted on domain page.
   When User clicks on customer tab
   Then User reaches on page "<pageTitle>"
   Then User clicks on domain link under customer tab
   Then User reaches on page "<pageTitle1>"
   And User fetches the column data 2 by simple method 
   And User clicks on column "<name>"
   Then User verifies whether column 2 is sorted or not by simple method 
   And User fetches the column data 3 by simple method 
   And User clicks on column "<name1>"
   And User clicks on column "<name1>"
   Then User verifies whether column 3 is sorted or not by simple method 
    Examples:
   |pageTitle     |name     |pageTitle1   |name1     |
   |Accounts - CCM|Domain ID|Domains - CCM|Account ID|
   
   
   
   
   
  @NotiSort
   Scenario Outline:  To verify that if user clicks on the column name, records are sorted on Notification page.
   When User clicks on customer tab
   Then User reaches on page "<pageTitle>"
   Then User clicks on Notification link under customer tab
   Then User reaches on page "<pageTitle1>"
   And User fetches the column data 2
   And User clicks on column "<name>"
   Then User verifies whether column 2 is sorted or not
    Examples:
   |pageTitle     |name           |pageTitle1|
   |Accounts - CCM|Notification ID|Notifications - CCM|
   
   
   
   @RequestSort
   Scenario Outline: To verify that if user clicks on the column name, records are sorted on request page.
   When User clicks on customer tab
   Then User reaches on page "<pageTitle>"
   Then User clicks on request tab
   Then User reaches on page "<pageTitle1>"
   And User fetches the column data 2 by simple method 
   And User clicks on column "<name1>"
   And User clicks on column "<name1>"
   Then User verifies whether column 2 is sorted or not by simple method 
   And User fetches the column data 3
   And User clicks on column "<name>"
   And User clicks on column "<name>"
   Then User verifies whether column 3 is sorted or not
   And User fetches the column data 4 by simple method  
   And User clicks on column "<name2>"
   And User clicks on column "<name2>"
   Then User verifies whether column 4 is sorted or not by simple method 
    Examples:
   |pageTitle     |name     |pageTitle1      |name1       |name2     |
   |Accounts - CCM|AB Number|Requests - CCM  |Net Terms ID|Address ID|
   
   
          
  @ResendSort 
   Scenario Outline: To verify that if user clicks on the column name, records are sorted on resend page.
   When User clicks on customer tab
   Then User reaches on page "<pageTitle>"
   Then User clicks on resend email
   Then User reaches on page "<pageTitle1>"
   And User fetches the column data 2 by simple method 
   And User clicks on column "<name>"
   Then User verifies whether column 2 is sorted or not by simple method 
    Examples:
   |pageTitle     |name     |pageTitle1|
   |Accounts - CCM|ID       |Resend Email - CCM  |

   
   
 @ProviderSort 
    Scenario Outline: To verify that if user clicks on the column name, records are sorted on provider page.
    When User clicks on catalog tab
    Then User reaches on page "<pageTitle1>"
    And User fetches the column data 2 by simple method 
    And User clicks on column "<name>"
    Then User verifies whether column 2 is sorted or not by simple method 
    And User fetches the column data 4
    And User clicks on column "<name1>"
    And User clicks on column "<name1>"
    Then User verifies whether column 4 is sorted or not
    And User fetches the column data 5
    And User clicks on column "<name2>"
    And User clicks on column "<name2>"
    Then User verifies whether column 5 is sorted or not
    Examples:
      |pageTitle1     |name|name1           |name2|
      |Providers - CCM|ID  |Setup New Tenant|Setup Migrate Te...|
  
  
 @CatalogSort
    Scenario Outline: To verify that if user clicks on the column name, records are sorted on categories page.
    When User clicks on catalog tab
    Then User clicks on categories appeared under catalog tab
    Then User reaches on page "<pageTitle>"
    And User fetches the column data 2 by simple method 
    And User clicks on column "<name>"
    Then User verifies whether column 2 is sorted or not by simple method 
     Examples:
    |pageTitle               |name|
    |Catalog Categories - CCM|ID  |
    
    
    
 @ServiceSort 
   Scenario Outline: To verify that if user clicks on the column name, records are sorted on service page.
   When User clicks on catalog tab
   Then User reaches on page "<pageTitle>"
   When User clicks on service under catalog tab
   Then User reaches on page "<ServicepageTitle>"
   And User fetches the column data 2 by simple method 
   And User clicks on column "<name2>"
   Then User verifies whether column 2 is sorted or not by simple method 
   Examples:
   |pageTitle               |ServicepageTitle         |name2|
   |Catalog Categories - CCM|Catalog Services - CCM   |ID   |
   
   
   
 @FailToSyncSort
    Scenario Outline: To verify that if user clicks on the column name, records are sorted on fail to sync page.
    When User clicks on catalog tab
    Then User reaches on page "<pageTitle1>"
    When User clicks on fail to sync tab
    Then User reaches on page "<pageTitle>"
    And User fetches the column data 1
    And User clicks on column "<name>"
    Then User verifies whether column 1 is sorted or not
    Examples:
      |pageTitle1     |pageTitle                    |name|
      |Providers - CCM|Failed to Sync Services - CCM|ID  |
      
      
      
      
   @AddonsSort
    Scenario Outline: To verify that if user clicks on the column name, records are sorted on addons page.
    When User clicks on catalog tab
    Then User reaches on page "<pageTitle1>"
    When User clicks on addons tab
    Then User reaches on page "<pageTitle>"
    And User fetches the column data 2 by simple method 
    And User clicks on column "<name2>"
    Then User verifies whether column 2 is sorted or not by simple method 
    And User fetches the column data 3
    And User clicks on column "<name>"
    And User clicks on column "<name>"
    Then User verifies whether column 3 is sorted or not
    Examples:
      |pageTitle1     |pageTitle           |name   |name2|
      |Providers - CCM|Catalog Addons - CCM|SKUID  |ID   |
      
      
      
  @OrderSort  
    Scenario Outline: To verify that if user clicks on the column name, records are sorted on order page.
    When User clicks on fullfilment tab
    Then User reaches on page "<pageTitle>"
    And User fetches the column data 3 by simple method 
    And User clicks on column "<name>"
    Then User verifies whether column 3 is sorted or not by simple method 
    Examples: 
    |pageTitle     |name|	
    |Orders - CCM  |Account ID  |
    
    
  @Filter @Smoke @filters_smoke_001 @filters_smoke_002
   Scenario Outline: To verify that if user has applied a filter, and user tries to apply filter to another field as well, then the data in the second field should be shown according to the first filter.
   When User clicks on customer tab
   Then User reaches on page "<pageTitle>"
   Then User clicks on resend email
   When User clicks on select field button 
   Then User resets all
   Then User reaches on page "<pageTitle1>"
   And User clicks on "<ColNum2>" filter
   Then User clicks the first option and apply 2
   Then User verifies the information appeared on column 1
   And User fetches the content on column 1
   And User clicks on "<ColNum1>" filter
   Then User clicks the first option and apply 1
   Then User verifies the information appeared on column 0
   Then User verifies the content appeared on column 1
   And User clicks on clear or reset button
    Examples:
   |pageTitle     |pageTitle1          |ColNum1 |ColNum2|
   |Accounts - CCM|Resend Email - CCM  |First   |Second   |   
    

  
		