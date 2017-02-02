package com.github.aha.poc.junit4.theory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assume.assumeTrue;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

// https://www.javacodegeeks.com/2013/12/introduction-to-junit-theories.html

@RunWith(Theories.class)
public class DataPointsTests {

	@DataPoints
	public static int[] integers() {
		return new int[] { -1, -10, -1234567, 1, 10, 1234567 };
	}

	/**
	 * Prove theory: "For all a, b > 0  the following is true: a+b > a and a+b > b" 
	 */
	@Theory
	public void equality(Integer a, Integer b) {
		assumeTrue(a > 0 && b > 0);
		assertThat(a + b, is(greaterThan(a)));
		assertThat(a + b, is(greaterThan(b)));
	}

	/**
	 * Prove theory: "The following is true: a + b = b + a" 
	 */
	@Theory
	public void additionality(Integer a, Integer b) {
		assertThat(a + b, is(equalTo(b + a)));
	}
}
