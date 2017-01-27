package com.github.aha.poc.junit.v5;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

// http://stackoverflow.com/questions/38402155/eclipse-junit-5-support
@RunWith(JUnitPlatform.class)
@DisplayName("Basic tests in JUnit5")
public class BasicV5Tests {

	@Test
	@DisplayName("Simple assert via JUnit")
	void simpleJUnitAssert() {
		assertEquals(2, 1 + 1, () -> "Error message");
	}

	@Test
	@DisplayName("Simple assert via Hamcrest")
	public void simpleHamcrestAssert() {
		assertThat(true, is(equalTo(true)));
	}

	@Test
	@DisplayName("Check TestInfo feature")
	void checkMethodName(TestInfo testInfo) {
		Optional<Method> testMethod = testInfo.getTestMethod();
		assertThat(testMethod.isPresent(), is(equalTo(true)));
		assertThat("TestInfo is not injected correctly", "checkMethodName", is(equalTo(testMethod.get().getName())));
	}

	@Test
	@DisplayName("Check @Tag feature")
	@Tag("JUnit5")
	void checkTag(TestInfo testInfo) {
		Set<String> tags = testInfo.getTags();
		assertThat(tags, is(notNullValue()));
		assertThat(1, is(equalTo(tags.size())));
		Optional<String> firstTag = tags.stream().findFirst();
		assertThat(firstTag.isPresent(), is(equalTo(true)));
		assertThat("JUnit5", is(equalTo(firstTag.get())));
	}

}
