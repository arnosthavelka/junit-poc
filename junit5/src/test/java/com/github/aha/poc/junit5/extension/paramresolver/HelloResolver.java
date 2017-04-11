package com.github.aha.poc.junit5.extension.paramresolver;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class HelloResolver implements ParameterResolver {

	@Override
	public boolean supports(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		return parameterContext.getParameter().isAnnotationPresent(Hello.class);
	}

	@Override
	public Object resolve(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		String name = parameterContext.getParameter().getAnnotation(Hello.class).value();
		
		return String.format("Hello %s!", name);
	}

}
