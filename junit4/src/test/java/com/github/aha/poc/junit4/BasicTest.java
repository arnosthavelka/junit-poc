package com.github.aha.poc.junit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

//not required for default runner
//@RunWith(JUnit4.class)
public class BasicTest {

	@Test
	public void simpleJUnit4() {
		assertThat(true, is(equalTo(true)));
	}

}
