package com.github.aha.poc.junit4.runner.theory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeTrue;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// https://github.com/junit-team/junit4/wiki/Theories

@RunWith(Theories.class)
public class DataPointTests {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DataPointTests.class);

    @DataPoint
    public static String ARNY = "Arny";

    @DataPoint
    public static String EMPTY = "";
    
    @Theory
	public void stringLength(String name) {
    	LOG.info("Checking name '{}'", name);
		assumeTrue(name.length() > 0);
		LOG.debug("Name '{}' passed the assumption ...", name);
		assertThat(name.toLowerCase().length(), is(equalTo(name.toUpperCase().length())));
	}

}