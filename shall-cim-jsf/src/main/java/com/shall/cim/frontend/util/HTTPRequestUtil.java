package com.shall.cim.frontend.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.shall.cim.frontend.dao.dto.AllComplaintsResponse;
import com.shall.cim.frontend.dao.dto.Complaint;
import com.shall.cim.frontend.dao.dto.Constants;

public class HTTPRequestUtil {

	// -----------------------------------------------------------------------------------
	//
	// -----------------------------------------------------------------------------------
	public static List<Complaint> getAllComplaints() {
		// To be used in Customer Party
		String url = Constants.GET_ALL_COMPLAINTS;
		System.out.println("************REQUESTED URL ***************\n" + url);
		HttpGet request = new HttpGet(url);
		String json = executeHttpRequest(request);
		AllComplaintsResponse response = null;
		response = Util.parseStringToJsonObject(json, AllComplaintsResponse.class);
		System.out.println("************ response getAllComplaints: ************ " + response);
		return Util.getComplaintsList(response);
	}

	// -----------------------------------------------------------------------------------
	//
	// -----------------------------------------------------------------------------------
	public static List<Complaint> getAllComplaints(String email) {
		// To be used in Customer Party
		String url = Constants.GET_ALL_COMPLAINTS_FOR_USER + email;
		System.out.println("************REQUESTED URL ***************\n" + url);
		HttpGet request = new HttpGet(url);
		String json = executeHttpRequest(request);
		AllComplaintsResponse response = null;
		response = Util.parseStringToJsonObject(json, AllComplaintsResponse.class);
		System.out.println("************ response getAllComplaints for user: ************ " + response);
		return Util.getComplaintsList(response);
	}

	// -----------------------------------------------------------------------------------
	//
	// -----------------------------------------------------------------------------------
	public static void deleteComplaint(String complaintId) {
		// To be used in Customer Party
		String url = Constants.DELETE_COMPLAINT + complaintId;
		System.out.println("************ REQUESTED URL ***************\n" + url);
		HttpDelete request = new HttpDelete(url);
		String json = executeHttpRequest(request);
		AllComplaintsResponse response = null;
		response = Util.parseStringToJsonObject(json, AllComplaintsResponse.class);
		System.out.println("************ Response delete complaint: ************ " + response);
	}

	// -----------------------------------------------------------------------------------
	//
	// -----------------------------------------------------------------------------------
	public static Complaint saveComplaint(Complaint complaint) {
		String url = Constants.SAVE_COMPLAINT;
		System.out.println("************REQUESTED URL ***************\n" + url);
		HttpPost request = new HttpPost(url);
		StringEntity stringEntity = null;
		try {
			stringEntity = new StringEntity(Util.convertObjectIntoJson(complaint));
			request.setEntity(stringEntity);
			request.setHeader("Content-type", "application/json");
			String response = executeHttpRequest(request);
			return Util.parseStringToJsonObject(response, Complaint.class);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Complaint();

	}

	// -----------------------------------------------------------------------------------
	//
	// -----------------------------------------------------------------------------------
	public static Complaint updateComplaint(Complaint complaint) {
		String url = Constants.SAVE_COMPLAINT;
		System.out.println("************REQUESTED URL ***************\n" + url);
		HttpPatch request = new HttpPatch(url);
		StringEntity stringEntity = null;
		try {
			stringEntity = new StringEntity(Util.convertObjectIntoJson(complaint));
			request.setEntity(stringEntity);
			request.setHeader("Content-type", "application/json");
			String response = executeHttpRequest(request);
			return Util.parseStringToJsonObject(response, Complaint.class);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Complaint();

	}

	// -----------------------------------------------------------------------------------
	//
	// -----------------------------------------------------------------------------------
	private static String executeHttpRequest(HttpUriRequest request) {

		CloseableHttpClient httpclient = null;
		HttpResponse response;
		httpclient = HttpClientBuilder.create().build();
		try {

			response = httpclient.execute(request);
			if (response != null) {
				HttpEntity responseEntity = response.getEntity();
				if (responseEntity != null) {
					return EntityUtils.toString(responseEntity, "UTF-8");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (httpclient != null)
					httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
