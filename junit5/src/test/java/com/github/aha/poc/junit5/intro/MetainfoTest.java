package com.github.aha.poc.junit5.intro;


import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.aha.poc.junit5.tag.TagConsts;

@DisplayName("A meta-info usage")
public class MetainfoTest {

	private static final Logger LOG = LoggerFactory.getLogger(MetainfoTest.class);
	
	@Test
	@DisplayName("show UT meta-info data")
	@Tag(TagConsts.A)
	@Tag(TagConsts.FAST)
	void useTestInfo(TestInfo ti) {
		LOG.info("Test name={}", ti.getTestMethod().get().getName());
		LOG.info("Display name={}", ti.getDisplayName());
		ti.getTags().stream().forEach(t -> LOG.info("\ttag={}", t));
	}

	@Test
	@DisplayName("add single value to the test report")
	void useTestReporterWithSingleParam(TestReporter tr) {
        tr.publishEntry("developer", "Arny");
	}

	@Test
	@DisplayName("add more values to the test report")
	void useTestReporterWithMultiParams(TestInfo ti, TestReporter tr) {
        HashMap<String, String> values = new HashMap<>();
        values.put("name", ti.getTestMethod().get().getName());
        values.put("developer", "Arny");
        values.put("poc", "JUnit5");
        tr.publishEntry(values);
	}

}
