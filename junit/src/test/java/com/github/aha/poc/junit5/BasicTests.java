package com.github.aha.poc.junit5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import lombok.extern.slf4j.Slf4j;

@DisplayName("Basic tests in JUnit5")
@Slf4j
public class BasicTests {

	@BeforeEach
	private void init(TestInfo ti) {
		log.info("Test {} - {}", ti.getTestMethod().get(), Thread.currentThread().getName());
	}
	
	@Test
	@DisplayName("show simple assert via JUnit")
	void simpleJUnitAssert() {
		assertEquals(2, 1 + 1, () -> "Error message");
	}

	@Test
	@DisplayName("validate tags existence via JUnit")
	void allJUnitAssert(TestInfo testInfo) {
		Set<String> tags = testInfo.getTags();
		assertAll(() -> assertNotNull(tags), () -> assertEquals(0, tags.size()));
	}

	@Test
	@DisplayName("show simple assert via AssertJ")
	public void simpleAssertJAssert() {
		assertThat(true).isTrue();
		assertThat(1 + 1).isEqualTo(2);
		assertThat("hello").isNotEqualTo("hi");
		assertThat(LocalDate.of(2020, 7, 8)).isAfterOrEqualTo(LocalDate.now());
		assertThat(new ClassCastException()).isInstanceOf(RuntimeException.class);
		assertThat(Optional.of("hello")).isPresent().hasValue("hello");
	}

	@Test
	@DisplayName("check TestInfo feature")
	void checkMethodName(TestInfo testInfo) {
		Optional<Method> testMethod = testInfo.getTestMethod();
		assertThat(testMethod.isPresent()).isTrue();
		assertThat(testMethod.get().getName()).isEqualTo("checkMethodName");
	}

	@Test
	@DisplayName("check @Tag feature")
	@Tag("JUnit5")
	void checkTag(TestInfo testInfo) {
		Set<String> tags = testInfo.getTags();
		assertThat(tags).isNotNull();
		assertThat(tags.size()).isEqualTo(1);
		Optional<String> firstTag = tags.stream().findFirst();
		assertThat(firstTag.isPresent()).isTrue();
		assertThat(firstTag.get()).isEqualTo("JUnit5");
	}

}
