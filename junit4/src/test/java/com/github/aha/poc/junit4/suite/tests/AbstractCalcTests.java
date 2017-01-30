package com.github.aha.poc.junit4.suite.tests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.aha.poc.junit4.Calculator;

/**
 * Ancestor for calculator tests in Suite example.  
 */
public abstract class AbstractCalcTests {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(AbstractCalcTests.class);

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
		LOG.debug("Calculator instance={}", calc.toString());
	}
	
}
