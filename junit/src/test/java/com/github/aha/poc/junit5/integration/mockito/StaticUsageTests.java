package com.github.aha.poc.junit5.integration.mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import com.github.aha.poc.junit.person.Person;
import com.github.aha.poc.junit.person.SequenceGenerator;

class StaticUsageTests {

	@Test
	void whenWithoutArgument() {
		try (MockedStatic<SequenceGenerator> seqGeneratorMock = mockStatic(SequenceGenerator.class)) {
			seqGeneratorMock.when(SequenceGenerator::nextId).thenReturn(5);

			assertThat(SequenceGenerator.nextId()).isEqualTo(5);
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
	void verifyUsage() {
		try (MockedStatic<SequenceGenerator> seqGeneratorMock = mockStatic(SequenceGenerator.class)) {
			int personId = 66;
			seqGeneratorMock.when(SequenceGenerator::nextId).thenReturn(personId);
			
			var person = new Person("Pamela");

			assertThat(person.getId()).isEqualTo(personId);
			seqGeneratorMock.verify(SequenceGenerator::nextId);
		}
	}
	
}