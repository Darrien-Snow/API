package com.omrbranch.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.omrbranch.globaldatas.GlobalData;
import com.omrbranch.stepdefinition.CommonStep;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass_API {
	public RequestSpecification reqSpec;
	public Response response;
	public static GlobalData globalData=new GlobalData();

	public void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}

	public void addMultipleHeader(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);
	}

	public void addFormData(String key, File file) {
		reqSpec = reqSpec.multiPart(key, file);

	}

	public void addRequestBody(Object refName) {
		reqSpec = reqSpec.body(refName);
	}

	public void addRequestBody(String body) {
		reqSpec = reqSpec.body(body);
	}

	public Response addRequestType(String type, String endPoint_Url) {
		switch (type) {
		case "GET":
			response = reqSpec.get(endPoint_Url);
			break;

		case "POST":
			response = reqSpec.post(endPoint_Url);
			break;

		case "PUT":
			response = reqSpec.put(endPoint_Url);
			break;

		case "PATCH":
			response = reqSpec.patch(endPoint_Url);
			break;

		case "DELETE":
			response = reqSpec.delete(endPoint_Url);
			break;

		default:
			break;
		}
		globalData.setResponse(response);
		return response;
	}

	public int get_ResponseStatusCode() {
		int statusCode = globalData.getResponse().getStatusCode();
		return statusCode;

	}

	public String get_ResponsePrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;
	}

	public String asString(Response response) {
		String asString = response.asString();
		return asString;
	}

	public void addBasicAuthent(String userName, String Password) {
		reqSpec = reqSpec.auth().preemptive().basic(userName, Password);

	}

	public String getPropertyValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(
				"C:\\Users\\arock\\eclipse-workspace\\OMRBranchAPIAutomation\\src\\test\\resources\\PropertyFile\\datas.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}

}
