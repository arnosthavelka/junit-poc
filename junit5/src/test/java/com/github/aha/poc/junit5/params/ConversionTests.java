package com.github.aha.poc.junit5.params;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Conversion usage in parameterized tests")
public class ConversionTests {

	@ParameterizedTest
	@ValueSource(strings = { "https://junit.org/", "https://github.com/arnosthavelka/junit-poc" })
	@DisplayName("check standard conversion")
	public void standardConverterTest(URI value) {
		assertThat(value).isNotNull();
	}

	@ParameterizedTest(name = "index={index}, source={0}")
	@ValueSource(strings = { "i", "L", "X" })
	@DisplayName("check custom converter feature")
	void customConverterTest(@ConvertWith(CustomConverter.class) ParamTypes value) {
		assertThat(value).isNotNull();
		assertThat(value).isInstanceOf(ParamTypes.class);
	}

}
