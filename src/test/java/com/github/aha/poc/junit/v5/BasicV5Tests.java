package com.github.aha.poc.junit.v5;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

// http://stackoverflow.com/questions/38402155/eclipse-junit-5-support
@RunWith(JUnitPlatform.class)
@DisplayName("JUnit5")
public class BasicV5Tests {

	@Test
	@DisplayName("First Test")
	public void runJUnit5() {
		assertThat(true, is(equalTo(true)));
	}

}
