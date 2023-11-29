package com.github.aha.poc.junit.person;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SequenceGeneratorTests {

	@Test
	void nextId() {
		assertThat(SequenceGenerator.nextId()).isLessThan(SequenceGenerator.nextId());
	}

	@Test
	void nextMultipleIds() {
		var noOfValues = 3;
		
		assertThat(SequenceGenerator.nextMultipleIds(noOfValues)).hasSize(noOfValues);
	}

}