package com.github.aha.poc.junit.v4.suite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.aha.poc.junit.v4.suite.tests.AddTests;
import com.github.aha.poc.junit.v4.suite.tests.MultiplyTests;

// https://examples.javacodegeeks.com/core-java/junit/junit-suite-test-example/

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AddTests.class,
	MultiplyTests.class
})
public class SuiteTests {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(SuiteTests.class);

	@Test
	public void notExecuted() {
		LOG.debug("Do you see me?");
	}

}
