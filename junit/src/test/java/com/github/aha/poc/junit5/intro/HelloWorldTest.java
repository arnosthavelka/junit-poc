package com.github.aha.poc.junit5.intro;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HelloWorldTest {

	@Test
	void helloWorld() {
		assertEquals(2, 1 + 1);
	}

}
