package com.github.aha.poc.junit5.lifecycle;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PerClassIsolationTest {

	private static final int INCREMENT_VALUE = 5;

	private static final int ADDITIONAL_ROUNDS = 3;

	private int countedValue;

	private int roundOfCalculation;

	@BeforeAll
	void initClassByJunit() {
		countedValue = 0;
		countedValue = 0;
	}

	@BeforeEach
	void initTest() {
		roundOfCalculation++;
		countedValue = roundOfCalculation * INCREMENT_VALUE;
	}

	@Test
	void firstRound() {
		assertThat(roundOfCalculation).isEqualTo(countedValue / INCREMENT_VALUE);
	}

	@RepeatedTest(ADDITIONAL_ROUNDS)
	void additionalRounds() {
		assertThat(countedValue / INCREMENT_VALUE).isEqualTo(roundOfCalculation);
	}

	@AfterAll
	void destroyTest() {
		assertThat(roundOfCalculation).isEqualTo(ADDITIONAL_ROUNDS + 1);
	}

}
