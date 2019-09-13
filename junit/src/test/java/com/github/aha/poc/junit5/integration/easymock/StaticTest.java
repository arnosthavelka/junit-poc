package com.github.aha.poc.junit5.integration.easymock;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.reset;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.github.aha.poc.junit.Calculator;

public class StaticTest {

	static Calculator calc;

	@BeforeAll
	static void init() {
		calc = createMock(Calculator.class);
	}

	@AfterEach
	void finish() {
		verify(calc);
		reset(calc);
	}

	@Test
	public void addTwoNumbers() {
		expect(calc.add(2, 3)).andReturn(5);
		replay(calc);

		assertThat(calc.add(2, 3), is(equalTo(5)));
	}

	@Test
	public void addThreeNumbers() {
		expect(calc.add(2, 3, 4)).andReturn(9).times(1);
		replay(calc);

		assertThat(calc.add(2, 3, 4), is(equalTo(9)));
	}

}
