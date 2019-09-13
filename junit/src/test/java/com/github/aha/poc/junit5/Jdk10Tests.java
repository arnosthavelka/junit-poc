package com.github.aha.poc.junit5;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Examples of local variable type inference (VAR) in JDK 10")
public class Jdk10Tests {

	@Test
	@DisplayName("should allow VAR variable as Integer")
	public void simpleVarInteger() {
		var result = 2;

		assertThat(1 + 1).isEqualTo(result);
	}

	@Test
	@DisplayName("should initialize VAR variable as array")
	public void simpleVarArray() {
		var array = of(0, 1, 2);

		assertThat(array.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("should check String variable type")
	public void simpleVarString() {
		var result = "Welcome to JDK 10";

		assertThat(result instanceof String).isTrue();
	}

}
