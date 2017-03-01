package com.github.aha.poc.junit5;

import java.util.Arrays;

public class Calculator {
	
	public static int add(int... values) {
		return Arrays.stream(values).sum();
	}

}
