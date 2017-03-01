package com.github.aha.poc.junit4.runner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.runner.RunWith;

import com.github.aha.poc.junit4.runner.custom.SuperRunner;
import com.github.aha.poc.junit4.runner.custom.SuperTest;

@RunWith(SuperRunner.class)
public class RunnerTests {

	@SuperTest
	public void simpleSuperRunnerTest() {
		assertThat(true, is(equalTo(true)));
	}

}
