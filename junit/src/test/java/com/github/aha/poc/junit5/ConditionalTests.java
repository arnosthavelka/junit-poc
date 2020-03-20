package com.github.aha.poc.junit5;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.condition.JRE.JAVA_10;
import static org.junit.jupiter.api.condition.JRE.JAVA_11;
import static org.junit.jupiter.api.condition.JRE.JAVA_8;
import static org.junit.jupiter.api.condition.JRE.OTHER;
import static org.junit.jupiter.api.condition.OS.WINDOWS;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;

import lombok.extern.slf4j.Slf4j;

@DisplayName("Examples of conditional tests")
@Slf4j
public class ConditionalTests {

	@Test
	@EnabledOnOs(WINDOWS)
	@DisplayName("enable test on Windows")
	void testOnWindowsOnly() {
		showOsProperties();
	}

	@Test
	@EnabledOnOs(WINDOWS)
	@DisabledIfSystemProperty(named = "os.version", matches = ".*10.*")
	@DisplayName("enable test on Windows except version 10")
	public void testOnWindowsExceptVersion10() {
		showOsProperties();
	}

	@Test
	@EnabledOnJre({ JAVA_8, JAVA_10, JAVA_11, OTHER })
	@DisplayName("enable test on JDK 9 only")
	void testForJdk9(TestInfo testInfo) {
		showOsProperties();
	}

	@Test
	@EnabledForJreRange(min = JAVA_11)
	void checkJdk11Feature() {
		showOsProperties();
		assertThat("".isBlank()).isTrue();
		assertThat("x\ny\nz".lines().collect(toList()).size()).isEqualTo(3);
	}

	private void showOsProperties() {
		log.info("OS={}", System.getProperty("os.name"));
		log.info("Version={}", System.getProperty("os.version"));
		assertThat(true).isTrue();
	}

}
