package com.omrbranch.stepdefinition;

import java.util.ArrayList;

import org.junit.Assert;

import com.omrbranch.base.BaseClass_API;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.globaldatas.GlobalData;
import com.omrbranch.payload.Payload_Class;
import com.omrbranch.pojo.statelist.State_Output_Pojo_List_Data;
import com.omrbranch.pojo.statelist.State_Output_Pojo_Root;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC2_StateListStep extends BaseClass_API {

	@Given("user add headers to get the statelist")
	public void user_add_headers_to_get_the_statelist() {
		addHeader("accept", "application/json");
	}

	@When("user sends {string} request to stateList endpoint")
	public void user_send_the_request_to_the(String StateRequestType) {
		response = addRequestType(StateRequestType, Endpoints.getStateIdURL);
	}

	@Then("user verifies the statlist response message and matche <StateName> and saves the <stateId>")
	public void user_verifies_the_statlist_response_message_and_matche_and_saves_the_state_id() {

		State_Output_Pojo_Root getStateID = response.as(State_Output_Pojo_Root.class);
		ArrayList<State_Output_Pojo_List_Data> data = getStateID.getData();

		for (State_Output_Pojo_List_Data eachStateId : data) {
			if (eachStateId.getName().equalsIgnoreCase(Payload_Class.StateName))

			{
				int stateId = eachStateId.getId();
				globalData.setStateId(stateId);

				String stateId_Text = String.valueOf(stateId);
				globalData.setStateId_Text(stateId_Text);

				String actualStateName = eachStateId.getName();

				System.out.println(actualStateName + " :Id is: " + stateId);
				Assert.assertEquals("Verify State Name", Payload_Class.StateName, actualStateName);
				break;
			}
		}
		String message = getStateID.getMessage();
		System.out.println("Actual response status code for get State " + get_ResponseStatusCode() + " : " + message);
	}

}
