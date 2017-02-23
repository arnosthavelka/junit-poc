package com.github.aha.poc.junit5.intro;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DisabledTest {

	@Test
	@DisplayName("Incomplete test")
	@Disabled
	void incompleteTest() {
		// not working
		assertEquals(3, 1 + 1);
	}

}
