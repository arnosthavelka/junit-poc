package com.github.aha.poc.junit4.rule;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

import org.junit.AssumptionViolatedException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestNameTests {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(TestNameTests.class);
	
	/**
	 * Log method execution (start & stop).
	 */
	@Rule
	public TestRule watcher = new TestWatcher() {
		
		protected void starting(Description description) {
			LOG.debug("Starting test {}#{}", description.getTestClass().getSimpleName(), description.getMethodName());
		}

		protected void finished(Description description) {
			LOG.debug("Finished test {}#{}", description.getTestClass().getSimpleName(), description.getMethodName());
		}

		protected void skipped(AssumptionViolatedException e, Description description) {
			LOG.debug("Skipped test {}#{}", description.getTestClass(), description.getMethodName());
		}

	};

	@Test
	public void testOk() {
		assertThat(5 + 5, equalTo(10));
	}

	@Test
	public void testFailure() {
		assertThat(5 + 6, not(equalTo(10)));
	}	

}
