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

}
