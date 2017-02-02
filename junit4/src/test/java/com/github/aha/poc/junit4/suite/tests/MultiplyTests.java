package com.github.aha.poc.junit4.suite.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

/**
 * Tests for 'multiply' feature.  
 */
public class MultiplyTests extends AbstractCalcTests {

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
