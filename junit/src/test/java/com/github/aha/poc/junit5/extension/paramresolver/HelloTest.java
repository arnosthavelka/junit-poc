package com.github.aha.poc.junit5.extension.paramresolver;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloTest {

	@Test
	@ExtendWith(HelloResolver.class)
	void paramResolverTest(@Hello("Arny") String msg) {
		log.info("msg value={}", msg);
		assertThat(msg).isEqualTo("Hello Arny!");
	}

}
