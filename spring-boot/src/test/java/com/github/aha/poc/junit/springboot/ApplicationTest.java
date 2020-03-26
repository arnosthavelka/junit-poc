package com.github.aha.poc.junit.springboot;

import static org.assertj.core.util.Arrays.array;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class ApplicationTest {

	@Test
	public void checkContext() {
		assertDoesNotThrow(() -> Application.main(array()));
	}

}
