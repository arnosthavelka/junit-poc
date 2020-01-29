package com.github.aha.poc.junit.springboot.rest.assured;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyMap;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import static org.springframework.hateoas.mediatype.MessageResolver.DEFAULTS_ONLY;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.List;

<<<<<<< HEAD
=======
import org.junit.jupiter.api.Disabled;
>>>>>>> branch 'develop' of https://github.com/arnosthavelka/junit-poc
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.mediatype.hal.DefaultCurieProvider;
import org.springframework.hateoas.mediatype.hal.Jackson2HalModule;
import org.springframework.hateoas.server.core.AnnotationLinkRelationProvider;
import org.springframework.hateoas.server.core.DelegatingLinkRelationProvider;
import org.springframework.hateoas.server.core.EvoInflectorLinkRelationProvider;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.plugin.core.OrderAwarePluginRegistry;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.github.aha.poc.junit.springboot.City;
import com.github.aha.poc.junit.springboot.CityController;
import com.github.aha.poc.junit.springboot.CityService;

@SpringBootTest(webEnvironment = MOCK, classes = CityController.class)
public class CityControllerRestAssuredControllerTest {

	private static final String ROOT_PATH = "/cities";
	private static final long PRAGUE_ID = 1L;

	@MockBean
	CityService service;

	@Autowired
	CityController controller;

	@Test
	@DisplayName("should read one city")
	void getCity() {
		when(service.getItem(PRAGUE_ID)).thenReturn(buildCity(999L, "Tokyo"));
		given()
			.standaloneSetup(controller)
		.when()
			.get(ROOT_PATH + "/{id}", PRAGUE_ID)
		.then()
			.statusCode(200)
			.assertThat().header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
			.assertThat().content(
					"id", equalTo(999),
					"name", equalTo("Tokyo"));
	}

	@Test
	@DisplayName("should list cities without HATEOAS conversion")
	void listCitiesWithoutConversion() {
		List<City> cities = asList(buildCity(111L, "Prague"), buildCity(222L, "Madrid"), buildCity(999L, "Tokyo"));
		when(service.getAll()).thenReturn(cities);
		given()
			.standaloneSetup(controller)
		.when()
				.get(ROOT_PATH)
		.then()
		/* expected response:
		 {
		 	"links":[],
		 	"content":[
		 		{"id":111,"name":"Prague","country":null},
		 		{"id":222,"name":"Madrid","country":null},
		 		{"id":999,"name":"Tokyo","country":null}
		 	]
		 }
		 */
			.statusCode(200)
			.assertThat().header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
			.assertThat().body("content.size()", is(3))
			.assertThat().body("content[2].id", equalTo(999))
			.assertThat().body("content[2].name", equalTo("Tokyo"));

	}

	@Test
	@DisplayName("should list cities with HATEOAS conversion")
	void listCitiesWithConversion() {
		List<City> cities = asList(buildCity(111L, "Prague"), buildCity(222L, "Madrid"), buildCity(999L, "Tokyo"));
		when(service.getAll()).thenReturn(cities);
		given()
			.standaloneSetup(standaloneSetup(controller).setMessageConverters(new MappingJackson2HttpMessageConverter(configureObjectMapper())))
		.when()
			.get(ROOT_PATH)
		.then()
		/* expected response: 
		 {
		 	"_embedded":{
		 		"cityResourceList":[
		 			{"id":111,"name":"Prague","country":null},
		 			{"id":222,"name":"Madrid","country":null},
		 			{"id":999,"name":"Tokyo","country":null}
	 			]
 			}
		} */
			.statusCode(200)
			.assertThat().header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
			.assertThat().body(
						"_embedded.cityResources.size()", is(3),
						"_embedded.cityResources[0].id", equalTo(111),
						"_embedded.cityResources[0].name", equalTo("Prague"));
	}


	static City buildCity(Long id, String name) {
		return new City(id, name);
	}

	private static final StdDateFormat DATE_FORMAT = new StdDateFormat().withColonInTimeZone(false);

	private ObjectMapper configureObjectMapper() {
        return Jackson2ObjectMapperBuilder.json()
                .modules(new Jackson2HalModule())
                .handlerInstantiator(
                        new Jackson2HalModule.HalHandlerInstantiator(
                                new DelegatingLinkRelationProvider(
                                        OrderAwarePluginRegistry.of(
                                                new EvoInflectorLinkRelationProvider(),
                                                new AnnotationLinkRelationProvider()
                                        )
                                ),
                                new DefaultCurieProvider(emptyMap()),
                                DEFAULTS_ONLY
                        )
                )
                .featuresToDisable(WRITE_DATES_AS_TIMESTAMPS)
                .dateFormat(DATE_FORMAT)
				.build();
    }
}
