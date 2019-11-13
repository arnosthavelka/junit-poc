package com.github.aha.poc.junit5.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class KotlinCalcTests {

	@Test
	fun `initialize DslCalc`() {
		assertThat(DslCalc()).isNotNull();
	}

	@Test
	fun `should square number`() {
		val value = DslCalc();
		
		assertThat(value square 9.0).isEqualTo(3.0);
	}

	@Test
	fun `should calculate via DSL`() {
		val calc = DslCalc();
		
		calc init 5.0 plus 2.5 minus 3.0
		assertThat(calc.value).isEqualTo(4.5);
	}

	@Test
	fun `should calculate via methods`() {
		val calc = DslCalc();
		calc.init(5.0)
		calc.plus(3.5)
		calc.minus(1.4)
		calc.plus(0.9)
		
		assertThat(calc.value).isEqualTo(8.0);
	}

}