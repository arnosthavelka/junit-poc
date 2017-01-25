package com.github.aha.poc.junit.v4;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

// not required
//@RunWith(JUnit4.class)
public class BasicV4Tests {

	@Test
	public void simpleJUnit4() {
		assertThat(true, is(equalTo(true)));
	}

}
