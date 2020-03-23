package com.github.aha.poc.junit5.extension.registerextension;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegisterExtensionTest {

	@RegisterExtension
	static TempFileSystem tempFS = new TempFileSystem("ju5-fs-");

	@RegisterExtension
	TempFileGenerator tempGenerator = new TempFileGenerator(tempFS);

	@Test
	public void test1() {
		log.info("First temporary file={}", tempGenerator.getTempFile());
		assertThat(true).isTrue();
	}

	@Test
	public void test2() {
		log.info("Second temporary file={}", tempGenerator.getTempFile());
		assertThat(true).isTrue();
	}

}