package com.omrbranch.pojo.statelist;

import java.util.ArrayList;

public class State_Output_Pojo_Root {
	public int status;
	public String message;
	public ArrayList<State_Output_Pojo_List_Data> data;

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

	public ArrayList<State_Output_Pojo_List_Data> getData() {
		return data;
	}

	public void setData(ArrayList<State_Output_Pojo_List_Data> data) {
		this.data = data;
	}

}
