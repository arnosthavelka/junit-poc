package com.github.aha.poc.junit.aha;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.runner.RunWith;

@RunWith(SuperRunner.class)
public class BasicSuperTests {

	@SuperTest
	public void simpleAHA() {
		assertThat(true, is(equalTo(true)));
	}

}
