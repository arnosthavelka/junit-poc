package com.github.aha.poc.junit5.integration.easymock;

import static org.easymock.EasyMockSupport.injectMocks;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import org.junit.jupiter.api.extension.TestInstancePreDestroyCallback;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EasyMockExtension implements TestInstancePostProcessor, TestInstancePreDestroyCallback {

	@Override
	public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
		// manual mocking of dependencies
		injectMocks(testInstance);
	}

	@Override
	public void preDestroyTestInstance(ExtensionContext context) throws Exception {
		// manual cleaning of created mocks
		Object testInstance = context.getTestInstance().get();
		if (testInstance instanceof AnnotationTest) {
			((AnnotationTest) testInstance).calc = null;
			log.info("Calc instance in test class {} destroyed", testInstance.getClass().getSimpleName());
		}
	}
}
