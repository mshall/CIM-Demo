package com.shall.cim.frontend.dao.dto;

public class Complaint {

	private String open;

	private String complaintClosingTime;

	private String complaintId;

	private String customerEmail;

	private String comments;

	private String complaintOpeningTime;

	public Complaint() {

	}

	public Complaint(String open, String complaintClosingTime, String complaintId, String customerEmail,
			String comments, String complaintOpeningTime) {
		super();
		this.open = open;
		this.complaintClosingTime = complaintClosingTime;
		this.complaintId = complaintId;
		this.customerEmail = customerEmail;
		this.comments = comments;
		this.complaintOpeningTime = complaintOpeningTime;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getComplaintClosingTime() {
		return complaintClosingTime;
	}

	public void setComplaintClosingTime(String complaintClosingTime) {
		this.complaintClosingTime = complaintClosingTime;
	}

	public String getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(String complaintId) {
		this.complaintId = complaintId;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getComplaintOpeningTime() {
		return complaintOpeningTime;
	}

	public void setComplaintOpeningTime(String complaintOpeningTime) {
		this.complaintOpeningTime = complaintOpeningTime;
	}

}
