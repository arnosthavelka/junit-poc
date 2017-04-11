package com.github.aha.poc.junit5.intro;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisplayName("Repeated tests in JUnit5")
public class RepeatTest {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(RepeatTest.class);
	
	@RepeatedTest(5)
	@DisplayName("Standard repeated test")
	void standardTest() {
		LOG.info("Standard test");
	}

	@RepeatedTest(value = 3, name = "test {currentRepetition}/{totalRepetitions}")
	@DisplayName("Advanced repeated test")
	void advancedTest(TestInfo ti, RepetitionInfo ri) {
		String name = ti.getTestMethod().get().getName();
		LOG.info("Advanced test  {} of {} for {}", ri.getCurrentRepetition(), ri.getTotalRepetitions(), name);
	}
	
}