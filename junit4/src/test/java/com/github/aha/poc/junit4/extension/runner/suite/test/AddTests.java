package com.github.aha.poc.junit4.extension.runner.suite.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.aha.poc.junit4.extension.runner.category.annotation.AddOperation;
import com.github.aha.poc.junit4.extension.runner.category.annotation.NoInput;

/**
 * Tests for 'add' feature.  
 */
@Category(AddOperation.class)
public class AddTests extends AbstractCalcTests {
	
	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(AddTests.class);	

	@Test
	public void addTwoNumbers() {
		int result = calc.add(2, 5);
		assertThat(result, is(equalTo(7)));
	}

	@Test
	public void addMoreNumbers() {
		int result = calc.add(1, 2, 3, 4);
		assertThat(result, is(equalTo(10)));
	}

	@Test
	@Category(NoInput.class)
	public void addNoneNumbers() {
		int result = calc.add();
		assertThat(result, is(equalTo(0)));
	}

	@Override
	Logger getLog() {
		return LOG;
	}

}
