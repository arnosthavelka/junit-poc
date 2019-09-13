package com.github.aha.poc.junit5;

import java.util.Arrays;

public class Calculator {
	
	private Calculator() {
		// hide constructor
	}

	public static int add(int... values) {
		if (values.length == 0) {
			throw new IllegalArgumentException("No input argument");
		}
		return Arrays.stream(values).sum();
	}

}
