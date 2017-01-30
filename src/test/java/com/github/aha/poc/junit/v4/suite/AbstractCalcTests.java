package com.github.aha.poc.junit.v4.suite;

import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.aha.poc.junit.v4.Calculator;

public abstract class AbstractCalcTests {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(AbstractCalcTests.class);

	protected static Calculator calc;
	
	@BeforeClass
	public static void init() {
		calc = new Calculator();
		LOG.info("Calculator initialized");
	}
	
	@Before
	public void checkCalcInstance() {
		LOG.debug("Calculator instance={}", calc.toString());
	}
	
}
