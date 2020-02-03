package com.github.aha.poc.junit5.kotlin

class KotlinCalc {
	
	fun sum(vararg values: Int): Int {
		return values.sum()
	}
	
}