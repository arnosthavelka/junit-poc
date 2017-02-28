package com.github.aha.poc.junit5.nested;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

// based on http://blog.codefx.org/libraries/junit-5-basics/#Nesting-Tests
@DisplayName("A counter")
class NestedTest {
	 
	int count = Integer.MIN_VALUE;
 
	@BeforeEach
	void setCountToZero() {
		count = 0;
	}
 
	@Test
	@DisplayName("is zero")
	void countIsZero() {
		assertEquals(0, count);
	}
 
	@Nested
	@DisplayName("when increased by 1")
	class CountGreaterZero {
 
		@BeforeEach
		void increaseCount() {
			count++;
		}
 
		@Test
		@DisplayName("is greater than zero")
		void countIsGreaterZero() {
			assertTrue(count > 0);
			assertEquals(1, count);
		}
 
		@Nested
		@DisplayName("when increased by 2")
		class CountMuchGreaterZero {
 
			@BeforeEach
			void increaseCount() {
				count += 2;
			}
 
			@Test
			@DisplayName("equals 3")
			void countIsLarge() {
				assertTrue(count > 0);
				assertEquals(3, count);
			}
 
		}
 
	}
 
}
