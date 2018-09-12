package com.github.aha.poc.junit5.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Tag(TagConsts.B)
public class BTest {

	private static final Logger LOG = LoggerFactory.getLogger(BTest.class);
	
	@Test
	@DisplayName("Fast B test")
	@Tag(TagConsts.FAST)
	void fastAtest() {
		assertEquals(2, 1 + 1, () -> "Error message");
	}
	
	@Test
	@DisplayName("Slow B test")
	@Tag(TagConsts.SLOW)
	void slowAtest(TestInfo ti) {
		LOG.info("Test name={}", ti.getTestMethod());
		LOG.info("Display name={}", ti.getDisplayName());
		LOG.info("Tags:");
		ti.getTags().stream().forEach(t -> LOG.info("\ttag={}", t));
		assertEquals(2, 1 + 1, () -> "Error message");
	}
}
