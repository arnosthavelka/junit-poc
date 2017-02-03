package com.github.aha.poc.junit4.runner.suite.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.github.aha.poc.junit4.runner.cathegory.annotation.MultiplyOperation;
import com.github.aha.poc.junit4.runner.cathegory.annotation.NoInput;

/**
 * Tests for 'multiply' feature.  
 */
@Category(MultiplyOperation.class)
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
	@Category(NoInput.class)
	public void multiplyNoneNumbers() {
		int result = calc.multiply();
		assertThat(result, is(equalTo(0)));
	}

}
