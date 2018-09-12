package com.github.aha.poc.junit5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("A calculator component")
public class CalculatorTests {

	@Test
	@DisplayName("sum 2 positive numbers")
	void addTwoPositiveNumbers() {
		assertThat(Calculator.add(3, 5)).isEqualTo(8);
	}

	@Test
	@DisplayName("sum more positive numbers (6 in our case)")
	void addMorePositiveNumbers() {
		assertThat(Calculator.add(1, 2, 3, 4, 5, 6)).isEqualTo(21);
	}

	@Test
	@DisplayName("sum positive and negative numbers")
	void addPositiveAndNegativeNumbers() {
		assertThat(Calculator.add(3, -5)).isEqualTo(-2);
	}

	@Test
	@DisplayName("sum only negative numbers")
	void addJustNegativeNumbers() {
		assertThat(Calculator.add(-2, -4)).isEqualTo(-6);
	}

	@Test
	@DisplayName("handle empty input")
	void addNoNumber() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> Calculator.add());
		// check exception message
		assertThat(exception.getClass()).isEqualTo(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("handle just with one number")
	void addOneNumbers() {
		assertThat(Calculator.add(3)).isEqualTo(3);
	}

}