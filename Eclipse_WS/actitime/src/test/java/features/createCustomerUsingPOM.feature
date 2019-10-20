#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Create Customer And Delete Customer

 Background: User is logged in to Actitime
    Given User is on Actitime Login Page
    When I enter valid user name and password
    Then I should be able to see home page
	
	@regression
	Scenario: Create Customer without Importing
    When I click on Task Link and Add New Button
    Then I should be able to see New Customer Button
    And I click on New Customer Button
    Then I should be able to enter "BDD-Cucumber-Cus1111" and "BDD-Cucumber-Cust-Desc10"
    And I validate Success Message
    Then I should be able to logout of the application
    
   	@regression 
   	Scenario: Delete Customer which is Created 
   	  When I click on Task Link 
    	Then I should be able to Search a customer "BDD-Cucumber-Cus1111"
    	When I click on settings Icon next to Customer name
    	Then I should see Customer details Section
    	And I click on actions and delete button
    	Then I should prompt popup
    	And I click on delete Permanently button 
    	And I verify success message
    	Then Logout of application
   
   	
    