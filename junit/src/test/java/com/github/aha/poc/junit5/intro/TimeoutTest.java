package com.github.aha.poc.junit5.intro;


import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeoutTest {

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
		long ms = currentTimeMillis();
		AssertionFailedError exception = assertThrows(AssertionFailedError.class, () -> {
	        assertTimeout(ofMillis(10), () -> {
	            // do some serious job :-)
				sleep(100); // NOSONAR
	            assertEquals(2, 1 + 1);
	        });
		});
		log.info("time={} ms", currentTimeMillis() - ms);
		// exception is not verified here
		log.info(exception.getMessage());
	}

	@Test
	@DisplayName("Timeouting test2")
	void timeoutingFailFastTest() {
		long ms = currentTimeMillis();
		AssertionFailedError exception = assertThrows(AssertionFailedError.class, () -> {
	        assertTimeoutPreemptively(ofMillis(10), () -> {
	            // do some serious job :-)
				sleep(100); // NOSONAR
	            assertEquals(2, 1 + 1);
	        });
		});
		log.info("time={} ms", currentTimeMillis() - ms);
		// exception is not verified here
		log.info(exception.getMessage());
	}
}
