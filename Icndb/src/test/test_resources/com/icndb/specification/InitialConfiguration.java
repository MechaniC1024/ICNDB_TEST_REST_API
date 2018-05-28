package com.icndb.specification;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class InitialConfiguration {

	@BeforeSuite(description = "Initial configuration suite.")
	public void setUpSuite() {
		
		RestAssured.baseURI = "http://api.icndb.com";
		
	}	
}
