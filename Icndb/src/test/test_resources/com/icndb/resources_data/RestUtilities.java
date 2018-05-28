package com.icndb.resources_data;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.testng.Assert;

import io.qameta.allure.Allure;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestUtilities {

	public static JsonPath getJsonPath(Response res) {
		String path = res.asString();
		return new JsonPath(path);
	}

	public static void addAttachmentToReport(String name, String content) {

		Allure.addAttachment(name, content);
	}

	public static void addAttachmentToReport(String name, List<String> content) {

		String list = "";

		for (String i : content) {

			list += i + " ";

		}

		ByteArrayInputStream bais = new ByteArrayInputStream(list.getBytes());

		Allure.addAttachment(name, bais);

		try {
			bais.close();
		} catch (IOException e) {
			addAttachmentToReport("Exception: ", e.getMessage());
		}
	}

	public static void assertionType(JsonPath path, String typeStatus) {

		String type = path.get("type");

		Assert.assertEquals(type, typeStatus);
	}
}
