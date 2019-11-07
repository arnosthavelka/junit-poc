package com.github.aha.poc.junit5.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BasicKotlinTests {

	@Test
	fun `simple assert with Kotlin`() {
		assertThat(0).isEqualTo(0);
	}

	@Test
	fun `isEmpty should return true for empty lists`() {
		val list = listOf<String>()
		assertTrue(list::isEmpty)
	}

}