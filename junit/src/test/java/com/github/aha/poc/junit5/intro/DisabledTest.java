package com.github.aha.poc.junit5.intro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DisabledTest {

	@Test
	@Disabled("running very long")
	@DisplayName("Run complete integration tests")
	void completeIntegrationTests() {
		// ...
		assertThat(true).isTrue();
	}

}
