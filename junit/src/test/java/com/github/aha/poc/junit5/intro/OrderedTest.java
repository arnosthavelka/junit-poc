package com.github.aha.poc.junit5.intro;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
@DisplayName("Ordered tests in JUnit5")
public class OrderedTest {

	static AtomicInteger value = new AtomicInteger(1);

	@Test
	@Order(1)
	void firstRun() {
		assertThat(value.getAndIncrement()).isEqualTo(1);
	}

	@Test
	@Order(2)
	void secondRun() {
		assertThat(value.getAndIncrement()).isEqualTo(2);
	}

	@Test
	@Order(3)
	void thirdRun() {
		assertThat(value.getAndIncrement()).isEqualTo(3);
	}

}
