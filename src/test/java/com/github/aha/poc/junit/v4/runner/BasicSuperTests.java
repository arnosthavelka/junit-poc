package com.github.aha.poc.junit.v4.runner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.runner.RunWith;

@RunWith(SuperRunner.class)
public class BasicSuperTests {

	@SuperTest
	public void simpleSuperRunnerTest() {
		assertThat(true, is(equalTo(true)));
	}

}
