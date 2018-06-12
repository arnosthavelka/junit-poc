package com.github.aha.poc.junit5.integration.mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Spy;

import com.github.aha.poc.junit5.integration.Calculator;

import name.falgout.jeffrey.testing.junit.mockito.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SpyAndCaptorTest {

	@Spy
	private Calculator calc;

	@Captor
	ArgumentCaptor<int[]> argCaptor;

	@Test
	public void spyExample() {
		assertThat(calc.multiply(2, 3)).isEqualTo(6);
		verify(calc).multiply(2, 3);
		verify(calc, times(0)).add(2, 3);
	}

	@Test
	public void captorExample() {
		calc.multiply(2, 3);
		verify(calc).multiply(argCaptor.capture());
		assertThat(Arrays.asList(2, 3)).isEqualTo(argCaptor.getAllValues());
	}

}
