package com.github.aha.poc.junit4.lifecycle;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractLifeCycleTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(AbstractLifeCycleTest.class);	
	
	static {
		LOG.info("[static] class AbstractLifeCycleTest initialization ...");
	}
	
	@BeforeClass
	public static void initClassByJunit() {
		LOG.info("[@BeforeClass] class initialization ...");
		
	}
	
	@Before
	public void initTest() {
		LOG.info("[@Before] abstract test preparation ...");
	}
	
	@After
	public void destroyTest() {
		LOG.info("[@After] abstract test destroy ...");
	}
	
	@AfterClass
	public static void destroyClassByJunit() {
		LOG.info("[@AfterClass] abstract class destroy ...");
	}
	
}
