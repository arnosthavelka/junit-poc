package com.github.aha.poc.junit.person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SequenceGenerator {

	private static AtomicInteger counter;

	static {
		counter = new AtomicInteger(1);
	}

	public static int nextId() {
		return counter.getAndIncrement();
	}

	public static List<Integer> nextMultipleIds(int count) {
		var newValues = new ArrayList<Integer>(count);
		for (int i = 0; i < count; i++) {
			newValues.add(counter.getAndIncrement());
		}
		return newValues;
	}

}
