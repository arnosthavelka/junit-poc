package com.github.aha.poc.junit.cucumber;

public class AdvancedCalculator {
	
	public enum Operation {
		ADD, MULTIPLY;

		public static Operation fromString(String value) {
			for (Operation operation : Operation.values()) {
				if (operation.name().equalsIgnoreCase(value)) {
					return operation;
				}
			}
			return null;
		}
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
		default:
			throw new UnsupportedOperationException();
		}
	}

	public int getResult() {
		return result;
	}


}
