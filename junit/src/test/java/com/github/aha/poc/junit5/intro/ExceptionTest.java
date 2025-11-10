package com.github.aha.poc.junit5.intro;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExceptionTest {

	@Test
	@DisplayName("Check thrown exception for dividing by zero")
	void exceptionHandlingTest() {
		Exception exception = assertThrows(RuntimeException.class, () -> assertThat(5 / 0).isEqualTo(0));
		assertThat(exception)
			.isInstanceOf(ArithmeticException.class)
			.hasMessage("/ by zero");
	}

}
