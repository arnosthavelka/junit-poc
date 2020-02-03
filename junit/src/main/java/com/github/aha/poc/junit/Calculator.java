package com.github.aha.poc.junit;

import static java.util.Arrays.stream;

public class Calculator {

	public int add(int... values) {
		if (values.length == 0) {
			throw new IllegalArgumentException("No input argument");
		}
		return stream(values).sum();
	}

	public int multiply(int... values) {
		return values.length == 0 ? 0 : stream(values).reduce(1, (a1, a2) -> a1 * a2);
	}
}
