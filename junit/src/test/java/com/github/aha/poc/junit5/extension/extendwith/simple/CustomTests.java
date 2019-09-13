package com.github.aha.poc.junit5.extension.extendwith.simple;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(CustomBeforeEach.class)
@Slf4j
public class CustomTests {

	@Test
	@ExtendWith(CustomAfterEach.class)
	void trueTest() {
		log.info("Testing TRUE ...");
		assertThat(true).isTrue();
	}

	@Test
	void falseTest() {
		log.info("Testing FALSE ...");
		assertThat(1 == 2).isFalse();
	}

}
