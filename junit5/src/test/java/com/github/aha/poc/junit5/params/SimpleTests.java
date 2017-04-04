package com.github.aha.poc.junit5.params;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Parameterized tests in JUnit5")
public class SimpleTests {

	@ParameterizedTest
	@ValueSource(strings = { "Hello", "World", "!" })
	@DisplayName("check string values")
	void stringTest(String argument) {
		assumeTrue(argument.length() > 1);
		assertThat(argument.contains("o"), equalTo(true));
		
	}

	@ParameterizedTest
	@ValueSource(ints = { 2, 3, -2, 4, -5})
	@DisplayName("check number values")
	void numberTest(int argument) {
		assumeTrue(argument > 0);
		assertNotNull(argument);
	}

	@ParameterizedTest
	@EnumSource(ParamTypes.class)
	@DisplayName("check enum values")
	void enumTest(ParamTypes argument) {
		assertNotNull(argument);
	}

}
