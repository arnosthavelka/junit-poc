package com.github.aha.poc.junit5.nested;

import static com.github.aha.poc.junit5.nested.FlagConverter.FLAG_OFF;
import static com.github.aha.poc.junit5.nested.FlagConverter.FLAG_ON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Verify conversions by FlagConverter")
public class FlagConverterTest {

	private FlagConverter converter = new FlagConverter();

	@Nested
	@DisplayName("should convert from a flag to the value")
	class ConversionToFlag {

		@Test
		@DisplayName("convert true flag to 'Y'")
		void convertTrueToY() throws SQLException {
			assertThat(converter.convertToFlag(true)).isEqualTo(FLAG_ON);
		}

		@Test
		@DisplayName("convert false flag to 'N'")
		void convertFalseToN() throws SQLException {
			assertThat(converter.convertToFlag(false)).isEqualTo(FLAG_OFF);
		}

		@Test
		@DisplayName("don't accept NULL value")
		void raiseExceptionForNullValue() throws SQLException {
			assertThrows(RuntimeException.class, () -> converter.convertToFlag(null));
		}

	}

	@Nested
	@DisplayName("should convert from a value to the flag")
	class ConversionFromValue {

		@Test
		@DisplayName("convert 'Y' to flag true")
		void convertYToTrue() throws SQLException {
			assertThat(converter.convertFromValue(FLAG_ON)).isTrue();
		}

		@Test
		@DisplayName("convert 'N' to flag false")
		void convertNToFalse() throws SQLException {
			assertThat(converter.convertFromValue(FLAG_OFF)).isFalse();
		}

		@Test
		@DisplayName("don't accept NULL value")
		void raiseExceptionForNullValue() throws SQLException {
			assertThrows(RuntimeException.class, () -> converter.convertFromValue(null));
		}

	}

}