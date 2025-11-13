package com.github.aha.poc.junit5;

import static org.junit.jupiter.api.condition.JRE.JAVA_21;
import static org.junit.jupiter.api.condition.JRE.JAVA_25;
import static org.junit.jupiter.api.condition.OS.WINDOWS;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ConditionalTests {

	@Test
	@EnabledOnOs(WINDOWS)
	void enabledOnWindowsOnly() {
		showOsProperties();
	}

	@Test
	@EnabledOnOs(WINDOWS)
	@DisabledIfSystemProperty(named = "os.version", matches = ".*10.*")
	void enabledOnWindowsExceptVersion10() {
		showOsProperties();
	}

	@Test
	@EnabledOnJre(JAVA_25 )
	void enabledForJdk25Only() {
		showOsProperties();
	}

	@Test
	@EnabledForJreRange(min = JAVA_21, max=JAVA_25)
	void enabledForJdkFrom21To25() {
		showOsProperties();
	}

	private void showOsProperties() {
		log.info("OS={}", System.getProperty("os.name"));
		log.info("Version={}", System.getProperty("os.version"));
	}

}
