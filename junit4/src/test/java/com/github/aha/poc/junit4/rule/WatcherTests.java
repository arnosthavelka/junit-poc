package com.github.aha.poc.junit4.rule;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// see http://java.dzone.com/articles/using-junit-test-name
public class WatcherTests {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(WatcherTests.class);
	
	@Rule
	public TestName name = new TestName();

	@Test
	public void readMethodName() {
		String testName = name.getMethodName();
		assertThat(testName, equalTo("readMethodName"));
		LOG.info("method name={}", testName);
	}

}
