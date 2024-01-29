package com.omrbranch.stepdefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.base.BaseClass_API;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.payload.Payload_Class;
import com.omrbranch.pojo.change_profilepic.UpdateProfilePicture_Output_RootPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class TC6_ChangeProfilePicStep extends BaseClass_API {

	// TC1_LoginStep.logtoken
	@Given("user adds headers and passes <Authorization>,<Bearer >+<logtoken> and <Content-Type>, <multipart\\/form-data> as header to change the profile pic")
	public void user_adds_headers_and_passes_and_multipart_form_data_as_header_to_change_the_profile_pic() {
		List<Header> header = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + globalData.getLogtoken());
		Header h3 = new Header("Content-Type", "multipart/form-data");

		header.add(h1);
		header.add(h2);
		header.add(h3);

		Headers headers = new Headers(header);
		addMultipleHeader(headers);
	}

	// Payload_Class.ProfilePicPathLocation
	@When("user send the formdata <profile_picture>, <ProfilePic> as payload to change profile pic")
	public void user_send_the_formdata_as_payload_to_change_profile_pic() {
		addFormData("profile_picture", new File(Payload_Class.ProfilePicPathLocation));
	}

	// // Payload_Class.ChangeProfilePicRequestType;
	// // Endpoints.ChangeProfilePicURL
	@When("user sends {string} request to ChangeProfilePic endpoint")
	public void user_send_the_request_to_the(String changeProfilePicRequestType ) {
		response = addRequestType(changeProfilePicRequestType, Endpoints.ChangeProfilePicURL);
	}
	
	// // expectedStatusCode = 200
	// @When("User verifies the response status code is {int} from changeProfilePic
	// response")
	// public void user_verifies_the_response_status_code_is(int expectedStatusCode)
	// {
	// actualStatusCode = get_ResponseStatusCode(response);
	// // System.out.println(statusCode);
	// org.junit.Assert.assertEquals("Verify Status code -- ChangeProfilePic",
	// expectedStatusCode, actualStatusCode);
	// }

	// Payload_Class.ExpectedChangeprofilePicMessage
	@Then("user verifies the response body message matched as {string}")
	public void user_verifies_the_response_body_message_matched_as(String ExpectedChangeprofilePicMessage) {
		UpdateProfilePicture_Output_RootPojo updateProfilePic = response.as(UpdateProfilePicture_Output_RootPojo.class);
		String actualChangeprofilePicMessage = updateProfilePic.getMessage();
		System.out.println(get_ResponseStatusCode() + ": " + actualChangeprofilePicMessage);
		System.out.println(updateProfilePic.getMessage());

		Assert.assertEquals("verify Message - Change Profile Pic", ExpectedChangeprofilePicMessage,
				actualChangeprofilePicMessage);
		System.out.println("======X========X======");
	}

}
