package com.github.aha.poc.junit5.example;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.aha.poc.junit5.Calculator;

@DisplayName("Check calculator component")
public class CalculatorTest {

	@Test
	@DisplayName("Test simple sum of 2 numbers")
	void addTwoPositiveNumbers() {
		assertThat(Calculator.add(3, 5), is(equalTo(8)));
	}

	@Test
	@DisplayName("Test more numbers (6 in our case)")
	void addMorePositiveNumbers() {
		assertThat(Calculator.add(1, 2, 3, 4, 5, 6), is(equalTo(21)));
	}

	@Test
	@DisplayName("Test positive and negative numbers")
	void addPositiveAndNegativeNumbers() {
		assertThat(Calculator.add(3, -5), is(equalTo(-2)));
	}

	@Test
	@DisplayName("Test only negative numbers")
	void addJustNegativeNumbers() {
		assertThat(Calculator.add(-2, -4), is(equalTo(-6)));
	}

	@Test
	@DisplayName("Check also correct handling of empty input")
	void addNoNumber() {
		assertThat(Calculator.add(), is(equalTo(0)));
	}

	@Test
	@DisplayName("Verify correctness of usage just with one number")
	void addOneNumbers() {
		assertThat(Calculator.add(3), is(equalTo(3)));
	}

}