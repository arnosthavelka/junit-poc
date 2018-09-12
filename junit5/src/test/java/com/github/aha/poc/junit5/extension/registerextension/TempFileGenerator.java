package com.github.aha.poc.junit5.extension.registerextension;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TempFileGenerator implements BeforeEachCallback, AfterEachCallback {

	private static final Logger LOG = LoggerFactory.getLogger(TempFileGenerator.class);

	private Path rootPath;

	private Path tempFile;

	public TempFileGenerator(TempFileSystem tempFS) {
		rootPath = tempFS.getRoot();
	}

	public Path getTempFile() {
		return tempFile;
	}

	@Override
	public void beforeEach(ExtensionContext context) throws Exception {
		tempFile = Files.createTempFile(rootPath, "ju5-", "-test.txt");
		LOG.info("File {} created", tempFile.toString());
	}

	@Override
	public void afterEach(ExtensionContext context) throws Exception {
		Files.delete(tempFile);
		LOG.info("File {} deleted", tempFile.toString());
	}

}
