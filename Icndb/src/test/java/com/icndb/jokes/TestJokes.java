package com.icndb.jokes;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.icndb.endPoints.CorrectEndPoints;
import com.icndb.endPoints.IncorrectEndPoints;
import com.icndb.resources_data.DataProviderForJokes;
import static com.icndb.resources_data.RestUtilities.*;
import com.icndb.specification.InitialConfiguration;

import static com.icndb.specification.UtilitiesRequestSpecification.*;
import static com.icndb.specification.UtilitiesResponseSpecification.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestJokes extends InitialConfiguration{

	@Test(description = "Checking the amount of jokes.")
	public void testCountOfJokes() {
		Response res = 
				given().
						spec(setEndPoint(CorrectEndPoints.COUNT_OF_JOKES)).
				when().
						get().
				then().
						spec(setStatusCode(200)).
						extract().
						response();

		JsonPath jsonPath = getJsonPath(res);
		
		assertionType(jsonPath, "success");	

		int countOfJokes = jsonPath.get("value");		
				
		Assert.assertEquals(countOfJokes, DataProviderForJokes.COUNT_OF_JOKES);	
	}
	
	@Test(description = "Checking the number of displayed jokes.")
	public void testCountOfDisplayedJokes() {
		Response res = 
				given().
						spec(setEndPoint(CorrectEndPoints.JOKES)).
				when().
						get().
				then().
						spec(setStatusCode(200)).
						extract().
						response();

		JsonPath jsonPath = getJsonPath(res);

		assertionType(jsonPath, "success");	
		
		List<String> allJokes = jsonPath.getList("value");		
				
		Assert.assertEquals(allJokes.size(), DataProviderForJokes.COUNT_OF_JOKES);	
	}
		
	private JsonPath getJokesById(String id) {
		
		Response res = 
				given().
						spec(setEndPoint(CorrectEndPoints.ID_JOKE)).
						spec(createPathParam("id", id)).
				when().
						get().
				then().
						spec(setStatusCode(200)).
						extract().
						response();

		return getJsonPath(res);
		
	}	
	
	@Test(description = "Checking jokes by id (Positive test).", dataProvider = "positiveIdJoke", dataProviderClass = DataProviderForJokes.class)
	public void testJokesByIdPositive(String id) {

		JsonPath jsonPath = getJokesById(id);

		assertionType(jsonPath, "success");	
		
		int idJokes = jsonPath.get("value.id");		
				
		Assert.assertEquals(idJokes, Integer.parseInt(id));	
	}
	
	@Test(description = "Checking jokes by id (Negative test).", dataProvider = "negativeIdJoke", dataProviderClass = DataProviderForJokes.class)
	public void testJokesByIdNegative(String id) {
		
		JsonPath jsonPath = getJokesById(id);
		
		assertionType(jsonPath, "NoSuchQuoteException");	
	}
	
	@Test(description = "Checking for incorrect endpoint jokes.")
	public void testIncorrectEndPointJokes() {

			given().
					spec(setEndPoint(IncorrectEndPoints.INCORRECT_END_POINTS_JOK)).
			when().
					get().
			then().
					spec(setStatusCode(404));
	
	}
	
	@Test(description = "Checking for incorrect endpoint after jokes.")
	public void testIncorrectEndPointAfterJokes() {

			given().
					spec(setEndPoint(IncorrectEndPoints.INCORRECT_END_POINTS_AFTER_JOKES)).
			when().
					get().
			then().
					spec(setStatusCode(404));
	
	}
}