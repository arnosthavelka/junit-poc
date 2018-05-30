package com.github.aha.poc.junit5.extension.registerextension;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TempFileSystem implements AfterAllCallback {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(TempFileSystem.class);

	private Path root;

	public TempFileSystem(String subfolder) {
		try {
			root = Files.createTempDirectory(subfolder);
			LOG.info("Folder {} created", root.toString());
		} catch (IOException e) {
			LOG.error("Creation of the temporary folder failed!", e);
		}
	}

	public Path getRoot() {
		return root;
	}

	@Override
	public void afterAll(ExtensionContext context) throws Exception {
		Files.walk(root)
			.sorted(Comparator.reverseOrder())
			.map(Path::toFile)
			.forEach(File::delete);
		LOG.info("Folder {} deleted", root.toString());
	}

}
