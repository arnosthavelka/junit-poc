package com.github.aha.poc.junit.v4.rule;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleRuleV4Tests {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(SimpleRuleV4Tests.class);

	@Test
	public void testOk() {
		assertThat(5 + 5, equalTo(10));
	}

	@Test
	public void testFailure() {
		assertThat(5 + 6, not(equalTo(10)));
	}	
}
