package com.github.aha.poc.junit4.powermock;

import static org.easymock.EasyMock.expect;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.powermock.api.easymock.PowerMock.createMock;
import static org.powermock.api.easymock.PowerMock.mockStatic;
import static org.powermock.api.easymock.PowerMock.replay;
import static org.powermock.api.easymock.PowerMock.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.github.aha.poc.junit4.person.Person;
import com.github.aha.poc.junit4.person.PersonService;
import com.github.aha.poc.junit4.person.SequenceGenerator;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SequenceGenerator.class, Person.class})
public class SimplePowerMockTest {

	@Test
	public void staticTest() throws Exception {
		int newId = 21;
		String name = "Arny";
		
		mockStatic(SequenceGenerator.class);
		expect(SequenceGenerator.nextId()).andReturn(newId);
		replay(SequenceGenerator.class);		

		Person person = new Person(name);
		assertThat(person.getId(), is(equalTo(newId)));
		assertThat(person.getName(), is(equalTo(name)));
		
		verify(SequenceGenerator.class);
	}

	@Test
	public void finalTest() throws Exception {
		int newId = 21;
		
		Person personMock = createMock(Person.class);
		expect(personMock.getId()).andReturn(newId);
		replay(personMock);		

		assertThat(PersonService.addName(personMock), is(equalTo(newId)));
		
		verify(personMock);
	}

}
