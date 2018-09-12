package com.github.aha.poc.junit5.idm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public interface SimpleCalc extends Calc<Integer> {

	Integer sum();

	@Test
	default void calculateSum() {
		setValues(3, 5);
		Integer result = sum();
		assertThat(result).isEqualTo(8);
	}

}