package com.github.aha.poc.junit.springboot.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = MOCK)
@AutoConfigureRestDocs
@AutoConfigureMockMvc
public class CityControllerRestDocsTest {

	private static final String ROOT_PATH = "/cities";
	private static final long PRAGUE_ID = 1L;
	private static final String PRAGUE_NAME = "Prague";

	@Autowired
	private MockMvc mvc;

	@Test
	@DisplayName("should list all available cities")
	void listCities() throws Exception {
		mvc.perform(get(ROOT_PATH).contentType(APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
				.andDo(document("city-list",
						preprocessRequest(prettyPrint()),
						preprocessResponse(prettyPrint()),
						responseHeaders(headerWithName("Content-Type")
								.description("The Content-Type of the payload, e.g. `application/hal+json`"))));
	}

	@Test
	@DisplayName("should read one city")
	void getCity() throws Exception {
		mvc.perform(get(ROOT_PATH + "/{id}", PRAGUE_ID).contentType(APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON)).andExpect(jsonPath("id", is(1)))
				.andExpect(jsonPath("name", is(PRAGUE_NAME)))
				.andDo(document("city-get",
						pathParameters(parameterWithName("id").description("Identifier of the city")),
						responseFields(fieldWithPath("id").description("Unique identifier of the city."),
								fieldWithPath("name").description("Name of the city."),
								fieldWithPath("country").description("Name of the country the city belong to."))));
	}

}
