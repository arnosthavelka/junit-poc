package com.github.aha.poc.junit.cucumber;

public class AdvancedCalculator {
	
	public enum Operation {
		ADD, MULTIPLY;
	}

	private int result = 0;

	public void calculate(Operation operation, int value) {
		if (operation == Operation.ADD) {
			result += value;
		} else { // multiply
			result *= value;
		}
	}

	public int getResult() {
		return result;
	}


}
