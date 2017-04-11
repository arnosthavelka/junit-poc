package com.github.aha.poc.junit5.extension.extendwith.simple;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.TestExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomAfterEach implements AfterEachCallback {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(CustomAfterEach.class);
	
	@Override
	public void afterEach(TestExtensionContext context) throws Exception {
		LOG.info("After method '{}'", context.getTestMethod().get().getName());
	}

}
