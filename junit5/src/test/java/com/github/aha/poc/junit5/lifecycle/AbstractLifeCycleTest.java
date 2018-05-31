package com.github.aha.poc.junit5.lifecycle;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractLifeCycleTest {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractLifeCycleTest.class);

	static {
		LOG.info("[static] class AbstractLifeCycleTest initialization ...");
	}

	@BeforeAll
	static void initClassByJunitShared() {
		LOG.info("[@BeforeAll] class initialization ...");
	}

	@BeforeEach
	void initTestShared() {
		LOG.info("[@BeforeEach] abstract test preparation ...");
	}

	@AfterEach
	void destroyTestShared() {
		LOG.info("[@AfterEach] abstract test destroy ...");
	}

	@AfterAll
	static void destroyClassByJunitShared() {
		LOG.info("[@AfterAll] abstract class destroy ...");
	}

}
