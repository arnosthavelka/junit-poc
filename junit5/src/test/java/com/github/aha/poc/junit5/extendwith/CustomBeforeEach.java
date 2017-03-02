package com.github.aha.poc.junit5.extendwith;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.TestExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomBeforeEach implements BeforeEachCallback {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(CustomBeforeEach.class);
	
	@Override
	public void beforeEach(TestExtensionContext context) throws Exception {
		LOG.info("Before method '{}'", context.getTestMethod().get().getName());
	}

}
