package com.github.aha.poc.junit4.exception;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RuleExceptionTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void normalTest() {
        // no exception expected, none thrown: passes.
    }
    
	@Test
	public void exceptionHandlingTest() {
		thrown.expect(ArithmeticException.class);
		assertThat(0, is(equalTo(5 / 0)));
	}	

	@Test
	public void customExceptionHandlingTest() {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("error message");
		throw new RuntimeException("error message");
	}

}
