package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;
import com.omrbranch.base.BaseClass_API;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.payload.Payload_Class;
import com.omrbranch.pojo.productsearch.Search_Product_Output_DataPojo;
import com.omrbranch.pojo.productsearch.Search_Product_Output_RootPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC5_ProductSearchStep extends BaseClass_API {

	Response response;

	@Given("user added headers to search the product")
	public void user_added_headers_to_search_the_product() {
		List<Header> header = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		header.add(h1);
		header.add(h2);

		Headers headers = new Headers(header);
		addMultipleHeader(headers);
	}

	// Payload_Class.productName
	@When("user sends <ProductName> as payload to the search the product")
	public void user_sends_as_payload_to_the_search_the_product() {
		addRequestBody(com.omrbranch.payload.Payload_Class.searchProduct(Payload_Class.ProductName));
	}

	// Payload_Class.SearchProductRequestType
	// Endpoints.SearchProductURL
	@When("user sends {string} request to SearchProduct endpoint")
	public void user_sends_the_request_to_the(String searchProductRequestType) {
		response = addRequestType(searchProductRequestType, Endpoints.SearchProductURL);
	}


	
//	// expectedStatusCode = 200
//	@When("User verifies the response status code is {int} from the search product response")
//	public void user_verifies_the_response_status_code_is(int expectedStatusCode) {
//		actualStatusCode = get_ResponseStatusCode(response);
//		// System.out.println(statusCode);
//		org.junit.Assert.assertEquals("Verify Status code -- PrductSearch", expectedStatusCode, actualStatusCode);
//	}

//Payload_Class.ProductName
	@Then("user verifies the response body success message as <OK> and <Product Id>, <CatagoryId>")
	public void user_verifies_the_response_body_success_message_as_and() {
		Search_Product_Output_RootPojo search_Product_Response = response.as(Search_Product_Output_RootPojo.class);
		ArrayList<Search_Product_Output_DataPojo> findProduct = search_Product_Response.getData();
		for (Search_Product_Output_DataPojo each_product : findProduct) {

			if (each_product.getText().contains(Payload_Class.ProductName)) {

				int productId = each_product.getId();
				globalData.setProductId(productId);
				
				int category_id = each_product.getCategory_id();
				globalData.setCategory_id(category_id);
				
				System.out.println("Product id: " + productId);
				System.out.println("Product Catagory Id: " + category_id);
				break;
			}

		}
		String message = search_Product_Response.getMessage();
		System.out.println("Actual response status code " + get_ResponseStatusCode() + " : " + message);
		
	}


}
