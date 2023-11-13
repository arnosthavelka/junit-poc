package com.github.aha.poc.junit5.integration.mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import com.github.aha.poc.junit.person.SequenceGenerator;

class StaticUsageTests {

	@Test
	void mockStaticNoArgValue() {
		try (MockedStatic<SequenceGenerator> seqGeneratorMock = mockStatic(SequenceGenerator.class)) {
			seqGeneratorMock.when(SequenceGenerator::nextId).thenReturn(5);

			assertThat(SequenceGenerator.nextId()).isEqualTo(5);
		}
	}

	@Test
	void mockStaticWithArgValue() {
		try (MockedStatic<SequenceGenerator> seqGeneratorMock = mockStatic(SequenceGenerator.class)) {
			int newValuesSize = 5;
			seqGeneratorMock.when(() -> SequenceGenerator.nextMultipleIds(newValuesSize))
					.thenReturn(List.of(1, 2, 3, 4, 5));

			assertThat(SequenceGenerator.nextMultipleIds(newValuesSize)).hasSize(newValuesSize);
		}
	}
	
}