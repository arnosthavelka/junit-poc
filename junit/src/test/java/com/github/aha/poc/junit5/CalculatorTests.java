package com.github.aha.poc.junit5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.github.aha.poc.junit.Calculator;

class CalculatorTests {

	private Calculator calc = new Calculator();

	@Test
	void shouldAddTwoPositiveNumbers() {
		assertThat(calc.add(3, 5)).isEqualTo(8);
	}

	@Test
	void shouldAddSeveralPositiveNumbers() {
		assertThat(calc.add(1, 2, 3, 4, 5, 6)).isEqualTo(21);
	}

	@Test
	void shouldAddPositiveAndNegativeNumbers() {
		assertThat(calc.add(3, -5)).isEqualTo(-2);
	}

	@Test
	void shouldAddTwoNegativeNumbers() {
		assertThat(calc.add(-2, -4)).isEqualTo(-6);
	}

	@Test
	void failOnNoPassedNumber() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> calc.add());
		assertThat(exception.getClass()).isEqualTo(IllegalArgumentException.class);
	}

	@Test
	void shouldHandleOneNumber() {
		assertThat(calc.add(3)).isEqualTo(3);
	}

}