Feature: Calculator

  Scenario: simple calculator
    Given start sum operation with value 10
    When add value 5
    And add value 3
    And add value 4
    Then the result of sum operation is 22
    
  Scenario: advanced calculator
    Given initialize calculator
    When use 5 with ADD operation
    And use 2 with MULTIPLY operation
    And use 5 with ADD operation
    And use 3 with ADD operation
    And use 3 with MULTIPLY operation
    Then the result value is 54