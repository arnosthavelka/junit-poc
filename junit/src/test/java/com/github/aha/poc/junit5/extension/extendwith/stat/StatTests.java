package com.github.aha.poc.junit5.extension.extendwith.stat;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

@Stat
public class StatTests {

	@Test
	void trueTest() {
		assertThat(true).isTrue();
	}

	@Test
	void falseTest() {
		assertThat(1 == 2).isFalse();
	}

}
