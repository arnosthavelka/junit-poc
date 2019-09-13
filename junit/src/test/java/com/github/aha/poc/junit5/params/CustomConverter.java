package com.github.aha.poc.junit5.params;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

public class CustomConverter implements ArgumentConverter {

	@Override
	public Object convert(Object input, ParameterContext context) throws ArgumentConversionException {
		switch (String.valueOf(input).toUpperCase()) {
		case "I":
			return ParamTypes.INT;
		case "L":
			return ParamTypes.LONG;
		case "D":
			return ParamTypes.DOUBLE;
		default:
			return ParamTypes.STRING;
		}

	}

}
