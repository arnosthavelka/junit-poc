package com.github.aha.poc.junit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.core.IsNot.not;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//not required for default runner
//@RunWith(JUnit4.class)
public class BasicTest {

	private static final Logger LOG = LoggerFactory.getLogger(BasicTest.class);
	
	@Test
	public void simpleTest() {
		LOG.debug("simpleTest");
		assertTrue(true);
	}

	@Test
	@Ignore
	public void disabledTest() {
		LOG.debug("simpleTest");
		assertThat(true, is(equalTo(true)));
	}

	@Test
	public void simpleHamcrestAssert() {
		assertThat(true, is(true));
		assertThat(1 + 1, equalTo(2));
		assertThat("hello", not(equalTo("hi")));
	}

}
