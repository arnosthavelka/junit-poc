package com.github.aha.poc.junit5;

import static org.hamcrest.CoreMatchers.notNullValue;
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
        assertAll(
                () -> assertNotNull(tags),
                () -> assertEquals(0, tags.size())
        );		
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
		assertThat(testMethod.isPresent(), equalTo(true));
		assertThat("TestInfo is not injected correctly", "checkMethodName", equalTo(testMethod.get().getName()));
	}

	@Test
	@DisplayName("check @Tag feature")
	@Tag("JUnit5")
	void checkTag(TestInfo testInfo) {
		Set<String> tags = testInfo.getTags();
		assertThat(tags, notNullValue());
		assertThat(1, equalTo(tags.size()));
		Optional<String> firstTag = tags.stream().findFirst();
		assertThat(firstTag.isPresent(), equalTo(true));
		assertThat("JUnit5", equalTo(firstTag.get()));
	}

}
