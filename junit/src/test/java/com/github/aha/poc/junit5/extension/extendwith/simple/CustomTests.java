package com.github.aha.poc.junit5.extension.extendwith.simple;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(CustomBeforeEach.class)
public class CustomTests {

	private static final Logger LOG = LoggerFactory.getLogger(CustomTests.class);

	@Test
	@ExtendWith(CustomAfterEach.class)
	void trueTest() {
		LOG.info("Testing TRUE ...");
		assertThat(true).isTrue();
	}

	@Test
	void falseTest() {
		LOG.info("Testing FALSE ...");
		assertThat(1 == 2).isFalse();
	}

}
