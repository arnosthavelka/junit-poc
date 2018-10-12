package com.github.aha.poc.junit5.lifecycle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StandardLifeCycleTest extends AbstractLifeCycleTest {

	static {
		log.info("[static] class LifeCycleTest initialization ...");
	}

	static {
		log.info("[instance] instance initialization ...");
	}

	@BeforeAll
	static void initClassByJunit() {
		log.info("[@BeforeAll] class initialization ...");
	}

	@BeforeEach
	void initTest() {
		log.info("[@BeforeEach] test preparation ...");
	}

	@Test
	void firstTest() {
		log.info("first test execution ...");
		assertEquals(2, 1 + 1);
	}

	@Test
	void secondTest() {
		log.info("second test execution ...");
		assertEquals(2, 1 + 1);
	}

	@AfterEach
	void destroyTest() {
		log.info("[@AfterEach] test destroy ...");
		super.destroyTestShared();
	}

}
