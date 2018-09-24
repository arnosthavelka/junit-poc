package com.github.aha.poc.junit5.integration.mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.github.aha.poc.junit5.integration.Calculator;

public class StaticTest {

	static Calculator calc;

	@BeforeAll
	static void init() {
		calc = mock(Calculator.class);
	}

	@AfterEach
	void finish() {
		reset(calc);
	}

	@Test
	public void addTwoNumbers() {
		when(calc.add(2, 3)).thenReturn(5);
		assertThat(calc.add(2, 3)).isEqualTo(5);
		verify(calc).add(2, 3);
		verify(calc, times(0)).add(2, 3, 4);
	}

	@Test
	public void addThreeNumbers() {
		when(calc.add(2, 3, 4)).thenReturn(9);
		assertThat(calc.add(2, 3, 4)).isEqualTo(9);
		verify(calc).add(2, 3, 4);
		verify(calc, times(0)).add(2, 3);
	}

}
