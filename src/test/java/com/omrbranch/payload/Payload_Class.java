package com.omrbranch.payload;

import com.omrbranch.pojo.address.input_Pojo_Root_Address;
import com.omrbranch.pojo.citylist.GetCity_Input_Pojo_Root;
import com.omrbranch.pojo.productsearch.Search_Product_Input_RootPojo;

public class Payload_Class {

	public final static String EMAILID = "dassdowney@gmail.com";
	public final static String PASSWORD = "Testing@12";
	public final static String StateName = "Tamil Nadu";
	public final static String CityName = "Chennai";
	public final static String ProductName = "Paper Boat Roasted";
	public final static String ProfilePicPathLocation = "C:\\Users\\arock\\eclipse-workspace\\API_\\src\\test\\resources\\ProfilePic\\plan_de_travail_1.png";

	
	public final static String FName="Darrien";
	public final static String LName="Snow";
	public final static String MobileNo="7010322487";
	public final static String Appartment="Dev Appartment";
	public final static String ZipCode="600097";
	public final static String Address="Thoraipakkam";
	public final static String AddressType="Home";
	
	public final static String ExpectedAddAddressMessage="Address added successfully";
	public final static String ExpectedChangeprofilePicMessage="Profile updated Successfully";
	
	public static GetCity_Input_Pojo_Root getCityId_Payload(String stateid) {
		GetCity_Input_Pojo_Root getCity_Input_Pojo_Root = new GetCity_Input_Pojo_Root(stateid);
		return getCity_Input_Pojo_Root;
	}

	public static input_Pojo_Root_Address addAddress_Payload(int stateId, int cityId, int countryId) {
//		input_Pojo_Root_Address input_Pojo_Root_Address = new input_Pojo_Root_Address("Darrien", "Snow", "7010322487",
//				"Dev", stateId, cityId, countryId, "600097", "Thoraipakkam", "Home");
		input_Pojo_Root_Address input_Pojo_Root_Address = new input_Pojo_Root_Address(FName, LName, MobileNo, 
				Appartment, stateId, cityId, countryId, ZipCode, Address, AddressType);
		return input_Pojo_Root_Address;
	}

//	public UpdateAddress_Input_RootPojo updateAddress_Payload(String addressId_Text, int stateId, int cityId,
//			int countryId) {
//		UpdateAddress_Input_RootPojo updateAddress_Input_RootPojo = new UpdateAddress_Input_RootPojo(addressId_Text,
//				"Dass", "Downey", "9788836570", "Kalaimathi", stateId, cityId, countryId, "620017", "Muthuraja St",
//				"Home");
//		return updateAddress_Input_RootPojo;
//	}
//
//	public Delete_Address_Input_RootPojo deleteAddress_Payload(String addressId_Text) {
//		Delete_Address_Input_RootPojo delete_Address_Input_RootPojo = new Delete_Address_Input_RootPojo(addressId_Text);
//		return delete_Address_Input_RootPojo;
//
//	}

	public static Search_Product_Input_RootPojo searchProduct(String prductName) {
		Search_Product_Input_RootPojo search_Product_Input_RootPojo = new Search_Product_Input_RootPojo(prductName);
		return search_Product_Input_RootPojo;

	}

}
