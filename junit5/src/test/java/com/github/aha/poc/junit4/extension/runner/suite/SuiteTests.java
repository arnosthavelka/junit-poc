package com.github.aha.poc.junit4.extension.runner.suite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.aha.poc.junit4.extension.runner.suite.test.AddTests;
import com.github.aha.poc.junit4.extension.runner.suite.test.MultiplyTests;

// https://examples.javacodegeeks.com/core-java/junit/junit-suite-test-example/

@RunWith(Suite.class)
@SuiteClasses({
	AddTests.class,
	MultiplyTests.class
})
public class SuiteTests {

	private static final Logger LOG = LoggerFactory.getLogger(SuiteTests.class);

	@Test
	public void notExecuted() {
		LOG.info("Some fancy text (not visible) ...");
	}

}
