package com.github.aha.poc.junit4.mockito;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.github.aha.poc.junit4.Calculator;

@RunWith(MockitoJUnitRunner.class)
public class AnnotationMockitoTest {

	@Mock
	private static Calculator calc;

	@Test
	public void simpleTest() {
		when(calc.add(2, 3)).thenReturn(5);
		assertThat(calc.add(2, 3), is(equalTo(5)));
		verify(calc).add(2, 3);
	}

}
