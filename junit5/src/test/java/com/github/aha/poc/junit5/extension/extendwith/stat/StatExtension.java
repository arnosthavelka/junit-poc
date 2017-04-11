package com.github.aha.poc.junit5.extension.extendwith.stat;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.TestExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatExtension implements AfterAllCallback, AfterEachCallback, AfterTestExecutionCallback, 
		BeforeEachCallback, BeforeTestExecutionCallback {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(StatExtension.class);
	
	private static final Namespace NAMESPACE = Namespace.create("org", "github", "aha", "poc", "junit5");
	
	private long startTime = System.currentTimeMillis();
	
	@Override
	public void beforeEach(TestExtensionContext context) throws Exception {
		String name = context.getTestMethod().get().getName();
		LOG.info("beforeEach - {}", name);
		storeDTO(context, name, new StatDTO(name));
	}

	@Override
	public void beforeTestExecution(TestExtensionContext context) throws Exception {
		String name = context.getTestMethod().get().getName();
		LOG.info("beforeTestExecution - {}", name);
		StatDTO dto = loadDTO(context, context.getTestMethod().get().getName(), StatDTO.class);
		dto.setStartTime(System.currentTimeMillis());
	}
	
	@Override
	public void afterTestExecution(TestExtensionContext context) throws Exception {
		String name = context.getTestMethod().get().getName();
		LOG.info("afterTestExecution - {}", name);
		StatDTO dto = loadDTO(context, name, StatDTO.class);
		dto.setEndTime(System.currentTimeMillis());
	}

	@Override
	public void afterEach(TestExtensionContext context) throws Exception {
		String name = context.getTestMethod().get().getName();
		StatDTO dto = loadDTO(context, name, StatDTO.class);
		LOG.info("afterEach - duration of the method '{}' was {} ms", dto.getName(), dto.getDuration());
	}

	@Override
	public void afterAll(ContainerExtensionContext context) throws Exception {
		LOG.info("afterAll - duration of complete test processing was {} ms", System.currentTimeMillis() - startTime);
	}

	private static <T> void storeDTO(ExtensionContext context, String key, T value) {
		context.getStore(NAMESPACE).put(key, value);
	}
 
	private static <T> T loadDTO(ExtensionContext context, String key, Class<T> requiredType) {
		return context.getStore(NAMESPACE).get(key, requiredType);
	}

}
