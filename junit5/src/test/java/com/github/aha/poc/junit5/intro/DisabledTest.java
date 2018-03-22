package com.github.aha.poc.junit5.intro;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DisabledTest {

	@Test
	@Disabled("running very long")
	@DisplayName("Run complete integration tests")
	void completeIntegrationTests() {
		// ...
	}

}
