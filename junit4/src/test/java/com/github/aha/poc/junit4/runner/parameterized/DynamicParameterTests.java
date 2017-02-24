package com.github.aha.poc.junit4.runner.parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.aha.poc.junit4.Fibonacci;

// https://github.com/junit-team/junit4/wiki/Parameterized-tests

@RunWith(Parameterized.class)
public class DynamicParameterTests {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DynamicParameterTests.class);	

	@Parameters
	public static Collection<Integer> data() {
		// generate 10 Fibonacci's values
		return Fibonacci.generate(10);
	}

	@Parameter
	public int value;

	@Test
	public void testFibonacci() {
		int[] result = Fibonacci.compute(value);
		LOG.debug("Fibonacci value {} = {} + {}", value, result[0], result[1]);
		assertThat(result[0] + result[1], is(equalTo(value)));
	}
}
