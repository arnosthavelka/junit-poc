package com.github.aha.poc.junit5.params;

import static org.assertj.core.api.Assertions.assertThat;

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
	@ValueSource(strings = { "Hello", "World" })
	@DisplayName("check string values")
	void stringTest(String argument) {
		assertThat(argument.length()).isGreaterThan(1);
		assertThat(argument.contains("o")).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = { 2, 3, -2, 4, -5 })
	@DisplayName("check number values")
	void numberTest(int argument) {
		assertThat(argument).isNotNull();
		assertThat(argument).isNotEqualTo(0);
	}

	@ParameterizedTest
	@EnumSource(value = ParamTypes.class, names = { "INT", "LONG" })
	@DisplayName("check enum values")
	void enumTest(ParamTypes argument) {
		assertThat(argument).isNotNull();
	}

	@ParameterizedTest
	@MethodSource(value = "paramValues")
	@DisplayName("check method values")
	void methodTest(String argument) {
		assertThat(argument).isNotNull();
	}

	static String[] paramValues() {
		return new String[] { "one", "two" };
	}

	@ParameterizedTest
	@CsvSource({ "Rum, 70", "Whiskey, 50", "'Gin Fizz', 150" })
	@DisplayName("check CSV values")
	void csvTest(String key, int value) {
		assertThat(key).isNotNull();
		assertThat(value).isGreaterThan(0);
	}

	@ParameterizedTest
	@ArgumentsSource(CustomProvider.class)
	@DisplayName("check provider values")
	void providerTest(ParamTypes value) {
		assertThat(value).isNotNull();
		assertThat(value).isInstanceOf(ParamTypes.class);
	}

	@ParameterizedTest(name = "index={index}, source={0}")
	@ValueSource(strings = { "i", "L", "X" })
	@DisplayName("check converter feature")
	void converterTest(@ConvertWith(CustomConverter.class) ParamTypes value) {
		assertThat(value).isNotNull();
		assertThat(value).isInstanceOf(ParamTypes.class);
	}

}
