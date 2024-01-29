package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;
import com.omrbranch.base.BaseClass_API;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.globaldatas.GlobalData;
import com.omrbranch.payload.Payload_Class;
import com.omrbranch.pojo.address.Add_Address_Output_Root_Pojo;
import org.junit.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC4_AddressStep extends BaseClass_API {

	@Given("user adds headers and passes <Authorization>,<Bearer >+<logtoken> as one of header to addAddress")
	public void user_adds_headers_and_passes_as_one_of_header_to_add_address() {

		List<Header> ref = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + globalData.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");

		ref.add(h3);
		ref.add(h2);
		ref.add(h1);

		Headers headers = new Headers(ref);
		addMultipleHeader(headers);
	}

	@When("user sends {string} request to <AddAddress> endpoint")
	public void user_sends_request_to_add_address_endpoint(String addAddressRequestType) {
		addRequestType(addAddressRequestType, Endpoints.AddAddressURL);
	}

	@When("user adds <First Name>,<Last Name>,<Mobile No>, <stateId>,<cityId>,<countryId>,<Zip code>, <Address>, <Address Type> as payload to the add the userAddress")
	public void user_adds_state_id_city_id_country_id_as_payload_to_the_add_the_user_address() {
		addRequestBody(Payload_Class.addAddress_Payload(globalData.getStateId(), globalData.getCityId(),
				globalData.getCountryId()));

	}

	@Then("user verifies the response body matched the message {string} saves the<addressId>")
	public void user_verifies_the_response_body_matched_the_message_saves_the_address_id(
			String ExpectedAddAddressMessage) {
		Add_Address_Output_Root_Pojo add_Address = response.as(Add_Address_Output_Root_Pojo.class);
		int addressId = add_Address.getAddress_id();
		globalData.setAddaddressId(addressId);

		String addressId_Text = String.valueOf(addressId);
		globalData.setAddaddressId_Text(addressId_Text);
		System.out.println("Address Id: " + addressId);

		String actualAddAddress_message = add_Address.getMessage();
		Assert.assertEquals("Verify Message - Add Address", ExpectedAddAddressMessage, actualAddAddress_message);

		String message = add_Address.getMessage();
		System.out.println("Actual response status code " + get_ResponseStatusCode() + " : " + message);

	}

}
