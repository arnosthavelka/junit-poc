package com.github.aha.poc.junit.v4.suite;

import org.junit.Test;
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

	@Test
	public void notExecuted() {
		LOG.debug("Do you see me?");
	}

}
