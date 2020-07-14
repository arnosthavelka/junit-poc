package com.github.aha.poc.junit5.advanced;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.condition.JRE.JAVA_14;

import java.util.Objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;

@DisplayName("Examples of JDK 14 festures")
@EnabledForJreRange(min = JAVA_14)
public class Jdk14Tests {

	// TODO: Switch Expressions

	record LogEntry(String message) {

		public LogEntry {
			Objects.requireNonNull(message);
		}

		public <V> LogEntry(String message, V value) {
			if (value instanceof Number n) {
				this.message = format("%s [number=%d]", message, n);
			} else if (value instanceof String s && s.length() > 10) {
				this.message = format("%s [value='%s', length=%d]", message, s, s.length());
			} else {
				this.message = format("%s '%s'", message, value.toString());
			}
		}
	}

	@Test
	public void checkRecordFeature() {
		assertThat(new LogEntry("The counter reached the limit", 5).message()).isEqualTo("The counter reached the limit [number=5]");
		assertThat(new LogEntry("The value is too large! The maximum expected size is 10", "Some shiny message").message())
				.isEqualTo("The value is too large! The maximum expected size is 10 [value='Some shiny message', length=18]");
		assertThat(new LogEntry("Today is", "Wednesday").message()).isEqualTo("Today is 'Wednesday'");
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
