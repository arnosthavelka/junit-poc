package com.github.aha.poc.junit5.intro;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.aha.poc.junit.person.PersonService;

class PrivateTest {

	@Test
	@DisplayName("check hidden private constructor")
	void testPrivateConstructor() {
		assertThrows(NoSuchMethodException.class, () -> PersonService.class.getConstructor().newInstance());
	}

}
