package com.github.aha.poc.junit5.extension.extendwith.simple;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomBeforeEach implements BeforeEachCallback {

	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		log.info("Before method '{}'", context.getTestMethod().get().getName());
	}

}
