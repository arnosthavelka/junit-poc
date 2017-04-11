package com.github.aha.poc.junit4.extension.runner.suite.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.aha.poc.junit4.extension.runner.category.annotation.MultiplyOperation;
import com.github.aha.poc.junit4.extension.runner.category.annotation.NoInput;

/**
 * Tests for 'multiply' feature.  
 */
@Category(MultiplyOperation.class)
public class MultiplyTests extends AbstractCalcTests {
	
	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(MultiplyTests.class);	

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

	@Override
	Logger getLog() {
		return LOG;
	}

}
