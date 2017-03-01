package com.github.aha.poc.junit4.runner.theory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;

// https://github.com/junit-team/junit4/wiki/Theories

@RunWith(Theories.class)
public class TestedOnTests {

	/**
	 * Prove theory: "every B can be divide by every A without any remaining" 
	 */
    @Theory
	public void multiplication(
			@TestedOn(ints = {2, 4}) int a,
	        @TestedOn(ints = {8, 16, 24, }) int b
	    ) {
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