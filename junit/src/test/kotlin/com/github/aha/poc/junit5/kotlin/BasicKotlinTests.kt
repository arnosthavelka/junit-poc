package com.github.aha.poc.junit5.kotlin

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BasicKotlinTests {

	@Test
	fun `simple assert with Kotlin`() {
		assertEquals(0, 0)
	}

	@Test
	fun `isEmpty should return true for empty lists`() {
		val list = listOf<String>()
		Assertions.assertTrue(list::isEmpty)
	}

}