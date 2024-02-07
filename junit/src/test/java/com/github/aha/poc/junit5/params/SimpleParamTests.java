package com.github.aha.poc.junit5.params;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.condition.JRE.JAVA_17;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Simple parameterized tests")
public class SimpleParamTests {

	@ParameterizedTest
	@ValueSource(strings = { "Hello", "World" })
	void stringTest(String argument) {
		assertThat(argument.length()).isGreaterThan(1);
		assertThat(argument).contains("o");
	}

	@ParameterizedTest
	@ValueSource(ints = { 2, 3, -2, 4, -5 })
	void numberTest(int argument) {
		assertThat(argument).isNotEqualTo(0);
	}

	@ParameterizedTest
	@EnumSource(value = ParamTypes.class, names = { "INT", "LONG" })
	void enumTest(ParamTypes argument) {
		assertThat(argument).isNotNull();
	}

	@ParameterizedTest
	@MethodSource(value = "paramValues")
	void methodTest(String argument) {
		assertThat(argument).isNotNull();
	}

	static String[] paramValues() {
		return new String[] { "one", "two" };
	}

	@ParameterizedTest
	@CsvSource({ "Rum, 70", "Whiskey, 50", "'Gin Fizz', 150" })
	void csvSourceAsSimpleValues(String key, int value) {
		assertThat(key).isNotNull();
		assertThat(value).isGreaterThan(0);
	}

	@ParameterizedTest
	@CsvSource({ "Rum, 70", "Whiskey, 50", "'Gin Fizz', 150" })
	void csvSourceAsArgumentsAccessor(ArgumentsAccessor aa) {
		assertThat(aa.getString(0)).isNotNull();
		assertThat(aa.getInteger(1)).isGreaterThan(0);
	}

	@ParameterizedTest
	@CsvSource(textBlock = """
			Rum, 70
			Whiskey, 120
			'Gin Fizz', 150
			""")
	@EnabledForJreRange(min = JAVA_17)
	void csvSourceAsTextBlock(String key, int value) {
		if (key.length() < 5) {
			assertThat(value).isLessThan(100);
		} else {
			assertThat(value).isGreaterThan(100);
		}
	}

	@ParameterizedTest
	@CsvSource(useHeadersInDisplayName = true, textBlock = """
			DRINK		, PRICE
			Rum			, 70
			Whiskey		, 120
			'Gin Fizz'	, 150
			""")
	@EnabledForJreRange(min = JAVA_17)
	void csvSourceAsTextBlockWithHeaders(String key, int value) {
		if (key.length() < 5) {
			assertThat(value).isLessThan(100);
		} else {
			assertThat(value).isGreaterThan(100);
		}
	}

	@ParameterizedTest
	@ArgumentsSource(FibonacciProvider.class)
	void providerTest(Number value) {
		assertThat(value).isNotNull();
	}

}
