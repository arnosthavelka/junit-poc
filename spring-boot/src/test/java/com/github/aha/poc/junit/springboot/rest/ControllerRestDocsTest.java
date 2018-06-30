package com.github.aha.poc.junit.springboot.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith({ RestDocumentationExtension.class, SpringExtension.class })
@SpringBootTest(webEnvironment = MOCK)
@AutoConfigureMockMvc
public class ControllerRestDocsTest {

	private static final long PRAGUE_ID = 1L;
	private static final String PRAGUE_NAME = "Prague";

	private static final String CITY_PATH = "/city/";

	// @Autowired
	private MockMvc mvc;

	@BeforeEach
	public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
		this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.apply(documentationConfiguration(restDocumentation))
				.alwaysDo(
						document("{method-name}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())))
				.build();
	}

	@Test
	@DisplayName("should list all available cities")
	void listAllFiles() throws Exception {
		mvc.perform(get(CITY_PATH)
				.contentType(APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
				.andDo(
						document("city-list", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint()),
								responseHeaders(headerWithName("Content-Type")
										.description("The Content-Type of the payload, e.g. `application/hal+json`"))));
	}

	@Test
	@Disabled
	@DisplayName("should read one GFDM file")
	void getFile() throws Exception {
		mvc.perform(get(CITY_PATH + PRAGUE_ID)
				.contentType(APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON)).andExpect(jsonPath("id", is(1)))
				.andExpect(jsonPath("name", is(PRAGUE_NAME)))
				.andDo(document("city-get",
						pathParameters(parameterWithName("id").description("The id of the input to retrieve"))));

	}

}
