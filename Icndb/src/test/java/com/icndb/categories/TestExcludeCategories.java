package com.icndb.categories;

import static com.icndb.resources_data.DataProviderForJokes.getListOfCategories;
import static com.icndb.resources_data.RestUtilities.addAttachmentToReport;
import static com.icndb.resources_data.RestUtilities.assertionType;
import static com.icndb.resources_data.RestUtilities.getJsonPath;
import static com.icndb.specification.UtilitiesRequestSpecification.createParam;
import static com.icndb.specification.UtilitiesRequestSpecification.setEndPoint;
import static com.icndb.specification.UtilitiesResponseSpecification.setStatusCode;
import static io.restassured.RestAssured.given;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.icndb.endPoints.CorrectEndPoints;
import com.icndb.resources_data.DataProviderForJokes;
import com.icndb.specification.InitialConfiguration;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestExcludeCategories extends InitialConfiguration{
	
private static JsonPath getJokesByExcludeCategories(String categor1, String categor2) {
		
		String param = categor1 + "," + categor2;
		Response res = 
		given().
			spec(setEndPoint(CorrectEndPoints.JOKES)).
			spec(createParam("exclude", param)). 
		when().
			get().
		then().
			spec(setStatusCode(200)).
			extract().
			response();
		
		return getJsonPath(res);		
	}
	
	@Test(description = "Checking function limitTo (Positive test).", dataProvider = "positiveExcludeAndLimitTo", dataProviderClass = DataProviderForJokes.class)
	public void testExcludeCategoriesPositive(String categor1, String categor2) {
		
		List<String> listOfCategories = getListOfCategories(categor1, categor2);
		
		JsonPath jsonPath = getJokesByExcludeCategories(categor1, categor2);
		
		assertionType(jsonPath, "success");
		
		addAttachmentToReport("CATEGORIES: ", categor1 + ", " + categor2 + ".");
		
		int countOfCategories = jsonPath.getList("value.id").size();
		
		SoftAssert softAssert = new SoftAssert();
		
		for(int i = 0; i < countOfCategories; i++) {
			
			int id = jsonPath.getInt("value["+i+"].id");
			List<String> catig = jsonPath.getList("value["+i+"].categories");		
						
			boolean contain = Collections.disjoint(catig, listOfCategories);
			
			if(contain == false) {
				softAssert.assertEquals(contain, true);
				addAttachmentToReport("ID = " + id + ": ", catig);
			}			
		}
		
		softAssert.assertAll();		
	}
	
	@Test(description = "Checking function exclude (Negative test).", dataProvider = "negativeExcludeAndLimitTo", dataProviderClass = DataProviderForJokes.class)
	public void testExcludeCategoriesNegative(String categor1, String categor2) {
		
		JsonPath jsonPath = getJokesByExcludeCategories(categor1, categor2);
		
		assertionType(jsonPath, "NoSuchCategoryException");		
	}
	
}
