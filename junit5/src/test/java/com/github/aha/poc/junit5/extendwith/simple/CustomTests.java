package com.github.aha.poc.junit5.extendwith.simple;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(CustomBeforeEach.class)
public class CustomTests {
	
	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(CustomTests.class);
	
	@Test
	@ExtendWith(CustomAfterEach.class)
	void trueTest() {
		LOG.info("Testing TRUE ...");
		assertThat(true, equalTo(true));
	}

	@Test
	void falseTest() {
		LOG.info("Testing FALSE ...");
		assertFalse(1 == 2);
	}

}
