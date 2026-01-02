package com.github.aha.poc.junit.springboot.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = MOCK)
@AutoConfigureMockMvc
class CityControllerSpringTest {

	private static final String ROOT_PATH = "/cities";
	private static final Long PRAGUE_ID = 1L;
	private static final String PRAGUE_NAME = "Prague";

	@Autowired
	private MockMvc mvc;

	@Test
	void listAllCities() throws Exception {
		mvc.perform(get(ROOT_PATH)
				.contentType(APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON));
	}

	@Test
	void getSingleCity() throws Exception {
		mvc.perform(get(ROOT_PATH + "/{id}", PRAGUE_ID)
				.contentType(APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
				.andExpect(jsonPath("id", is(1)))
				.andExpect(jsonPath("name", is(PRAGUE_NAME)));
	}

}
