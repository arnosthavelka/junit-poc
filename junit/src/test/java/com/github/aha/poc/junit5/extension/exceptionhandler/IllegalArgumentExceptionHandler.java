package com.github.aha.poc.junit5.extension.exceptionhandler;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IllegalArgumentExceptionHandler implements TestExecutionExceptionHandler {

	@Override
	public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
		Throwable exception = throwable.getCause();
		if (exception instanceof IllegalArgumentException) {
			log.warn("Test method {} received this exception: {}", context.getDisplayName(), exception.getMessage());
			return;
		}
		throw throwable;
	}

}
