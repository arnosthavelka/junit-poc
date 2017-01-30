package com.github.aha.poc.junit.v4.suite;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.aha.poc.junit.v4.Calculator;

public abstract class AbstractCalcTests {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(AbstractCalcTests.class);

	protected static Calculator calc;
	
	static {
		calc = new Calculator();
	}
	
	@Before
	public void init() {
		LOG.info("Calculator instance={}", calc.toString());
	}
	
}
