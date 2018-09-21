package com.github.aha.poc.junit5.extension.exceptionhandler;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(IllegalArgumentExceptionHandler.class)
public class ExceptionTest {

	private static final Logger LOG = LoggerFactory.getLogger(ExceptionTest.class);

	@Test
	void validTest() {
		assertDoesNotThrow(() -> validateParam("Arny"));
	}

	@Test
	void handlerTest() {
		assertDoesNotThrow(() -> validateParam(null));
	}

	private void validateParam(String name) {
		if (Objects.isNull(name)) {
			throw new IllegalArgumentException("Parameter name cannot be empty!");
		}
		LOG.trace("name={}", name);
	}

}
