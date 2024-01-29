package com.omrbranch.pojo.citylist;

import java.util.ArrayList;

public class CityList_Output_Pojo_Root {
	public int status;
	public String message;
	public ArrayList<CityList_Data_Output_Pojo> data;

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

	public ArrayList<CityList_Data_Output_Pojo> getData() {
		return data;
	}

	public void setData(ArrayList<CityList_Data_Output_Pojo> data) {
		this.data = data;
	}

}
