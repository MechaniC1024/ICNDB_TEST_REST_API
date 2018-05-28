package com.icndb.random_jokes;

import static com.icndb.specification.UtilitiesRequestSpecification.*;
import static com.icndb.specification.UtilitiesResponseSpecification.*;
import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.icndb.endPoints.CorrectEndPoints;
import com.icndb.resources_data.DataProviderForJokes;

import static com.icndb.resources_data.RestUtilities.*;
import static com.icndb.resources_data.DataProviderForJokes.*;
import com.icndb.specification.InitialConfiguration;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestRandomJokes extends InitialConfiguration {
	
	@Test(description = "Checking endpoint random jokes.")
	public void testRandomJoke() {

		Response res = 
			given().
					spec(setEndPoint(CorrectEndPoints.RANDOM_JOKE)).
			when().
					get().
			then().
					spec(setStatusCode(200)).
					extract().
					response();
		JsonPath jsonPath = getJsonPath(res);
		
		assertionType(jsonPath, "success");	
		
		int id = jsonPath.getInt("value.id");
		
		String joke = jsonPath.getString("value.joke");
		
		addAttachmentToReport("Randome joke and her id", id + " - " + joke);
	
	}
	
	private JsonPath getCountOfRandomJokes(String count) {
		
		Response res = 
				given().
						spec(setEndPoint(CorrectEndPoints.RANDOM_JOKES)).
						spec(createPathParam("count", count)).
				when().
						get().
				then().
						spec(setStatusCode(200)).
						extract().
						response();

		return getJsonPath(res);
		
	}	
	
	@Test(description = "Check the count of random jokes (Positive test).", dataProvider = "positiveCountOfRandomJokes", dataProviderClass = DataProviderForJokes.class)
	public void testCountOfRandomJokesPositive(String count) {

		JsonPath jsonPath = getCountOfRandomJokes(count);

		assertionType(jsonPath, "success");	
		
		List<Integer> idJokes = jsonPath.get("value.id");		
				
		Assert.assertEquals(idJokes.size(), Integer.parseInt(count));	
	}
	
	@Test(description = "Check the count of random jokes (Negative test).", dataProvider = "negativeCountOfRandomJokes", dataProviderClass = DataProviderForJokes.class)
	public void testCountOfRandomJokesNegative(String count) {
		
		JsonPath jsonPath = getCountOfRandomJokes(count);
		
		assertionType(jsonPath, "NoSuchQuoteException");	
	}
	
	@Test(description = "Checking the change of firstname and lastname in joke.")
	public void testChangeOfFirstnameAndLastname() {
	
		Response resRandomJoke = 
				given().
						spec(setEndPoint(CorrectEndPoints.RANDOM_JOKE)).
						spec(createParam("firstName", FIRST_NAME_OF_CHARACTER)).
						spec(createParam("lastName", LAST_NAME_OF_CHARACTER)).
				when().
						get().
				then().
						spec(setStatusCode(200)).
						extract().
						response();
		
		JsonPath jsonPathRan = getJsonPath(resRandomJoke);
		
		assertionType(jsonPathRan, "success");	
		
		int idJokeRan = jsonPathRan.get("value.id");
		String jokeRan = jsonPathRan.get("value.joke");
		
		Response resJokeById = 
				given().
						spec(setEndPoint(CorrectEndPoints.ID_JOKE)).
						spec(createPathParam("id", idJokeRan)).
				when().
						get().
				then().
						spec(setStatusCode(200)).
						extract().
						response();
		
		JsonPath jsonPath = getJsonPath(resJokeById);
		
		assertionType(jsonPath, "success");	
		
		String joke = jsonPath.get("value.joke");

		addAttachmentToReport("Both jokes", "Joke before change: " + joke + "\n\n" + "Joke after change: " + jokeRan);
		
		Assert.assertNotEquals(jokeRan, joke);		
	}
}