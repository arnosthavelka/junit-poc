package com.github.aha.poc.junit4;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class TimeoutSimpleTest {

	@Test(timeout=50)
	public void standardTest() {
		assertThat(2, is(equalTo(1 + 1)));
	}	

}
