package com.github.aha.poc.junit.person;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SequenceGeneratorTests {

	@Test
	void nextId() {
		var currentValue = SequenceGenerator.nextId();

		assertThat(SequenceGenerator.nextId()).isGreaterThan(currentValue);
	}

	@Test
	void nextMultipleIds() {
		assertThat(SequenceGenerator.nextMultipleIds(3)).hasSize(3);
	}

}