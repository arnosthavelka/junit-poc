package com.github.aha.poc.junit5.nested;

/**
 * Converts a flag attribute (defined with Boolean type) to a single-character
 * Y/N string and vice-versa.
 */

public class FlagConverter {

	public static final String FLAG_ON = "Y";
	public static final String FLAG_OFF = "N";

	/**
	 * This implementation will return "Y" if the parameter is Boolean.TRUE,
	 * otherwise it will return "N" when the parameter is Boolean.FALSE.
	 * 
	 * @param value
	 *            Boolean
	 * @throws {@code
	 *             RuntimeException} when {@link null} value is passed
	 */
	public String convertToFlag(Boolean value) {

		if (value == null) {
			throw new RuntimeException("The value NULL is not allowed for flag attribute!");
		}

		return value.booleanValue() ? FLAG_ON : FLAG_OFF;
	}

	/**
	 * This implementation will return Boolean.TRUE if the string is "Y" or "y",
	 * otherwise it will ignore the value and return Boolean.FALSE (it does not
	 * actually look for "N") for any other non-null string.
	 *
	 * @param value
	 *            String
	 * @throws {@code
	 *             RuntimeException} when {@link null} value is passed
	 */
	public Boolean convertFromValue(String value) {

		if (value == null) {
			throw new RuntimeException("The value NULL is not allowed for flag attribute!");
		}

		return value.equalsIgnoreCase(FLAG_ON) ? Boolean.TRUE : Boolean.FALSE;
	}

}
