package com.omrbranch.stepdefinition;

import org.junit.Assert;

import com.omrbranch.base.BaseClass_API;

import io.cucumber.java.en.When;

public class CommonStep extends BaseClass_API {

	// expectedStatusCode = 200
	@When("user should verify the status code {int} from the response")
	public void user_should_verify_the_status_code_from_the_response(int expectedStatusCode) {
		int actualStatusCode = get_ResponseStatusCode();
		Assert.assertEquals("Verify status code", expectedStatusCode, actualStatusCode);
	}

}
