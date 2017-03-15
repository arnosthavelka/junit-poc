package com.github.aha.poc.junit5.intro;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExceptionTest {

	@Test
	@DisplayName("Check thrown exception for dividing by zero")
	void exceptionHandlingTest() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			assertThat(0, is(equalTo(5 / 0)));
		});
		// check exception message
		assertEquals(ArithmeticException.class, exception.getClass());
		assertEquals("/ by zero", exception.getMessage());
	}

}
