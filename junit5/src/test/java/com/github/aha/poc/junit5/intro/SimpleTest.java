package com.github.aha.poc.junit5.intro;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * The simplest test for JUnit 5. The runner <code>JUnitPlatform</code> can be
 * used to run tests in JUnit 4.
 */
@RunWith(JUnitPlatform.class)
public class SimpleTest {
	
	@Test
	@DisplayName("Description of the real test")
	void firstRealTest(TestInfo testInfo) {
		assertEquals("Description of the real test", testInfo.getDisplayName(), "Error message");
	}

}
