package com.github.aha.poc.junit5.advanced;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.condition.JRE.JAVA_14;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;

@DisplayName("Examples of JDK 14 festures")
@EnabledForJreRange(min = JAVA_14)
public class Jdk14Tests {

	// TODO: records - https://www.baeldung.com/java-record-keyword
	// Switch Expressions

	public record Xyz(int x, int y) {
	}

	@Test
	public void checkInstanceofFeature() {
		var text = "text";

		if (text instanceof String s && s.length() > 2) {
			assertThat(text.length()).isEqualTo(4);
		}
	}

	@Test
	@DisplayName("should check text block feature")
	public void checkBlockTextFeature() {
		assertThat("first line\nsecond line".lines().count()).isEqualTo(2);

		assertThat("""
				first line
				second line
				""".lines().count()).isEqualTo(2);

		assertThat("""
				single \
				line""").isEqualTo("single line");

		assertThat("""
				5 spaces    \s
				end""").isEqualTo("5 spaces     \nend");

		assertThat("""
				Values: \
				int=%d, \
				string=%s""".formatted(5, "text")).isEqualTo("Values: int=5, string=text");
	}

}
