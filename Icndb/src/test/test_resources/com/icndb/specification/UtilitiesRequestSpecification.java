package com.icndb.specification;

import com.icndb.endPoints.EndPoints;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class UtilitiesRequestSpecification {
	
	private static RequestSpecification requestSpec;
	
	public static RequestSpecification setEndPoint(EndPoints endPoint) {

		RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
		requestBuilder.addFilter(new AllureRestAssured());
		requestBuilder.setBasePath(endPoint.endPoint());
		requestSpec = requestBuilder.build();
		return requestSpec;
	}
	
	public static RequestSpecification createPathParam(String param, String value) {
		
		return requestSpec.pathParam(param, value);
	}
	
	public static RequestSpecification createPathParam(String param, int value) {
		
		return requestSpec.pathParam(param, value);
	}

	public static RequestSpecification createParam(String param, String value) {
		
		return requestSpec.param(param, value);
	}
		
}