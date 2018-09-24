package com.github.aha.poc.junit5.integration.easymock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.github.aha.poc.junit5.integration.Calculator;

@ExtendWith(EasyMockExtension.class)
public class AnnotationTest {

	@org.easymock.Mock
	private Calculator calc;

	@Test
	public void mockExample() {
		expect(calc.add(2, 3)).andReturn(5);
		replay(calc);

		assertThat(calc.add(2, 3)).isEqualTo(5);

		verify(calc);
	}
}
