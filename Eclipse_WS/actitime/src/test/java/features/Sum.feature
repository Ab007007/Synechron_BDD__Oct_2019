Feature: Additon of Two Numbers

  Scenario: Sum of Two Integer Numbers
    Given I want to perform addition on two numbers
    When I add two numbers
    Then it should match the sum

  Scenario: Sum of Two float Values
    Given I want to perform addition on two floating numbers
    When I add "30.5" and "20.5"
    Then it should mathch "51.5"

  Scenario: Sum of Two float Values
    Given I want to perform addition on two floating numbers
    When I add "55.5" and "20.5"
    Then it should mathch "76.5"

