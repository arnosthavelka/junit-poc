package com.github.aha.poc.junit4.exception;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class SimpleExceptionTest {

	@Test(expected=ArithmeticException.class)
	public void exceptionHandlingTest() {
		assertThat(0, is(equalTo(5 / 0)));
	}	

}
