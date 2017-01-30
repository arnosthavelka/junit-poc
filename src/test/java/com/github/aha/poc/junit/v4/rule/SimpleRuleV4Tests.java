package com.github.aha.poc.junit.v4.rule;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

import org.junit.Test;

public class SimpleRuleV4Tests {

	@Test
	public void testOk() {
		assertThat(5 + 5, equalTo(10));
	}

	@Test
	public void testFailure() {
		assertThat(5 + 6, not(equalTo(10)));
	}	
}
