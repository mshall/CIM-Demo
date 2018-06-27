package com.shall.cim.frontend.util;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shall.cim.frontend.dao.dto.AllComplaintsResponse;
import com.shall.cim.frontend.dao.dto.Complaint;

public class Util {

	public static <T> String convertObjectIntoJson(T clazz) {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(clazz);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("*************** Converted JSON *******************\n" + json);
		return json;
	}

	// -----------------------------------------------------------------------------------
	//
	// -----------------------------------------------------------------------------------
	public static <WRAPPER> WRAPPER parseStringToJsonObject(String retrievedJsonCustomer, Class<WRAPPER> distClass) {

		ObjectMapper mapper = new ObjectMapper();
		try {
			WRAPPER clazz = distClass.newInstance();
			clazz = mapper.readValue(retrievedJsonCustomer, distClass);
			return clazz;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static List<Complaint> getComplaintsList(AllComplaintsResponse response) {
		Complaint[] complaints = response.getResults();
		List<Complaint> complaintsList = new ArrayList<Complaint>();
		for (Complaint complaint : complaints) {
			complaintsList.add(complaint);
		}
		return complaintsList;

	}
}
