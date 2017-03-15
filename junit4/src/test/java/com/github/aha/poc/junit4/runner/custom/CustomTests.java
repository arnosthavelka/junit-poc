package com.github.aha.poc.junit4.runner.custom;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.runner.RunWith;

@RunWith(SuperRunner.class)
public class CustomTests {

	@SuperTest
	public void simpleSuperRunnerTest() {
		assertThat(true, is(equalTo(true)));
	}

}
