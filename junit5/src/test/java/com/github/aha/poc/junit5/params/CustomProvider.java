package com.github.aha.poc.junit5.params;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ObjectArrayArguments;

public class CustomProvider implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> arguments(ContainerExtensionContext context) throws Exception {
		return Stream.of(ParamTypes.INT, ParamTypes.LONG, ParamTypes.DOUBLE).map(ObjectArrayArguments::create);
	}

}
