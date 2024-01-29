package com.omrbranch.globaldatas;

import io.restassured.response.Response;

public class GlobalData {
	private  Response response;
	private  String logtoken;
	private  int stateId;
	private  String stateId_Text;
	private  int cityId;
	private  String cityId_Text;
	private  int countryId=101;
	private  int addaddressId;
	private  String addaddressId_Text;
	private  int category_id;
	private  int productId;
	
	
	
	
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public int getAddaddressId() {
		return addaddressId;
	}
	public void setAddaddressId(int addaddressId) {
		this.addaddressId = addaddressId;
	}
	public String getAddaddressId_Text() {
		return addaddressId_Text;
	}
	public void setAddaddressId_Text(String addaddressId_Text) {
		this.addaddressId_Text = addaddressId_Text;
	}
	
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityId_Text() {
		return cityId_Text;
	}
	public void setCityId_Text(String cityId_Text) {
		this.cityId_Text = cityId_Text;
	}
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	public String getLogtoken() {
		return logtoken;
	}
	public void setLogtoken(String logtoken) {
		this.logtoken = logtoken;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateId_Text() {
		return stateId_Text;
	}
	public void setStateId_Text(String stateId_Text) {
		this.stateId_Text = stateId_Text;
	}
	

	
	
	
	
	

}
