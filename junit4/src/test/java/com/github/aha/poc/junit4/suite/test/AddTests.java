package com.github.aha.poc.junit4.suite.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.github.aha.poc.junit4.cathegory.annotation.AddOperation;
import com.github.aha.poc.junit4.cathegory.annotation.NoInput;

/**
 * Tests for 'add' feature.  
 */
@Category(AddOperation.class)
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
	@Category(NoInput.class)
	public void addNoneNumbers() {
		int result = calc.add();
		assertThat(result, is(equalTo(0)));
	}

}
