package com.github.aha.poc.junit.person;

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
}
