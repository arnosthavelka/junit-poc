package com.github.aha.poc.junit4.order;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderedTest {

	@Test
	public void secondTest() {
		assertThat(false, is(equalTo(false)));
	}

	@Test
	public void firstTest() {
		assertThat(true, is(equalTo(true)));
	}

}
