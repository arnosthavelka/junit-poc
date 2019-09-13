package com.github.aha.poc.junit5.extension.registerextension;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TempFileSystem implements AfterAllCallback {

	private Path root;

	public TempFileSystem(String subfolder) {
		try {
			root = Files.createTempDirectory(subfolder);
			log.info("Folder {} created", root.toString());
		} catch (IOException e) {
			log.error("Creation of the temporary folder failed!", e);
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
		log.info("Folder {} deleted", root.toString());
	}

}
