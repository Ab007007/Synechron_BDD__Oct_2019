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
Feature: Demo on Tagged hooks

  @First
  Scenario: This is a first Scenario to verfiy Hook
    Given the first step is executed
    When i enter the details
    Then applicaiton returns output

	@second
  Scenario: This is a second Scenario to verfiy Hook
    Given the first step is executed
    When i enter the details
    Then applicaiton returns output

	@third
  Scenario: This is a thrid Scenario to verfiy Hook
    Given the first step is executed
    When i enter the details
    Then applicaiton returns output
