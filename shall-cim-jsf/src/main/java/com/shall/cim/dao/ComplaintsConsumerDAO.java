package com.shall.cim.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import com.shall.cim.frontend.dao.dto.Complaint;
import com.shall.cim.frontend.util.HTTPRequestUtil;

@Component
public class ComplaintsConsumerDAO {

	public List<Complaint> findAllComplaints() {
		System.out.println("******************** DAO  Getting all complaints ******************");
		return HTTPRequestUtil.getAllComplaints();
	}

	public void persist(Complaint complaint) {
		// Call the webservice that will save the complaint
		System.out.println("******************** DAO  Saving complaint ******************");
		HTTPRequestUtil.saveComplaint(complaint);
	}

	public void merge(Complaint complaint) {
		// Call the webservice that will update the complaint
		System.out.println("******************** DAO Updating complaint ******************");
		HTTPRequestUtil.updateComplaint(complaint);
	}

	public void remove(String complaintId) {
		// Call the webservice that will delete the complaint
		System.out.println("******************** DAO  Removing complaint ******************");
		HTTPRequestUtil.deleteComplaint(complaintId);
	}

}
