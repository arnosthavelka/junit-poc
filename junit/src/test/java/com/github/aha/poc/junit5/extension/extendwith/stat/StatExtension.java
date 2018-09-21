package com.github.aha.poc.junit5.extension.extendwith.stat;

import java.util.Random;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatExtension implements AfterAllCallback, AfterEachCallback, AfterTestExecutionCallback,
		BeforeEachCallback, BeforeTestExecutionCallback {

	private static final Logger LOG = LoggerFactory.getLogger(StatExtension.class);

	private static final Namespace NAMESPACE = Namespace.create("org", "github", "aha", "poc", "junit5");

	private long startTime = System.currentTimeMillis();

	private static Random rg = new Random();

	@Override
	public void beforeEach(ExtensionContext context) {
		String name = context.getTestMethod().get().getName();
		LOG.info("test '{}' initialized", name);
		storeDTO(context, name, new StatDTO(name));
	}

	@Override
	public void beforeTestExecution(ExtensionContext context) {
		processWaiting(context, "before");
	}

	@Override
	public void afterTestExecution(ExtensionContext context) {
		processWaiting(context, "after");
	}

	@Override
	public void afterEach(ExtensionContext context) {
		StatDTO dto = retrieveDTO(context);
		long duration = System.currentTimeMillis() - dto.getStartTime();
		LOG.info("test '{}' finished in {} ms", dto.getName(), duration);
	}

	@Override
	public void afterAll(ExtensionContext context) {
		String name = context.getTestClass().get().getSimpleName();
		long duration = System.currentTimeMillis() - startTime;
		LOG.info("class '{}' finished {} ms", name, duration);
	}

	private static <T> void storeDTO(ExtensionContext context, String key, T value) {
		context.getStore(NAMESPACE).put(key, value);
	}

	private static <T> T loadDTO(ExtensionContext context, String key, Class<T> requiredType) {
		return context.getStore(NAMESPACE).get(key, requiredType);
	}

	private StatDTO retrieveDTO(ExtensionContext context) {
		String name = context.getTestMethod().get().getName();
		StatDTO dto = loadDTO(context, name, StatDTO.class);
		return dto;
	}

	private void processWaiting(ExtensionContext context, String event) {
		StatDTO dto = retrieveDTO(context);
		int waitingTime = rg.nextInt(100);
		LOG.info("test '{}' waits for {} ms {} UT", dto.getName(), waitingTime, event);
		randomWait(waitingTime);
	}

	private void randomWait(int waitingTime) {
		try {
			Thread.sleep(waitingTime);
		} catch (InterruptedException e) {
			LOG.error("Sleep interuppted ...", e);
		}
	}

}