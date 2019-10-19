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
Feature: Google Search for a Company Information

  @regression
  Scenario: Search for a Synechron Contact and Address
    Given I'm on google page
    When I enter "Synechron" in the search box
    And I click on search button
    Then Results for "Synechron" should be displayed
    And I should print those information on Console
 

  @regression
  Scenario: Search for a IBM Contact and Address
    Given I'm on google page
    When I enter "IBM" in the search box
    And I click on search button
    Then Results for "IBM" should be displayed
    And I should print those information on Console
 

  @regression
  Scenario: Search for a Subex Contact and Address
    Given I'm on google page
    When I enter "Subex" in the search box
    And I click on search button
    Then Results for "Subex" should be displayed
    And I should print those information on Console

