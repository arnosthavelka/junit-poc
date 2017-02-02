package com.github.aha.poc.junit4.suite.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

/**
 * Tests for 'add' feature.  
 */
public class AddTests extends AbstractCalcTests {

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
	public void addNoneNumbers() {
		int result = calc.add();
		assertThat(result, is(equalTo(0)));
	}

}
