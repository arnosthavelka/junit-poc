package com.github.aha.poc.junit5.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


// https://www.baeldung.com/junit-5-kotlin
class BasicKotlinTests {

	@Test
	fun `simple assert with Kotlin`() {
		assertThat(0).isEqualTo(0)
	}

	@Test
	fun `isEmpty should return true for empty lists`() {
		val list = listOf<String>()
		assertTrue(list::isEmpty) {
			"list is not empty"
		}
	}

	@Test
	fun `devide by zero should throw ArithmeticException exception`() {
		val exception = assertThrows(ArithmeticException::class.java) {
			5 / 0
		}
		assertThat(exception.getLocalizedMessage()).isEqualTo("/ by zero")
	}

}