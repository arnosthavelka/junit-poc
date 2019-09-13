package com.github.aha.poc.junit5.extension.paramresolver;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloTest {

	private static final Logger LOG = LoggerFactory.getLogger(HelloTest.class);

	@Test
	@ExtendWith(HelloResolver.class)
	void paramResolverTest(@Hello("Arny") String msg) {
		LOG.info("msg value={}", msg);
		assertThat(msg).isEqualTo("Hello Arny!");
	}

}
