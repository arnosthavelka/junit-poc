package com.github.aha.poc.junit5.intro;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class HelloWorldTest {

	@Test
	void helloWorld(TestInfo testInfo) {
		assertEquals(2, 1 + 1);
	}

}
