package com.github.aha.poc.junit5.extension.extendwith.stat;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stat
public class StatTests {

	private static final Logger LOG = LoggerFactory.getLogger(StatTests.class);

	private static Random rg;

	@BeforeAll
	static void init() {
		rg = new Random();
	}

	@Test
	void trueTest() {
		randomWait();
		assertThat(true).isTrue();
	}

	@Test
	void falseTest() {
		randomWait();
		assertThat(1 == 2).isFalse();
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
