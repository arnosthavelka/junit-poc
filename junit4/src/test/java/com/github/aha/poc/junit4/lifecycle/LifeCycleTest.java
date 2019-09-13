package com.github.aha.poc.junit4.lifecycle;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LifeCycleTest extends AbstractLifeCycleTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(LifeCycleTest.class);	
	
	static {
		LOG.info("[static] class LifeCycleTest initialization ...");
	}

	static {
		LOG.info("[instance] instance initialization ...");
	}
	
	@BeforeClass
	public static void initClassByJunit() {
		LOG.info("[@BeforeClass] class initialization ...");
	}
	
	@Before
	public void initTest() {
		LOG.info("[@Before] test preparation ...");
	}
	
	@Test
	public void firstTest() {
		LOG.info("first test execution ...");
		assertThat(2, is(equalTo(1 + 1)));
	}

	@Test
	public void secondTest() {
		LOG.info("second test execution ...");
		assertThat(2, is(equalTo(1 + 1)));
	}

	@After
	public void destroyTest() {
		LOG.info("[@After] test destroy ...");
		super.destroyTest();
	}
	
}
