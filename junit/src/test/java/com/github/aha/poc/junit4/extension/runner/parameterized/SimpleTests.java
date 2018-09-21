package com.github.aha.poc.junit4.extension.runner.parameterized;

import static org.junit.Assume.assumeTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// https://github.com/junit-team/junit4/wiki/Parameterized-tests
@RunWith(Parameterized.class)
public class SimpleTests {

	private static final Logger LOG = LoggerFactory.getLogger(SimpleTests.class);	

	@Parameters
	public static Collection<Integer> data() {
		return Arrays.asList(5, -5, 10, 100);
	}

	@Parameter
	public int value;

	@Test
	public void checkInputValue() {
		assumeTrue(value > 0);
		LOG.info("Value={}", value);
	}

}
