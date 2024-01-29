package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.base.BaseClass_API;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.payload.Payload_Class;
import com.omrbranch.pojo.citylist.CityList_Data_Output_Pojo;
import com.omrbranch.pojo.citylist.CityList_Output_Pojo_Root;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.nl.En;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC3_CityListStep extends BaseClass_API {

	@Given("user adds the header to get the citylist")
	public void user_adds_the_header_to_get_the_citylist() {
		List<Header> header = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");

		header.add(h1);
		header.add(h2);

		Headers headers = new Headers(header);
		addMultipleHeader(headers);

	}

	@When("user add {string} as payload request body to get the CityList")
	public void user_add_state_id_as_payload_request_body_to_get_the_city_list(String stateId_Text) {
		addRequestBody(Payload_Class.getCityId_Payload(globalData.getStateId_Text()));

	}

	@When("user sends {string} request to CityList endpoint")
	public void user_send_the_request_to_the(String CityRequestType) {
		response = addRequestType(CityRequestType, Endpoints.getCityIdURL);

	}

	@Then("user verifies the response body matches the <CityName> and saves the <CityId>")
	public void user_verifies_the_response_body_matches_the_and_saves_the_city_id() {
		CityList_Output_Pojo_Root getCityId = response.as(CityList_Output_Pojo_Root.class);
		ArrayList<CityList_Data_Output_Pojo> cityId_array = getCityId.getData();

		for (int i = 0; i < cityId_array.size(); i++) {
			if (getCityId.getData().get(i).getName().equalsIgnoreCase(Payload_Class.CityName)) {
				// int cityID = cityId.get(i).getId();
				// OR
				int cityId = getCityId.getData().get(i).getId();
				globalData.setCityId(cityId);

				String cityId_Text = String.valueOf(cityId);
				globalData.setCityId_Text(cityId_Text);

				String actualCityName = getCityId.getData().get(i).getName();

				System.out.println(Payload_Class.CityName + " :Id is: " + globalData.getCityId());
				Assert.assertEquals("Verify City Name", Payload_Class.CityName, actualCityName);
				break;
			}

		}
		String message = getCityId.getMessage();
		System.out.println("Actual response status code for get City " + get_ResponseStatusCode() + " : " + message);

	}

}
