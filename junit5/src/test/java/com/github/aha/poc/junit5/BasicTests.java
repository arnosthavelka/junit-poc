package com.github.aha.poc.junit5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Method;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

//@RunWith(JUnitPlatform.class)
@DisplayName("Basic tests in JUnit5")
public class BasicTests {

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
	}

	@Test
	@DisplayName("show simple assert via Hamcrest")
	public void simpleHamcrestAssert() {
		assertThat(true, equalTo(true));
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
