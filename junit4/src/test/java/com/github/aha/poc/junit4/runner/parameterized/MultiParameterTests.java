package com.github.aha.poc.junit4.runner.parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// https://github.com/junit-team/junit4/wiki/Parameterized-tests

@RunWith(Parameterized.class)
public class MultiParameterTests {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(MultiParameterTests.class);	

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 {1, 1}, {2, 4}, {3, 9}, {4, 16}, {5, 25} 
           });
    }

	private int value;

    private int expectedResult;

    public MultiParameterTests(int input, int expected) {
    	value = input;
        expectedResult = expected;
    }	

	@Test
	public void testExponent() {
		int result = value * value;
		LOG.debug("{} * {} = {}", value, value, result);
		assertThat(expectedResult, is(equalTo(result)));
	}
}
