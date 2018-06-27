package com.shall.cim.frontend.dao.dto;

public class Constants {

	public final static String GET_ALL_COMPLAINTS = "http://localhost:8082/v1/complaint/all";
	public final static String GET_ALL_COMPLAINTS_FOR_USER = "http://localhost:8082/v1/complaint/?email=";
	public final static String DELETE_COMPLAINT = "http://localhost:8082/v1/complaint/";
	public final static String UPDATE_COMPLAINT = "http://localhost:8082/v1/complaint/";
	public final static String SAVE_COMPLAINT = "http://localhost:8082/v1/complaint/";

	public final static String GET_ALL_USERS = "http://localhost:8081/v1/customer/all";
	public final static String GET_CUSTOMER_BY_EMAIL = "http://localhost:8081/v1/customer/?email=";

}
