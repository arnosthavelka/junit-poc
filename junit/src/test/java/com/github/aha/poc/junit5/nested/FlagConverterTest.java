package com.github.aha.poc.junit5.nested;

import static com.github.aha.poc.junit5.nested.FlagConverter.FLAG_OFF;
import static com.github.aha.poc.junit5.nested.FlagConverter.FLAG_ON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Verify that FlagConverter")
public class FlagConverterTest {

	private FlagConverter converter = new FlagConverter();

	@Nested
	@DisplayName("should convert from a flag to the value")
	class ConversionFromFlag {

		@Test
		@DisplayName("convert true flag to 'Y'")
		void convertTrueToY() {
			assertThat(converter.convertToFlag(true)).isEqualTo(FLAG_ON);
		}

		@Test
		@DisplayName("convert false flag to 'N'")
		void convertFalseToN() {
			assertThat(converter.convertToFlag(false)).isEqualTo(FLAG_OFF);
		}

		@Test
		@DisplayName("fail for NULL value")
		void failForNullValue() {
			assertThrows(RuntimeException.class, () -> converter.convertToFlag(null));
		}

	}

	@Nested
	@DisplayName("should convert from a value to the flag")
	class ConversionFromValue {

		@Test
		@DisplayName("convert 'Y' to flag true")
		void convertYToTrue() {
			assertThat(converter.convertFromValue(FLAG_ON)).isTrue();
		}

		@Test
		@DisplayName("convert 'N' to flag false")
		void convertNToFalse() {
			assertThat(converter.convertFromValue(FLAG_OFF)).isFalse();
		}

		@Test
		@DisplayName("fail with NULL value")
		void failForNullValue() {
			assertThrows(RuntimeException.class, () -> converter.convertFromValue(null));
		}

	}

}