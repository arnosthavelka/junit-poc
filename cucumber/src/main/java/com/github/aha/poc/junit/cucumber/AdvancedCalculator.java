package com.github.aha.poc.junit.cucumber;

public class AdvancedCalculator {
	
	public enum Operation {
		ADD, MULTIPLY;
	}

	private int result = 0;

	public void calculate(Operation operation, int value) {
		switch (operation) {
		case ADD:
			result += value;
			break;
		case MULTIPLY:
			result *= value;
			break;
		}
	}

	public int getResult() {
		return result;
	}


}
