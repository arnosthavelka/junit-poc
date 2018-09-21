package com.github.aha.poc.junit5.idm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public interface AdvancedCalc extends SimpleCalc {

	Integer multiply();

	@Test
	default void calculateMultiply() {
		setValues(2, 4, 6);
		Integer result = multiply();
		assertThat(result).isEqualTo(48);
	}

}