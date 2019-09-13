package com.github.aha.poc.junit5.extension.exceptionhandler;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IllegalArgumentExceptionHandler implements TestExecutionExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(IllegalArgumentExceptionHandler.class);

	@Override
	public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
		Throwable exception = throwable.getCause();
		if (exception instanceof IllegalArgumentException) {
			LOG.warn("Test method {} received this exception: {}", context.getDisplayName(), exception.getMessage());
			return;
		}
		throw throwable;
	}

}
