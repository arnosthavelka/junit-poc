package com.github.aha.poc.junit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MockitoTest {

	private static Calculator calc;

	@Before
	public void init() {
		calc = mock(Calculator.class);
		when(calc.add(2, 3)).thenReturn(5);
	}
	
	@After
	public void finish() {
		when(calc.add(2, 3));
	}
	
	@Test
	public void simpleTest() {
		assertThat(calc.add(2, 3), is(equalTo(5)));
	}

}
