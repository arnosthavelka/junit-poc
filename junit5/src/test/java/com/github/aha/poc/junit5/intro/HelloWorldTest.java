package com.github.aha.poc.junit5.intro;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class HelloWorldTest {

	@Test
	@DisplayName("First real test")
	void firstRealTest(TestInfo testInfo) {
		assertEquals(2, 1 + 1);
		assertEquals("First real test", testInfo.getDisplayName(), "Error message");
	}

}
