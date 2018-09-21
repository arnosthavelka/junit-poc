package com.github.aha.poc.junit4.extension.runner.suite.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.aha.poc.junit4.Calculator;

/**
 * Ancestor for calculator tests in Suite example.  
 */
public abstract class AbstractCalcTests {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractCalcTests.class);

	abstract Logger getLog();
	
	/**
	 * Shared instance of calculator.
	 */
	protected static Calculator calc;
	
	/**
	 * Block for all related tests in the hierarchy.
	 */
	static {
		LOG.info("Class initialized");
	}
	
	/**
	 * Block for all tests from the test class.
	 */
	@BeforeClass
	public static void init() {
		calc = new Calculator();
		LOG.info("Calculator initialized");
	}
	
	/**
	 * Block for the concrete test
	 */
	@Before
	public void checkCalcInstance() {
		getLog().debug("Calculator instance={}", calc.toString());
	}
	
}
