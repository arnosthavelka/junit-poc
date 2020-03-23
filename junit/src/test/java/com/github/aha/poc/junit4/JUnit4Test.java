package com.github.aha.poc.junit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

//@RunWith(JUnit4.class)
@Slf4j
public class JUnit4Test {

	@Test
	public void simpleTest() {
		log.debug("simpleTest");
		assertTrue(true);
	}

	@Test
	@Ignore // NOSONAR
	public void disabledTest() {
		log.debug("simpleTest");
		assertThat(true, is(equalTo(true)));
	}

	@Test
	public void simpleHamcrestAssert() {
		assertThat(true, is(true));
		assertThat(1 + 1, equalTo(2));
		assertThat("hello", not(equalTo("hi")));
	}

	@Test(expected = ArithmeticException.class)
	public void exceptionTest() {
		assertThat(0, is(equalTo(5 / 0)));
	}

	@Test(timeout = 50)
	public void timeoutTest() {
		assertThat(1 + 1, is(equalTo(2)));
	}
}
