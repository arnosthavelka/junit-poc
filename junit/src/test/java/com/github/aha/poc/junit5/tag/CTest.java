package com.github.aha.poc.junit5.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CTest {

	@Test
	@DisplayName("Fast A test")
	void fastAtest() {
		assertEquals(2, 1 + 1, () -> "Error message");
	}
	
	@Test
	@DisplayName("Slow C test")
	void slowAtest(TestInfo ti) {
		log.info("Test name={}", ti.getTestMethod());
		log.info("Display name={}", ti.getDisplayName());
		log.info("Tags:");
		ti.getTags().stream().forEach(t -> log.info("\ttag={}", t));
		assertEquals(2, 1 + 1, () -> "Error message");
	}
}
