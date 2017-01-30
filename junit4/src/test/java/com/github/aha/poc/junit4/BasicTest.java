package com.github.aha.poc.junit4;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

//not required for default runner
//@RunWith(JUnit4.class)
public class BasicTest {

	@Test
	public void simpleJUnit4() {
		assertThat(true, is(equalTo(true)));
	}

}
