package com.github.aha.poc.junit5.lifecycle;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractLifeCycleTest {

	static {
		log.info("[static] class AbstractLifeCycleTest initialization ...");
	}

	@BeforeAll
	static void initClassByJunitShared() {
		log.info("[@BeforeAll] class initialization ...");
	}

	@BeforeEach
	void initTestShared() {
		log.info("[@BeforeEach] abstract test preparation ...");
	}

	@AfterEach
	void destroyTestShared() {
		log.info("[@AfterEach] abstract test destroy ...");
	}

	@AfterAll
	static void destroyClassByJunitShared() {
		log.info("[@AfterAll] abstract class destroy ...");
	}

}
