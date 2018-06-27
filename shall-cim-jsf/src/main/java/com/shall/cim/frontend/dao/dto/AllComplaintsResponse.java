package com.shall.cim.frontend.dao.dto;

public class AllComplaintsResponse {
	private String message;
	private Complaint[] results;

	public AllComplaintsResponse() {

	}

	public AllComplaintsResponse(Complaint[] results) {
		super();
		this.results = results;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Complaint[] getResults() {
		return results;
	}

	public void setResults(Complaint[] results) {
		this.results = results;
	}

}