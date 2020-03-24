package com.github.aha.poc.junit.person;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("verify that SequenceGenerator")
public class SequenceGeneratorTests {


	@Test
	@DisplayName("should return next value")
	void getNextValue() {
		int currentValue = SequenceGenerator.nextId();
		assertThat(SequenceGenerator.nextId()).isEqualTo(currentValue + 1);
	}


}