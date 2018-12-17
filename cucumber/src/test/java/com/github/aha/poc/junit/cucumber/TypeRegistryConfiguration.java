package com.github.aha.poc.junit.cucumber;

import static com.github.aha.poc.junit.cucumber.AdvancedCalculator.Operation.ADD;
import static com.github.aha.poc.junit.cucumber.AdvancedCalculator.Operation.MULTIPLY;
import static java.util.Locale.ENGLISH;

import java.util.Locale;

import com.github.aha.poc.junit.cucumber.AdvancedCalculator.Operation;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {

	@Override
	public Locale locale() {
		return ENGLISH;
	}

	@Override
	public void configureTypeRegistry(TypeRegistry typeRegistry) {
		ParameterType<Operation> paramType = new ParameterType<>(Operation.class.getSimpleName(),
				getOperationRegexpFromValues(), Operation.class, Operation::valueOf);
		typeRegistry.defineParameterType(paramType);

	}

	private String getOperationRegexpFromValues() {
		return ADD.name() + "|" + MULTIPLY.name();
	}

}
