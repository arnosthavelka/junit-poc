package com.github.aha.poc.junit5.intro;


import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeoutTest {

	private static final Logger LOG = LoggerFactory.getLogger(TimeoutTest.class);
	
	@Test
	@DisplayName("Standard test without timeout")
	void standardTest() {
        assertTimeout(ofMinutes(2), () -> {
        	assertEquals(2, 1 + 1);
        });		
	}

	@Test
	@DisplayName("Timeouting test")
	void timeoutingTest() {
		long ms = System.currentTimeMillis();
		AssertionFailedError exception = assertThrows(AssertionFailedError.class, () -> {
	        assertTimeout(ofMillis(10), () -> {
	            // do some serious job :-)
	            Thread.sleep(100);
	            assertEquals(2, 1 + 1);
	        });
		});
		LOG.info("time={} ms", System.currentTimeMillis() - ms);
		// exception is not verified here
		LOG.info(exception.getMessage());
	}

	@Test
	@DisplayName("Timeouting test2")
	void timeoutingFailFastTest() {
		long ms = System.currentTimeMillis();
		AssertionFailedError exception = assertThrows(AssertionFailedError.class, () -> {
	        assertTimeoutPreemptively(ofMillis(10), () -> {
	            // do some serious job :-)
	            Thread.sleep(100);
	            assertEquals(2, 1 + 1);
	        });
		});
		LOG.info("time={} ms", System.currentTimeMillis() - ms);
		// exception is not verified here
		LOG.info(exception.getMessage());
	}
}
