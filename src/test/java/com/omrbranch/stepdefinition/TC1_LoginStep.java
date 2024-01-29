package com.omrbranch.stepdefinition;

import org.junit.Assert;

import com.omrbranch.base.BaseClass_API;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.globaldatas.GlobalData;
import com.omrbranch.pojo.login.Output_Pojo_Root_Login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_LoginStep extends BaseClass_API {

	@Given("user add header")
	public void user_add_header() {
		addHeader("accept", "application/json");

	}

	@When("user add basic authentication {string}, {string} to login")
	public void user_add_basic_authentication_to_login(String emailId, String password) {
		addBasicAuthent(emailId, password);
	}

	@When("user sends {string} request to login endpoint")
	public void user_send_request_to_endpoint(String loginRequestType) {
		response = addRequestType(loginRequestType, Endpoints.loginURL);
	}

	@Then("user should verifies the logged in user firstName {string} and saves the log token")
	public void user_should_verifies_the_logged_in_user_first_name_and_saves_the_log_token(String ExpectedFirstName) {
		Output_Pojo_Root_Login login = response.as(Output_Pojo_Root_Login.class);
		String logtoken = login.getData().getLogtoken();
		globalData.setLogtoken(logtoken);

		String actualFirstName = login.getData().getFirst_name();

		Assert.assertEquals("Verify User First Name", ExpectedFirstName, actualFirstName);

		String message = login.getMessage();
		System.out.println(message);
		System.out.println("Actual response status code for Login " + get_ResponseStatusCode() + " : " + message);
	}

}
