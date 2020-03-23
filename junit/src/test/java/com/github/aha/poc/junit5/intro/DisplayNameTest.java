package com.github.aha.poc.junit5.intro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Check display options")
public class DisplayNameTest {

	@Test
	@DisplayName("Dobrý den")
	void messageWithDiacritic() {
		assertThat(true).isTrue();
	}

	@Test
	@DisplayName("добрый день")
	void messageWithAzbuka() {
		assertThat(true).isTrue();
	}

	@Test
	@DisplayName("美好的一天")
	void messageWithMandarinChinese() {
		assertThat(true).isTrue();
	}

	@Test
	@DisplayName("Send ✉")
	void messageWithEmoticon() {
		assertThat(true).isTrue();
	}

}
