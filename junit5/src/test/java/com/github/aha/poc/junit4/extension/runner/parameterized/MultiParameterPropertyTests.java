package com.github.aha.poc.junit4.extension.runner.parameterized;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Parameterized.class)
public class MultiParameterPropertyTests {

	private static final Logger LOG = LoggerFactory.getLogger(MultiParameterPropertyTests.class);	

	@Parameters
	public static Collection<Integer[]> data() {
		return Arrays.asList(new Integer[][] { {1, 1}, {2, 4}, {3, 9}, {4, 16}, {5, 25} });
	}

	@Parameter(0)
	public Integer value1;
	
	@Parameter(1)
	public Integer value2;

	@Test
	public void testFibonacci() {
		LOG.debug("Tested value {} + {}", value1, value2);
	}
}
