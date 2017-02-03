package com.github.aha.poc.junit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//not required for default runner
//@RunWith(JUnit4.class)
public class BasicTest {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(BasicTest.class);
	
	@Test
	public void simpleTest() {
		LOG.debug("simpleTest");
		assertThat(true, is(equalTo(true)));
	}

	@Test
	@Ignore
	public void disabledTest() {
		LOG.debug("simpleTest");
		assertThat(true, is(equalTo(true)));
	}

}
