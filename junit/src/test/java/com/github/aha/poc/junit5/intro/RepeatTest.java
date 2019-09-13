package com.github.aha.poc.junit5.intro;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import lombok.extern.slf4j.Slf4j;

@DisplayName("Repeated tests in JUnit5")
@Slf4j
public class RepeatTest {

	@RepeatedTest(5)
	@DisplayName("Standard repeated test")
	void standardTest() {
		log.info("Standard test");
	}

	@RepeatedTest(value = 3, name = "test {currentRepetition}/{totalRepetitions}")
	@DisplayName("Advanced repeated test")
	void advancedTest(TestInfo ti, RepetitionInfo ri) {
		String name = ti.getTestMethod().get().getName();
		log.info("Advanced test  {} of {} for {}", ri.getCurrentRepetition(), ri.getTotalRepetitions(), name);
	}
	
}