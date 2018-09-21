package com.github.aha.poc.junit5.lifecycle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StandardLifeCycleTest extends AbstractLifeCycleTest {

	private static final Logger LOG = LoggerFactory.getLogger(StandardLifeCycleTest.class);

	static {
		LOG.info("[static] class LifeCycleTest initialization ...");
	}

	static {
		LOG.info("[instance] instance initialization ...");
	}

	@BeforeAll
	static void initClassByJunit() {
		LOG.info("[@BeforeAll] class initialization ...");
	}

	@BeforeEach
	void initTest() {
		LOG.info("[@BeforeEach] test preparation ...");
	}

	@Test
	void firstTest() {
		LOG.info("first test execution ...");
		assertEquals(2, 1 + 1);
	}

	@Test
	void secondTest() {
		LOG.info("second test execution ...");
		assertEquals(2, 1 + 1);
	}

	@AfterEach
	void destroyTest() {
		LOG.info("[@AfterEach] test destroy ...");
		super.destroyTestShared();
	}

}
