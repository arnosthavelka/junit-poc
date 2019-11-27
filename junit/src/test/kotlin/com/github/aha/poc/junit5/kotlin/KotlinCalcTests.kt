package com.github.aha.poc.junit5.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class KotlinCalcTests {

	@Test
	fun `initialize KotlinCalc`() {
		assertThat(KotlinCalc()).isNotNull();
	}

	@Test
	fun `should sum numbers`() {
		assertThat(KotlinCalc().sum(2, 8, 6)).isEqualTo(16);
	}

}