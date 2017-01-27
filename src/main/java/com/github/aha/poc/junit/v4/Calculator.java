package com.github.aha.poc.junit.v4;

import java.util.Arrays;

public class Calculator {
	
	public int add(int... values) {
		return Arrays.stream(values).sum();
	}

	public int multiply(int... values) {
		return values.length == 0 ? 0 : Arrays.stream(values).reduce(1, (a1, a2) -> a1 * a2);
	}

}
