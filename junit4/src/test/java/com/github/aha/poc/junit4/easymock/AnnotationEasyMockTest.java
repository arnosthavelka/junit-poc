package com.github.aha.poc.junit4.easymock;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.aha.poc.junit4.Calculator;

@RunWith(EasyMockRunner.class)
public class AnnotationEasyMockTest {

	@Mock
	private static Calculator calc;

	@Test
	public void simpleTest() {
		expect(calc.add(2, 3)).andReturn(5);
		replay(calc);
		assertThat(calc.add(2, 3), is(equalTo(5)));
		verify(calc);
	}

}
