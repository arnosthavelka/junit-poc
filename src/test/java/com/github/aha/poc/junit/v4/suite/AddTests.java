package com.github.aha.poc.junit.v4.suite;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

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
