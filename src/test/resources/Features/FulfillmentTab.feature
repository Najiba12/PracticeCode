 @Fulfillment 
Feature: Verify fulfillment tab on management portal  website

 Background:
     Given User visits the website "management"
    #Given User visits the website "DevMp"
    When User inserts the Username "management1"
		And User inserts the password "management1"
		And User clicks on login button
    And User is taken to dashboard page
   
      
      
  @OrderTab
    Scenario Outline: To verify all elements of the Orders Page. (buttons,links,fields,etc)
    When User clicks on fullfilment tab
    Then User reaches on page "<pageTitle>"
    Then User verifies the presence of buttons and links
    Then User logs out
    Examples: 
    |pageTitle        |	
    |Orders - CCM| 
    
    
 @OrderExports
    Scenario Outline: To verify each option of Orders menu (below the order headings on left side)
    When User clicks on fullfilment tab
    Then User reaches on page "<pageTitle>"
    When User clicks on export button
    Then User downloads the file
    Then User clicks on export cancel button
    When User clicks on select field button 
    And User clicks on cancel button field
    #Then User logs out
    Examples: 
    |pageTitle        |	
    |Orders - CCM| 
 
   
  @OrderField
    Scenario Outline: To verify select field button on order page
    When User clicks on fullfilment tab
    Then User reaches on page "<pageTitle>"
    When User clicks on select field button 
    And User unselects all the fields and choose fields to display on order page
    And User verifies the presence of selected field on order page
    When User clicks on select field button 
    Then User resets all
    Examples: 
    |pageTitle        |	
    |Orders - CCM| 
   
   
   
  @OrderStatus 
    Scenario Outline: To verify the order line of specific order and can also update status of the order from pending to cancelled when required
    When User clicks on fullfilment tab
    Then User reaches on page "<pageTitle>"
    And User clicks on "<ColNum1>" filter
    Then User clicks the first option and apply 1
    Then User passes "<value>" to status column and clicks on first option
    #And User changes the status of order from pending to cancelled
   
    Examples: 
    |pageTitle        |	value  |ColNum1 |
    |Orders - CCM     | Pending|First   |
 
 
  @OrderFunctionality
    Scenario Outline: To verify each option of orders menu (check their individual order functionality)
    When User clicks on fullfilment tab
    Then User reaches on page "<pageTitle>"
    Then User clicks on first order and selects manage order and view order details
    Then User reaches on page "<pageTitle>"
    Examples: 
    |pageTitle        |	
    |Orders - CCM| 
  
  
  @OrderFilter
   Scenario Outline: To verify all columns of order Page with their filters ( also check correct information appearing for all entries)
   When User clicks on fullfilment tab
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
   And User clicks on "<ColNum4>" filter
   Then User clicks the option and apply 4
   Then User verifies the information appeared on column 4
   And User clicks on clear or reset button
    Examples:
   |pageTitle1          |ColNum3|ColNum2|ColNum1|ColNum4|
   |Orders - CCM        |Third  |Second |First  |Four   |
  
