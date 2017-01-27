package com.github.aha.poc.junit.v4.suite;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

import org.junit.AssumptionViolatedException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// https://examples.javacodegeeks.com/core-java/junit/junit-suite-test-example/

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AddTests.class,
	MultiplyTests.class
})
public class SimpleSuiteV4Tests {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(SimpleSuiteV4Tests.class);

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
