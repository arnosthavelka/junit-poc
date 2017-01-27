package com.github.aha.poc.junit.v4.suite;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

import com.github.aha.poc.junit.v4.Calculator;

public class MultiplyTests {

	private Calculator calc = new Calculator();
	
	@Test
	public void multiplyTwoNumbers() {
		int result = calc.multiply(2, 5);
		assertThat(result, is(equalTo(10)));
	}

	@Test
	public void multiplyMoreNumbers() {
		int result = calc.multiply(2, 3, 4);
		assertThat(result, is(equalTo(24)));
	}

	@Test
	public void multiplyNoneNumbers() {
		int result = calc.multiply();
		assertThat(result, is(equalTo(0)));
	}

}
