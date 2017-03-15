package com.github.aha.poc.junit4.easymock;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.aha.poc.junit4.Calculator;

public class SimpleEasyMockTest {

	private static Calculator calc;

	@Before
	public void init() {
		calc = createMock(Calculator.class);
		expect(calc.add(2, 3)).andReturn(5);
		replay(calc);		
	}
	
	@After
	public void finish() {
		verify(calc);
	}
	
	@Test
	public void simpleTest() {
		assertThat(calc.add(2, 3), is(equalTo(5)));
	}

}
