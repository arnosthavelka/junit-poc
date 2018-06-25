Feature: Calculator

  Scenario: add operation
    Given start sum operation with value 10
    When add value 5
    When add value 3
    When add value 4
    Then the result of sum operation is 22
    
  Scenario: multiply operation
    Given start multiply operation with value 5
    When multiply by 5
    When multiply by 2
    Then the result of multiply operation is 50