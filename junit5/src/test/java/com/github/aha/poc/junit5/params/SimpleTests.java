package com.github.aha.poc.junit5.params;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
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

	@ParameterizedTest
	@MethodSource(value = "paramValues")
	@DisplayName("check method values")
	void methodTest(String argument) {
		assertNotNull(argument);
	}
	
	static Stream<String> paramValues() {
	    return Stream.of("one", "two");
	}

	@ParameterizedTest
	@CsvSource({ "Rum, 70", "Whiskey, 50", "'Gin Fizz', 150" })
	@DisplayName("check CSV values")
	void csvTest(String key, int value) {
		assertNotNull(key);
		assumeTrue(value > 0);
	}

	@ParameterizedTest
	@ArgumentsSource(CustomProvider.class)
	@DisplayName("check provider values")
	void providerTest(ParamTypes value) {
		assertNotNull(value);
		assertThat(value, instanceOf(ParamTypes.class));
	}

	@ParameterizedTest(name = "index={index}, source={0}")
	@ValueSource(strings = { "i", "L", "X" })
	@DisplayName("check converter feature")
	void converterTest(@ConvertWith(CustomConverter.class) ParamTypes value) {
		assertNotNull(value);
		assertThat(value, instanceOf(ParamTypes.class));
	}

}
