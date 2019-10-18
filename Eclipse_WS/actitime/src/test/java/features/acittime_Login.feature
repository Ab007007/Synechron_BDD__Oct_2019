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
Feature: Login - Actitime Application

	@sanity
  Scenario: Successful Login to application
  Given User is on Actitime Login Page
  When I enter valid user name and password
  Then I should be able to see home page
  And the titile of the page is matched
  Then I should be able to logout of the application
  
  @stage
  Scenario: Successful Login to application Using Feature file test data
  Given User is on Actitime Login Page
  When I enter valid username "admin1" and valid password "manager1"
  Then I should be able to see home page
  And the titile of the page is matched with "actiTIME - Enter Time-Track"
  Then I should be able to logout of the application
  
  @stage 
  Scenario Outline: Successful Login to application
  Given User is on Actitime Login Page
  When I enter valid outline "<username>" and "<password>"
  Then I should be able to see home page
  And the titile of the page is with "<expectedTitle>"
  Then I should be able to logout of the application
  
  Examples:
  | username | password   | expectedTitle               |
  | admin    | manager    | actiTIME - Enter Time-Track |
  | admin    | manager    | actiTIME - Enter Time-Track |
  | admin    | manager    | actiTIME - Enter Time-Track |
  | admin    | manager    | actiTIME - Enter Time-Track |
  | admin123 | manager123 | actiTIME - Enter Time-Track |
  
  @uat
  Scenario: Login to application with Datatable
  Given User is on Actitime Login Page
  When I enter valid Credentials
  | admin | manager |
  Then I should be able to see home page
  And the titile of the page is matched with "actiTIME - Enter Time-Track"
  Then I should be able to logout of the application
  
  @uat @regression
  Scenario: Login to application with Datatable
  Given User is on Actitime Login Page
  When I enter valid Credentials with header
  | Username | password |
  | admin    | manager  |
  Then I should be able to see home page
  And the titile of the page is matched with "actiTIME - Enter Time-Track"
  Then I should be able to logout of the application
 
 
 @uat 
  Scenario: Login to application with Multiple set of data using Datatable
    Given User is on Actitime Login Page
    When I enter valid multiple Credentials with header
      | Username | password |
      | admin    | manager  |
      | admin    | manager  |
      | admin    | manager  |
    
