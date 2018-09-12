package com.github.aha.poc.junit.springboot.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = MOCK)
@AutoConfigureMockMvc
public class ControllerRestTest {

	private static final long PRAGUE_ID = 1L;
	private static final String PRAGUE_NAME = "Prague";

	@Autowired
	private MockMvc mvc;

	@Test
	@DisplayName("should list all available cities")
	void listCities() throws Exception {
		mvc.perform(get("/city").contentType(APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON));
	}

	@Test
	@DisplayName("should read one city")
	void getCity() throws Exception {
		mvc.perform(get("/city/{id}", PRAGUE_ID).contentType(APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON)).andExpect(jsonPath("id", is(1)))
				.andExpect(jsonPath("name", is(PRAGUE_NAME)));
	}

}
