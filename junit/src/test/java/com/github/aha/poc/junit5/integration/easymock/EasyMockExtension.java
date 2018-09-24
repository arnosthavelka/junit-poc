package com.github.aha.poc.junit5.integration.easymock;

import org.easymock.EasyMockSupport;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

public class EasyMockExtension implements TestInstancePostProcessor {

	@Override
	public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
		EasyMockSupport.injectMocks(testInstance);
	}
}
