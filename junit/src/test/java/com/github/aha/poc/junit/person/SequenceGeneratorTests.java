package com.github.aha.poc.junit.person;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SequenceGeneratorTests {

	@Test
	void testNextValue() {
		var currentValue = SequenceGenerator.nextId();
		assertThat(SequenceGenerator.nextId()).isEqualTo(currentValue + 1);
	}


}