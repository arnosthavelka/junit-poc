package com.github.aha.poc.junit5.extension.paramresolver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloTest {
	
	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(HelloTest.class);	
	
	@Test
	@ExtendWith(HelloResolver.class)
	void paramResolverTest(@Hello("Arny") String msg) {
		LOG.info("msg value={}", msg);
		assertThat(msg, equalTo("Hello Arny!"));
	}

}
