package com.github.aha.poc.junit5.lifecycle;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractLifeCycleTest {
	
	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(AbstractLifeCycleTest.class);	
	
	static {
		LOG.info("[static] class AbstractLifeCycleTest initialization ...");
	}
	
	@BeforeAll
	static void initClassByJunit() {
		LOG.info("[@BeforeAll] class initialization ...");
		
	}
	
	@BeforeEach
	void initTest() {
		LOG.info("[@BeforeEach] abstract test preparation ...");
		
	}
	
	@AfterEach
	void destroyTest() {
		LOG.info("[@AfterEach] abstract test destroy ...");
		
	}
	
	@AfterAll
	static void destroyClassByJunit() {
		LOG.info("[@AfterAll] abstract class destroy ...");
	}
	
}
