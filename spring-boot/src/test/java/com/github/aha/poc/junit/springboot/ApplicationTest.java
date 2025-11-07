package com.github.aha.poc.junit.springboot;

import static org.assertj.core.util.Arrays.array;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class ApplicationTest {

	@Test
	void checkContext() {
		assertDoesNotThrow(() -> Application.main(array()));
	}

}
