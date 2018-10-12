package com.github.aha.poc.junit5.extension.extendwith.simple;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAfterEach implements AfterEachCallback {

	@Override
	public void afterEach(ExtensionContext context) throws Exception {
		log.info("After method '{}'", context.getTestMethod().get().getName());
	}

}
