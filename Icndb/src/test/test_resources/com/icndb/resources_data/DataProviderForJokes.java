package com.icndb.resources_data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import static com.icndb.resources_data.RestUtilities.*;

public class DataProviderForJokes {

	public static final int COUNT_OF_JOKES = 558;
	public static final String FIRST_NAME_OF_CHARACTER = "Kevin";
	public static final String LAST_NAME_OF_CHARACTER = "Smith";

	private static String pathToCategory = "src\\test\\test_resources\\com\\icndb\\resources_data\\Categories.properties";
	private static String keyCategories = "categories";

	private static List<String> getListProperty(InputStream fileProper, String key) {

		Properties prop = new Properties();

		try {
			prop.load(fileProper);
		} catch (IOException e) {
			addAttachmentToReport("Exception: IOException", e.getMessage());
		}

		String strCategor = prop.getProperty(key);
		List<String> listCategor = Arrays.asList(strCategor.split(","));
		Collections.sort(listCategor);
		return listCategor;
	}

	public static List<String> getListOfAllCategories() {
		List<String> listCategor = new ArrayList<>();
		try {
			listCategor = getListProperty(new FileInputStream(pathToCategory), keyCategories);
		} catch (FileNotFoundException e) {
			addAttachmentToReport("Exception: FileNotFoundException", e.getMessage());
		}
		return listCategor;
	}
		
	@DataProvider
	public Object[][] positiveIdJoke() {
		return new Object[][] { { "1" }, { "385" }, { "603" } };
	}

	@DataProvider
	public Object[][] negativeIdJoke() {
		return new Object[][] { { "0" }, { "-1" }, { "1.5" } };
	}
	
	@DataProvider
	public Object[][] positiveCountOfRandomJokes() {
		return new Object[][] { { "1" }, { "558" }, { "300" }, { "1000" } };
	}

	@DataProvider
	public Object[][] negativeCountOfRandomJokes() {
		return new Object[][] { { "0" }, { "-1" }, { "1.5" }, { "qwery" } };
	}
	
	@DataProvider
	public Object[][] positiveExcludeAndLimitTo() {
		return new Object[][] { { "explicit", "" }, { "explicit", "nerdy" }, { "nerdy", "" } };
	}	
	
	@DataProvider
	public Object[][] negativeExcludeAndLimitTo() {
		return new Object[][] { { "qwerty", "" }, { "qwerty", "123" }, { "", "" }, { "explicit", "qwerty" } };
	}
	
	public static List<String> getListOfCategories(String ...categor){
		
		List<String> listOfCategor = new LinkedList<>();
		
		for(int i = 0; i < categor.length; i++) {
			listOfCategor.add(categor[i]);
		}
		return listOfCategor;		
	}
}