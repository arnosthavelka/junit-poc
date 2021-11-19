package com.github.aha.poc.junit4;

import static org.easymock.EasyMock.expect;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.powermock.api.easymock.PowerMock.createMock;
import static org.powermock.api.easymock.PowerMock.mockStatic;
import static org.powermock.api.easymock.PowerMock.replay;
import static org.powermock.api.easymock.PowerMock.verify;

import com.github.aha.poc.junit.person.Person;
import com.github.aha.poc.junit.person.PersonService;
import com.github.aha.poc.junit.person.SequenceGenerator;

// FIXME
//@RunWith(PowerMockRunner.class)
//@PrepareForTest({SequenceGenerator.class, Person.class})
public class PowerMockTest {

//	@Test
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

//	@Test
	public void finalTest() throws Exception {
		int newId = 21;
		
		Person personMock = createMock(Person.class);
		expect(personMock.getId()).andReturn(newId);
		replay(personMock);		

		assertThat(PersonService.store(personMock), is(equalTo(newId)));
		
		verify(personMock);
	}

}
