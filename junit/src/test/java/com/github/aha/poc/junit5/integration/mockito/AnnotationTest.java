package com.github.aha.poc.junit5.integration.mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import com.github.aha.poc.junit.Calculator;

import name.falgout.jeffrey.testing.junit.mockito.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AnnotationTest {

	@Test
	public void mockExample(@Mock Calculator calc) {
		when(calc.add(2, 3)).thenReturn(5);
		assertThat(calc.add(2, 3)).isEqualTo(5);
		verify(calc).add(2, 3);
		verify(calc, times(0)).multiply(5, 6);
	}
}
