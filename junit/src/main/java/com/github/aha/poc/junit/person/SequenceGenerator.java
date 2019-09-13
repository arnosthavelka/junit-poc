package com.github.aha.poc.junit.person;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGenerator {

	private static AtomicInteger counter;

	static {
		counter = new AtomicInteger(1);
	}

	public static int nextId() {
		return counter.getAndIncrement();
	}
}
