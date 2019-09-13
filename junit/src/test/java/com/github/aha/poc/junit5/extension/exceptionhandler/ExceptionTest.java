package com.github.aha.poc.junit5.extension.exceptionhandler;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(IllegalArgumentExceptionHandler.class)
@Slf4j
public class ExceptionTest {

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
		log.trace("name={}", name);
	}

}
