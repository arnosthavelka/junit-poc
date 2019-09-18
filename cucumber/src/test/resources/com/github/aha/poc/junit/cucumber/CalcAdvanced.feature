@advanced
Feature: Advanced Calculator 

Background: 
	Given initialize calculator 

Scenario: Usage of single value per rule 
	When use 5 with ADD operation 
	And use 2 with MULTIPLY operation 
	And use 5 with ADD operation 
	And use 3 with ADD operation
	And use 3 with MULTIPLY operation
	Then the result value is 54 
	
Scenario: Usage of list of values per rule 
	When do these math operations
		| ADD       | 5 | 
		| MULTIPLY  | 2 |
		| ADD       | 4 |
		| MULTIPLY  | 3 |
	Then the result value is 42
