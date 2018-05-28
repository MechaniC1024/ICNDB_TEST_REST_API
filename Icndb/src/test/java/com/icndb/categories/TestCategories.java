package com.icndb.categories;

import org.testng.annotations.Test;

import com.icndb.endPoints.CorrectEndPoints;
import com.icndb.endPoints.IncorrectEndPoints;
import com.icndb.resources_data.DataProviderForJokes;
import static com.icndb.resources_data.RestUtilities.*;

import static com.icndb.specification.UtilitiesRequestSpecification.*;
import static com.icndb.specification.UtilitiesResponseSpecification.*;

import com.icndb.specification.InitialConfiguration;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;

public class TestCategories extends InitialConfiguration{
	
	@Test(description = "Check the categories of jokes.")
	public void testAllCategories() {

		Response res = 
				given().
						spec(setEndPoint(CorrectEndPoints.CATEGORIES)).
				when().
						get().
				then().
						spec(setStatusCode(200)).
						extract().
						response();

		JsonPath jsonPath = getJsonPath(res);
		
		assertionType(jsonPath, "success");
	
		List<String> listCategorJson = jsonPath.getList("value");		
		Collections.sort(listCategorJson);		
		
		List<String> listCategor = DataProviderForJokes.getListOfAllCategories();
		
    	Assert.assertEquals(listCategorJson, listCategor);		

	}
	
	@Test(description = "Checking for incorrect endpoint categories.")
	public void testIncorrectCategories() {

			given().
					spec(setEndPoint(IncorrectEndPoints.INCORRECT_END_POINTS_CATEGO)).
			when().
					get().
			then().
					spec(setStatusCode(404));	

	}
}
