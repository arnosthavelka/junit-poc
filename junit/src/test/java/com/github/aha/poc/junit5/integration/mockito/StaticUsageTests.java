package com.github.aha.poc.junit5.integration.mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;

import com.github.aha.poc.junit.person.Person;
import com.github.aha.poc.junit.person.SequenceGenerator;

class StaticUsageTests {

	@Test
	void whenWithoutArgument() {
		try (MockedStatic<SequenceGenerator> seqGeneratorMock = mockStatic(SequenceGenerator.class)) {
			int newValue = 5;
			seqGeneratorMock.when(SequenceGenerator::nextId).thenReturn(newValue);

			assertThat(SequenceGenerator.nextId()).isEqualTo(newValue);
		}
	}

	@Test
	void whenWithArgument() {
		try (MockedStatic<SequenceGenerator> seqGeneratorMock = mockStatic(SequenceGenerator.class)) {
			int newValuesCount = 5;
			seqGeneratorMock.when(() -> SequenceGenerator.nextMultipleIds(newValuesCount))
					.thenReturn(List.of(1, 2, 3, 4, 5));

			assertThat(SequenceGenerator.nextMultipleIds(newValuesCount)).hasSize(newValuesCount);
		}
	}
	
	@Test
	void verifyUsageWithoutArgument() {
		try (MockedStatic<SequenceGenerator> seqGeneratorMock = mockStatic(SequenceGenerator.class)) {
			
			var person = new Person("Pamela");

			seqGeneratorMock.verify(SequenceGenerator::nextId);
			assertThat(person.getId()).isEqualTo(0);
		}
	}

	@Test
	void verifyUsageWithArgument() {
		try (MockedStatic<SequenceGenerator> seqGeneratorMock = mockStatic(SequenceGenerator.class)) {
			List<Integer> nextIds = SequenceGenerator.nextMultipleIds(3);
			
			seqGeneratorMock.verify(() -> SequenceGenerator.nextMultipleIds(ArgumentMatchers.anyInt()));
			assertThat(nextIds).isEmpty();
		}
	}
	
}