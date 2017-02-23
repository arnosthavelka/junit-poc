package com.github.aha.poc.junit4;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Ignore;
import org.junit.Test;

public class TimeoutTest {

	@Test(timeout=50)
	public void standardTest() {
		assertThat(2, is(equalTo(1 + 1)));
	}	

	@Test(timeout=50)
	@Ignore // disabled due to complete build
	public void timeoutingFailFastTest() throws InterruptedException {
		Thread.sleep(100);
		assertThat(2, is(equalTo(1 + 1)));
	}	

}
