package com.github.aha.poc.junit4.runner.theory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// https://github.com/junit-team/junit4/wiki/Theories

@RunWith(Theories.class)
public class TestedOnTests {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(TestedOnTests.class);

	/**
	 * Prove theory: "every A is the aliquot number for any B number (i.e. theorem of B / A has no remaining)" 
	 */
    @Theory
	public void aliquotTest(
			@TestedOn(ints = {2, 4}) int a,
	        @TestedOn(ints = {8, 16, 24}) int b
	    ) {
    	LOG.debug("values: a={}, b={}", a, b);
      	assertThat((b / a) * a , is(equalTo(b)));
	}

	/**
	 * Prove theory: "all numbers are even" 
	 */
    @Theory
	public void evenNumbers(@TestedOn(ints = {8, 16, 24}) int a) {
    	assertThat(a % 2 , is(equalTo(0)));
	}

}