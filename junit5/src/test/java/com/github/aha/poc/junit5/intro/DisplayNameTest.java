package com.github.aha.poc.junit5.intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Check display options")
public class DisplayNameTest {

	@Test
	@DisplayName("Dobrý den")
	void messageWithDiacritic() {
	}

	@Test
	@DisplayName("добрый день")
	void messageWithAzbuka() {
	}

	@Test
	@DisplayName("美好的一天")
	void messageWithMandarinChinese() {
	}

	@Test
	@DisplayName("Send ✉")
	void messageWithEmoticon() {
	}

}
