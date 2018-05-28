package com.icndb.specification;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class UtilitiesResponseSpecification {

	public static ResponseSpecification setStatusCode(int statusCode) {

		ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder();
		responseBuilder.expectContentType(ContentType.JSON);
		responseBuilder.expectStatusCode(statusCode);
		ResponseSpecification responseSpec = responseBuilder.build();
		return responseSpec;
	}
}
