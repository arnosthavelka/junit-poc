package com.github.aha.poc.junit5.intro;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

import com.github.aha.poc.junit5.tag.TagConsts;

import lombok.extern.slf4j.Slf4j;

@DisplayName("A meta-info usage")
@Slf4j
public class MetainfoTest {

	@Test
	@DisplayName("show UT meta-info data")
	@Tag(TagConsts.A)
	@Tag(TagConsts.FAST)
	void useTestInfo(TestInfo ti) {
		log.info("Test name={}", ti.getTestMethod().get().getName());
		log.info("Display name={}", ti.getDisplayName());
		ti.getTags().stream().forEach(t -> log.info("\ttag={}", t));
		assertThat(true).isTrue();
	}

	@Test
	@DisplayName("add single value to the test report")
	void useTestReporterWithSingleParam(TestReporter tr) {
        tr.publishEntry("developer", "Arny");
		assertThat(true).isTrue();
	}

	@Test
	@DisplayName("add more values to the test report")
	void useTestReporterWithMultiParams(TestInfo ti, TestReporter tr) {
        HashMap<String, String> values = new HashMap<>();
        values.put("name", ti.getTestMethod().get().getName());
        values.put("developer", "Arny");
        values.put("poc", "JUnit5");
        tr.publishEntry(values);
		assertThat(true).isTrue();
	}

}
