package com.github.aha.poc.junit5.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CTest {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(CTest.class);
	
	@Test
	@DisplayName("Fast A test")
	void fastAtest() {
		assertEquals(2, 1 + 1, () -> "Error message");
	}
	
	@Test
	@DisplayName("Slow A test")
	void slowAtest(TestInfo ti) {
		LOG.info("Test name={}", ti.getTestMethod());
		LOG.info("Display name={}", ti.getDisplayName());
		LOG.info("Tags:");
		ti.getTags().stream().forEach(t -> LOG.info("\ttag={}", t));
		assertEquals(2, 1 + 1, () -> "Error message");
	}
}
