package com.github.aha.poc.junit5.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import lombok.extern.slf4j.Slf4j;

@Tag(TagConsts.B)
@Slf4j
public class BTest {

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
		log.info("Test name={}", ti.getTestMethod());
		log.info("Display name={}", ti.getDisplayName());
		log.info("Tags:");
		ti.getTags().stream().forEach(t -> log.info("\ttag={}", t));
		assertEquals(2, 1 + 1, () -> "Error message");
	}
}
