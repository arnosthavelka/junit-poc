package com.github.aha.poc.junit5.extension.extendwith.simple;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomBeforeEach implements BeforeEachCallback {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(CustomBeforeEach.class);
	
	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		LOG.info("Before method '{}'", context.getTestMethod().get().getName());
	}

}
