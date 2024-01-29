package com.omrbranch.pojo.productsearch;

import java.util.ArrayList;

public class Search_Product_Output_RootPojo {

	public int status;
	public String message;
	public ArrayList<Search_Product_Output_DataPojo> data;
	public String currency;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<Search_Product_Output_DataPojo> getData() {
		return data;
	}

	public void setData(ArrayList<Search_Product_Output_DataPojo> data) {
		this.data = data;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
