Feature: JUnit

  Scenario: Calculate add operation
    Given start with value 10
    When add value 5
    When add value 3
    When add value 4
    Then should have value 22