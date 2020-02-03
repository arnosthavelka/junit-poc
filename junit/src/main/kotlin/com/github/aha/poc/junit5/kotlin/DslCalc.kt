package com.github.aha.poc.junit5.kotlin

class DslCalc() {

	var value: Double = 0.0

	infix fun init(value: Double): DslCalc {
		this.value = value
		return this
	}

	infix fun sum(values: List<Int>): Int {
		return values.sum()
	}

	infix fun plus(value: Double): DslCalc {
		this.value += value
		return this
	}

	infix fun minus(value: Double): DslCalc {
		this.value -= value
		return this
	}

	infix fun square(value: Double): Double {
		return Math.sqrt(value)
	}

}