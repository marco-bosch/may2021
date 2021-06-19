package com.jakartalabs.may2021.tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import com.jakartalabs.may2021.utils.DataUtils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class BaseAPITest {

	protected RequestSpecification commonSpec = new RequestSpecBuilder()
			.setBaseUri(DataUtils.getDataFromExcel("Config", "BaseAPIUrl")).setAccept("application/json")
			.setContentType("application/json").build().log().all();

	protected void verifyAPIStatusTimeAndHeader(Response response, int expectedStatusCode) {
		assertEquals(response.getStatusCode(), expectedStatusCode);
		assertEquals(response.getTimeIn(TimeUnit.SECONDS) < 5, true);
		assertEquals(response.getHeader("X-Frame-Options"), "SAMEORIGIN");

	}

	protected <T> T getDataFromResponseUsingJsonPath(Response response, String jsonPath) {

		JsonPath jpath = response.jsonPath();

		return jpath.get(jsonPath);
	}

}
