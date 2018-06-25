package com.github.aha.poc.junit.cucumber;

import java.util.ArrayList;
import java.util.List;

public class SimpleCalculator {
	
	private List<Integer> values = new ArrayList<>();

	public SimpleCalculator(Integer value) {
		values = new ArrayList<>();
		values.add(value);
	}

	public void add(int value) {
		values.add(value);
	}

	public int sum() {
		return values.stream().mapToInt(Integer::intValue).sum();
	}

	public int multiply() {
		return values.size() == 0 ? 0 : values.stream().mapToInt(Integer::intValue).reduce(1, (a1, a2) -> a1 * a2);
	}

}
