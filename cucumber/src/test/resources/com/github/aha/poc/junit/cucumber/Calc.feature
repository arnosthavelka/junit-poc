Feature: Calculator

  Scenario: simple calculator
    Given start sum operation with value 10
    When add value 5
    When add value 3
    When add value 4
    Then the result of sum operation is 22
    
  Scenario: advanced calculator
    Given initialize calculator
    When use 5 with ADD operation
    When use 2 with MULTIPLY operation
    When use 5 with ADD operation
    When use 3 with ADD operation
    When use 3 with MULTIPLY operation
    Then the result value is 54