package com.github.aha.poc.junit5.extension.registerextension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterExtensionTest {

	private static final Logger LOG = LoggerFactory.getLogger(RegisterExtensionTest.class);

	@RegisterExtension
	static TempFileSystem tempFS = new TempFileSystem("ju5-fs-");

	@RegisterExtension
	TempFileGenerator tempGenerator = new TempFileGenerator(tempFS);

	@Test
	public void test1() {
		LOG.info("First temporary file={}", tempGenerator.getTempFile());

	}

	@Test
	public void test2() {
		LOG.info("Second temporary file={}", tempGenerator.getTempFile());

	}

}