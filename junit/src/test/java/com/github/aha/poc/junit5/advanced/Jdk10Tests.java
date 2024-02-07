package com.github.aha.poc.junit5.advanced;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.condition.JRE.JAVA_10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;

@DisplayName("Examples of JDK 10 features")
@EnabledForJreRange(min = JAVA_10)
public class Jdk10Tests {

	@Test
	public void simpleVarInteger() {
		var result = 2;

		assertThat(1 + 1).isEqualTo(result);
	}

	@Test
	public void simpleVarArray() {
		var array = of(0, 1, 2);

		assertThat(array.size()).isEqualTo(3);
	}

	@Test
	public void simpleVarString() {
		var result = "Welcome to JDK 10";

		assertThat(result).isInstanceOf(String.class);
	}

}
