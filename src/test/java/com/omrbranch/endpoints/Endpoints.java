package com.omrbranch.endpoints;

public interface Endpoints {
	public static final String loginURL = "https://omrbranch.com/api/postmanBasicAuthLogin";
//	or
//	public static final String LOGIN= "https://omrbranch.com/api/postmanBasicAuthLogin";

	public static final String getStateIdURL = "https://omrbranch.com/api/stateList";
	public static final String getCityIdURL = "https://omrbranch.com/api/cityList";
	public static final String AddAddressURL = "https://omrbranch.com/api/addUserAddress";
	public static final String UpdateAddresURL = "https://omrbranch.com/api/updateUserAddress";
	public static final String DeleteAddressURL = "https://omrbranch.com/api/deleteAddress";
	public static final String AllAddressURL = "https://omrbranch.com/api/getUserAddress";
	public static final String ChangeProfilePicURL = "https://omrbranch.com/api/changeProfilePic";
	public static final String SearchProductURL = "https://omrbranch.com/api/searchProduct";

}
