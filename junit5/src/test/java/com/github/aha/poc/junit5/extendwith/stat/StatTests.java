package com.github.aha.poc.junit5.extendwith.stat;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stat
public class StatTests {
	
	private static Random rg;
	
	@BeforeAll
	static void init() {
		rg = new Random();
	}
	
	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(StatTests.class);
	
	@Test
	void trueTest() {
		randomWait();
		assertThat(true, equalTo(true));
	}

	@Test
	void falseTest() {
		randomWait();
		assertFalse(1 == 2);
	}
	
	private void randomWait() {
		int waitTime = rg.nextInt(100);
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			LOG.error("Sleep interuppted ...", e);
		}
	}

}
