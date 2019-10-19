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
Feature: Creating Customer for Actitime Application

  Background: User is logged in to Actitime
    Given User is on Actitime Login Page
    When I enter valid user name and password
    Then I should be able to see home page

  @regression
  Scenario: Create Customer without Importing
    When I click on Task Link and Add New Button
    Then I should be able to see New Customer Button
    And I click on New Customer Button
    Then I should be able to enter "BDD-Cucumber-Cus108" and "BDD-Cucumber-Cust-Desc10"
    And I validate Success Message
    Then I should be able to logout of the application

  @stage
  Scenario: Create Customer without Importing
    When I click on Task Link and Add New Button
    Then I should be able to see New Customer Button
    And I click on New Customer Button
    Then I should be able to enter "BDD-Cucumber-Cust9" and "BDD-Cucumber-Cust-Desc7" and unselect All Checkboxes
    And I validate Success Message
    Then I should be able to logout of the application
