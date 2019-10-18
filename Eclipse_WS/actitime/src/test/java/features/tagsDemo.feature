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
Feature: Title of your feature
  I want to use this template for my feature file

  @sanity @uat @regressionn
  Scenario: Login Functionality
    Given User will login successfully

  @sanity
  Scenario: Unsuccessfull Login Functionality
    Given User will login successfully

  @regression
  Scenario Outline: Login with multiple Users
    Given User Ill be able to login with below users

    Examples: 
      | Username | password |
      | admin    | manager  |
      | admin    | manager  |
      | admin    | manager  |
      | admin    | manager  |

  @sanity @uat 
  Scenario: Logout functionality
    Given Logged in user will be able to logout successfully

  @uat
  Scenario: create customer with CSV Data given by Customer
    Given customer creation will be successfull using CSV Data

  @regression
  Scenario Outline: Create mulitple customers
    Given Create multiple customers

    Examples: 
      | Customername | CustomerDesc   |
      | customer1    | customerDesc-1 |
      | customer2    | customerDesc-2 |
      | customer3    | customerDesc-3 |
      | customer4    | customerDesc-4 |
      
   @stage
   Scenario: Create tasks
   	Given User should create a task
