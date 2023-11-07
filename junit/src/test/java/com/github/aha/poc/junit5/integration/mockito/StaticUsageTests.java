package com.github.aha.poc.junit5.integration.mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import com.github.aha.poc.junit.person.SequenceGenerator;

class StaticUsageTests {

	@Test
	void mockStaticNoArgValue() {
	    try (MockedStatic<SequenceGenerator> utilities = mockStatic(SequenceGenerator.class)) {
	        utilities.when(SequenceGenerator::nextId).thenReturn(5);
	        
	        assertThat(SequenceGenerator.nextId()).isEqualTo(5);
	    }
	}

}