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
Feature: Formy Web Form Testing

  @development
  Scenario Outline: Enter the form with valid Values
    Given User is on Formy App
    When User click on Form Button
    When User Enter FN "<FirstName>"
    And User Enter LN "<LastName>"
    And User Enter JT "<JobTitle>"
    And User Select ED "<education>"
    And User Select SEX "<Sex>"
    And User Select EXP "<experience>"
    And User Select DATE "<date>"
    And Click on Submit Button
    Then User Verify Success Message

    Examples: 
      | FirstName | LastName | JobTitle | education | Sex | experience | date       |
      | User1     | LN1      | Engineer | BE        | M   | 10+        | 10/15/2013 |
      | User2     | LN2      | Engineer | BE        | M   | 5-9        | 10/15/2014 |
      | User3     | LN3      | Engineer | BE        | M   | 5-9        | 10/15/2015 |
      | User4     | LN4      | Engineer | BE        | M   | 10+        | 10/15/2016 |
      | User5     | LN5      | Engineer | BE        | M   | 2-4        | 10/15/2017 |
      | User6     | LN6      | Engineer | BE        | M   | 10+        | 10/15/2018 |
      | User7     | LN7      | Engineer | BE        | M   | 0-1        | 10/15/2019 |
      | User8     | LN8      | Engineer | BE        | M   | 10+        | 10/15/2020 |
      | User9     | LN9      | Engineer | BE        | M   | 2-4        | 10/15/2021 |
      | User10    | LN10     | Engineer | BE        | M   | 5-9        | 10/15/2022 |

  @wip
  Scenario: Verify Drag and Drop Functionality In Formy App
    Given User is on Formy App
    When User Click on Drag and Drop Link
    Then Drag and drop page should be displayed
    And Use Should drag the selenium icon to Box

  @wip
  Scenario: Verify User Cannot perform Type operation on disabled Elements
    Given User is on Formy App
    When User Click on Enabled and Disabled elements
    Then User navigated to Enabled and Disabled elements Page
    When User performs Type on disabled Element
    Then it should not perform type
    And User enter text on enabled Element
    Then Type operation should be successfull
